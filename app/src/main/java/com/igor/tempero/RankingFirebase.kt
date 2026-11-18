package com.igor.tempero

import android.util.Log
import com.google.firebase.Firebase
import com.google.firebase.firestore.Query
import com.google.firebase.firestore.firestore

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

    /** Busca os 10 melhores resultados (maior pontuação primeiro). */
    fun buscarTop10(aoReceber: (List<Resultado>) -> Unit) {
        if (!ConfigFirebase.configurado) {
            aoReceber(emptyList())
            return
        }

        Firebase.firestore.collection(COLECAO)
            .orderBy("pontos", Query.Direction.DESCENDING)
            .limit(10)
            .get()
            .addOnSuccessListener { resposta ->
                val lista = resposta.documents.map { documento ->
                    Resultado(
                        nome = documento.getString("nome") ?: "?",
                        nivel = documento.getString("nivel") ?: "",
                        pontos = (documento.getLong("pontos") ?: 0L).toInt()
                    )
                }
                aoReceber(lista)
            }
            .addOnFailureListener { erro ->
                Log.e(TAG, "Erro ao buscar o ranking", erro)
                aoReceber(emptyList())
            }
    }
}
