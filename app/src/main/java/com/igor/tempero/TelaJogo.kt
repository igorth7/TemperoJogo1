package com.igor.tempero

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.systemBarsPadding
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.OutlinedButton
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

val Laranja = Color(0xFFE8622C)
val Creme = Color(0xFFFFF8F1)
val Verde = Color(0xFF2E7D32)
val Vermelho = Color(0xFFC62828)

// 6) A tela do jogo (recebe só as perguntas do nível escolhido)
@Composable
fun TelaJogo(
    nome: String,
    nivel: String,
    lista: List<Pergunta>,
    aoTerminar: (Int) -> Unit,   // avisa o App quantos pontos fez
    aoVoltar: () -> Unit         // volta para o perfil
) {
    // O estado do jogo: muda o valor -> a tela se redesenha sozinha
    var numero by remember { mutableStateOf(0) }                 // qual pergunta estou
    var pontos by remember { mutableStateOf(0) }                 // quantas acertei
    var escolhida by remember { mutableStateOf<String?>(null) }  // o que o jogador tocou

    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(Creme)
            .systemBarsPadding()
            .verticalScroll(rememberScrollState())   // rola se as 5 opções não couberem
            .padding(24.dp),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.spacedBy(12.dp)
    ) {
        Text("👤 $nome  •  Nível $nivel", fontSize = 16.sp, color = Color.Gray)
        Text("Pontos: $pontos", fontSize = 20.sp, color = Laranja, fontWeight = FontWeight.Bold)

        if (numero < lista.size) {
            // ---------- JOGANDO ----------
            val pergunta = lista[numero]

            Text("Pergunta ${numero + 1} de ${lista.size}")
            Text(pergunta.emoji, fontSize = 80.sp)
            Text(
                "Qual prato leva ${pergunta.dica}?",
                fontSize = 18.sp,
                textAlign = TextAlign.Center
            )

            // Um botão para cada alternativa
            pergunta.opcoes.forEach { opcao ->
                // Depois de responder: certa fica verde, a errada escolhida fica vermelha
                val cor = when {
                    escolhida == null -> Laranja
                    opcao == pergunta.resposta -> Verde
                    opcao == escolhida -> Vermelho
                    else -> Color.Gray
                }
                Button(
                    onClick = {
                        if (escolhida == null) {
                            escolhida = opcao
                            if (opcao == pergunta.resposta) pontos++
                        }
                    },
                    modifier = Modifier.fillMaxWidth(),
                    colors = ButtonDefaults.buttonColors(containerColor = cor)
                ) {
                    Text(opcao, fontSize = 18.sp)
                }
            }

            // Mostra se acertou e o botão de próxima
            if (escolhida != null) {
                Text(
                    if (escolhida == pergunta.resposta) "✅ Acertou!" else "❌ Errou! Era ${pergunta.resposta}",
                    fontSize = 20.sp,
                    fontWeight = FontWeight.Bold
                )
                Button(onClick = {
                    numero++
                    escolhida = null
                    if (numero == lista.size) aoTerminar(pontos)   // acabou: salva no perfil
                }) {
                    Text("Próxima ➜")
                }
            }
        } else {
            // ---------- FIM DE JOGO ----------
            Text("🏆", fontSize = 90.sp)
            Text("Fim de jogo, $nome!", fontSize = 26.sp, fontWeight = FontWeight.Bold)
            Text("Você acertou $pontos de ${lista.size} no nível $nivel", fontSize = 20.sp, textAlign = TextAlign.Center)
            Button(
                onClick = {
                    numero = 0
                    pontos = 0
                    escolhida = null
                },
                modifier = Modifier.fillMaxWidth(),
                colors = ButtonDefaults.buttonColors(containerColor = Laranja)
            ) {
                Text("Jogar de novo", fontSize = 18.sp)
            }
        }

        OutlinedButton(onClick = aoVoltar, modifier = Modifier.fillMaxWidth()) {
            Text("👤 Voltar ao perfil")
        }
    }
}
