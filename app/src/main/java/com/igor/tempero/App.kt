package com.igor.tempero

import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue

// 4) O App guarda o perfil e o nível, e decide qual tela mostrar
@Composable
fun App() {
    var tela by remember { mutableStateOf("perfil") }   // "perfil", "jogo", "desafios" ou "ranking"
    var perfil by remember { mutableStateOf(Perfil()) }
    var nivel by remember { mutableStateOf("Fácil") }

    // Só as perguntas do nível escolhido
    val perguntasDoNivel = perguntas.filter { it.nivel == nivel }

    when (tela) {
        "perfil" -> TelaPerfil(
            perfil = perfil,
            nivel = nivel,
            aoMudarNome = { novoNome -> perfil = perfil.copy(nome = novoNome) },
            aoEscolherNivel = { escolhido -> nivel = escolhido },
            aoComecar = { tela = "jogo" },
            aoAbrirDesafios = { tela = "desafios" },
            aoAbrirRanking = { tela = "ranking" }
        )

        "jogo" -> TelaJogo(
            nome = perfil.nome,
            nivel = nivel,
            lista = perguntasDoNivel,
            aoTerminar = { pontos ->
                // Fim da partida: atualiza o perfil...
                val acertouTodas = pontos == perguntasDoNivel.size
                perfil = perfil.copy(
                    partidas = perfil.partidas + 1,
                    recorde = maxOf(perfil.recorde, pontos),
                    pontosTotais = perfil.pontosTotais + pontos,
                    gabaritos = if (acertouTodas) perfil.gabaritos + nivel else perfil.gabaritos
                )
                // ...e salva o resultado no Firebase (ranking online)
                RankingFirebase.salvar(perfil.nome, nivel, pontos)
            },
            aoVoltar = { tela = "perfil" }
        )

        "desafios" -> TelaDesafios(
            perfil = perfil,
            aoVoltar = { tela = "perfil" }
        )

        "ranking" -> TelaRanking(
            aoVoltar = { tela = "perfil" }
        )
    }
}
