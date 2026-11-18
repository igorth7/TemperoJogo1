package com.igor.tempero

import android.util.Log
import com.google.firebase.Firebase
import com.google.firebase.firestore.Query
import com.google.firebase.firestore.firestore
import kotlinx.coroutines.channels.awaitClose
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.callbackFlow
import kotlinx.coroutines.flow.flowOf

// Um resultado do ranking (o que fica salvo no Firebase)
data class Resultado(val nome: String, val nivel: String, val pontos: Int)

// 8) Fala com o Firebase Firestore (banco de dados na nuvem do Google)
object RankingFirebase {
    private const val TAG = "RankingFirebase"
    private const val COLECAO = "ranking"   // a "tabela" no Firestore

    /** Salva o resultado de uma partida na nuvem. */
    fun salvar(nome: String, nivel: String, pontos: Int) {
        if (!ConfigFirebase.configurado) return

        val dados = hashMapOf(
            "nome" to nome,
            "nivel" to nivel,
            "pontos" to pontos,
            "data" to System.currentTimeMillis()
        )
        Firebase.firestore.collection(COLECAO)
            .add(dados)
            .addOnSuccessListener { Log.d(TAG, "Resultado salvo no Firebase") }
            .addOnFailureListener { erro -> Log.e(TAG, "Erro ao salvar no Firebase", erro) }
    }

    /**
     * FLOW: observa os 10 melhores resultados em tempo real.
     * Toda vez que alguém salva uma partida, o Firestore avisa e o Flow
     * emite a lista nova, então a tela de ranking se atualiza sozinha.
     */
    fun observarTop10(): Flow<List<Resultado>> {
        if (!ConfigFirebase.configurado) return flowOf(emptyList())

        return callbackFlow {
            val ouvinte = Firebase.firestore.collection(COLECAO)
                .orderBy("pontos", Query.Direction.DESCENDING)
                .limit(10)
                .addSnapshotListener { resposta, erro ->
                    if (erro != null) {
                        Log.e(TAG, "Erro ao observar o ranking", erro)
                        return@addSnapshotListener
                    }
                    val lista = resposta?.documents?.map { documento ->
                        Resultado(
                            nome = documento.getString("nome") ?: "?",
                            nivel = documento.getString("nivel") ?: "",
                            pontos = (documento.getLong("pontos") ?: 0L).toInt()
                        )
                    } ?: emptyList()
                    trySend(lista)   // manda a lista nova para quem está observando
                }

            // Quando a tela fecha, para de observar o Firestore
            awaitClose { ouvinte.remove() }
        }
    }
}
