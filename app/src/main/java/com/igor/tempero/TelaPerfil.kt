package com.igor.tempero

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.systemBarsPadding
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

// 5) Tela de perfil: nome, estatísticas e escolha do nível
@Composable
fun TelaPerfil(
    perfil: Perfil,
    nivel: String,
    aoMudarNome: (String) -> Unit,
    aoEscolherNivel: (String) -> Unit,
    aoComecar: () -> Unit
) {
    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(Creme)
            .systemBarsPadding()
            .verticalScroll(rememberScrollState())
            .padding(24.dp),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.spacedBy(16.dp)
    ) {
        Text("🍲 Jogo do Tempero", fontSize = 28.sp, fontWeight = FontWeight.Bold)

        // Avatar: a primeira letra do nome dentro de um círculo
        Box(
            modifier = Modifier
                .size(90.dp)
                .clip(CircleShape)
                .background(Laranja),
            contentAlignment = Alignment.Center
        ) {
            Text(
                perfil.nome.take(1).uppercase().ifEmpty { "👤" },
                fontSize = 40.sp,
                color = Color.White,
                fontWeight = FontWeight.Bold
            )
        }

        OutlinedTextField(
            value = perfil.nome,
            onValueChange = aoMudarNome,
            label = { Text("Seu nome") },
            singleLine = true,
            modifier = Modifier.fillMaxWidth()
        )

        // Estatísticas do jogador
        Row(horizontalArrangement = Arrangement.spacedBy(8.dp)) {
            Numero("${perfil.nivelJogador}", "Nível", Modifier.weight(1f))
            Numero("${perfil.partidas}", "Partidas", Modifier.weight(1f))
            Numero("${perfil.recorde}", "Recorde", Modifier.weight(1f))
        }
        Text("Total de pontos: ${perfil.pontosTotais}  •  a cada 5 pontos você sobe de nível", fontSize = 13.sp, color = Color.Gray)

        // Escolha da dificuldade
        Text("Escolha o nível", fontSize = 18.sp, fontWeight = FontWeight.Bold)
        Row(horizontalArrangement = Arrangement.spacedBy(8.dp)) {
            niveis.forEach { opcao ->
                Button(
                    onClick = { aoEscolherNivel(opcao) },
                    modifier = Modifier.weight(1f),
                    colors = ButtonDefaults.buttonColors(
                        containerColor = if (opcao == nivel) Laranja else Color.Gray
                    )
                ) {
                    Text(opcao)
                }
            }
        }

        Button(
            onClick = aoComecar,
            enabled = perfil.nome.isNotBlank(),   // só começa depois de digitar o nome
            modifier = Modifier.fillMaxWidth(),
            colors = ButtonDefaults.buttonColors(containerColor = Verde)
        ) {
            Text("Começar  ▶", fontSize = 18.sp)
        }
        if (perfil.nome.isBlank()) {
            Text("Digite seu nome para começar", color = Color.Gray)
        }
    }
}

/** Quadradinho com um número e um rótulo (Nível, Partidas, Recorde). */
@Composable
fun Numero(valor: String, rotulo: String, modifier: Modifier = Modifier) {
    Column(
        modifier = modifier
            .clip(RoundedCornerShape(14.dp))
            .background(Color.White)
            .padding(vertical = 12.dp),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Text(valor, fontSize = 24.sp, fontWeight = FontWeight.Bold, color = Laranja)
        Text(rotulo, fontSize = 13.sp, color = Color.Gray)
    }
}
