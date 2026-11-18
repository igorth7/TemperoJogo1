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
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

// 10) Tela de desafios: mostra quais o jogador já cumpriu
@Composable
fun TelaDesafios(perfil: Perfil, aoVoltar: () -> Unit) {
    val cumpridos = desafios.count { it.cumprido(perfil) }

    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(Creme)
            .systemBarsPadding()
            .verticalScroll(rememberScrollState())
            .padding(24.dp),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.spacedBy(12.dp)
    ) {
        Text("🎯 Desafios", fontSize = 28.sp, fontWeight = FontWeight.Bold)
        Text("$cumpridos de ${desafios.size} cumpridos", fontSize = 18.sp, color = Laranja, fontWeight = FontWeight.Bold)

        desafios.forEach { desafio ->
            val feito = desafio.cumprido(perfil)
            Row(
                modifier = Modifier
                    .fillMaxWidth()
                    .clip(RoundedCornerShape(14.dp))
                    .background(if (feito) Color(0xFFE8F5E9) else Color.White)
                    .padding(16.dp),
                verticalAlignment = Alignment.CenterVertically
            ) {
                Text(desafio.emoji, fontSize = 28.sp)
                Text(
                    desafio.titulo,
                    fontSize = 16.sp,
                    modifier = Modifier
                        .weight(1f)
                        .padding(horizontal = 12.dp)
                )
                Text(if (feito) "✅" else "🔒", fontSize = 22.sp)
            }
        }

        OutlinedButton(onClick = aoVoltar, modifier = Modifier.fillMaxWidth()) {
            Text("👤 Voltar ao perfil")
        }
    }
}
