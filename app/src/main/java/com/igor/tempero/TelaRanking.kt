package com.igor.tempero

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.systemBarsPadding
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.OutlinedButton
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateListOf
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

// 11) Ranking online: busca no Firebase os 10 melhores resultados
@Composable
fun TelaRanking(aoVoltar: () -> Unit) {
    val ranking = remember { mutableStateListOf<Resultado>() }
    var carregando by remember { mutableStateOf(true) }

    // Quando a tela abre, busca no Firebase
    LaunchedEffect(Unit) {
        RankingFirebase.buscarTop10 { lista ->
            ranking.clear()
            ranking.addAll(lista)
            carregando = false
        }
    }

    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(Creme)
            .systemBarsPadding()
            .verticalScroll(rememberScrollState())
            .padding(24.dp),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.spacedBy(10.dp)
    ) {
        Text("🌐 Ranking online", fontSize = 28.sp, fontWeight = FontWeight.Bold)
        Text("Salvo no Firebase (Firestore)", color = Color.Gray)

        when {
            !ConfigFirebase.configurado -> Text("⚠️ Firebase ainda não configurado (veja ConfigFirebase.kt)", color = Vermelho)
            carregando -> Text("Carregando...")
            ranking.isEmpty() -> Text("Ninguém jogou ainda. Seja o primeiro!")
        }

        ranking.forEachIndexed { posicao, resultado ->
            val medalha = when (posicao) {
                0 -> "🥇"
                1 -> "🥈"
                2 -> "🥉"
                else -> "${posicao + 1}º"
            }
            Row(
                modifier = Modifier
                    .fillMaxWidth()
                    .clip(RoundedCornerShape(14.dp))
                    .background(Color.White)
                    .padding(14.dp),
                verticalAlignment = Alignment.CenterVertically
            ) {
                Text(medalha, fontSize = 22.sp)
                Column(
                    modifier = Modifier
                        .weight(1f)
                        .padding(horizontal = 12.dp)
                ) {
                    Text(resultado.nome, fontSize = 16.sp, fontWeight = FontWeight.Bold)
                    Text("Nível ${resultado.nivel}", fontSize = 13.sp, color = Color.Gray)
                }
                Text("${resultado.pontos} pts", fontSize = 18.sp, color = Laranja, fontWeight = FontWeight.Bold)
            }
        }

        OutlinedButton(onClick = aoVoltar, modifier = Modifier.fillMaxWidth()) {
            Text("👤 Voltar ao perfil")
        }
    }
}
