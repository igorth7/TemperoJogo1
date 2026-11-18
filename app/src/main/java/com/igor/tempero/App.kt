package com.igor.tempero

import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue

// 4) O App guarda o perfil e o nível, e decide qual tela mostrar
@Composable
fun App() {
    var tela by remember { mutableStateOf("perfil") }    // "perfil" ou "jogo"
    var perfil by remember { mutableStateOf(Perfil()) }
    var nivel by remember { mutableStateOf("Fácil") }

    if (tela == "perfil") {
        TelaPerfil(
            perfil = perfil,
            nivel = nivel,
            aoMudarNome = { novoNome -> perfil = perfil.copy(nome = novoNome) },
            aoEscolherNivel = { escolhido -> nivel = escolhido },
            aoComecar = { tela = "jogo" }
        )
    } else {
        TelaJogo(
            nome = perfil.nome,
            nivel = nivel,
            lista = perguntas.filter { it.nivel == nivel },   // só as perguntas do nível escolhido
            aoTerminar = { pontos ->
                // Fim da partida: atualiza o perfil
                perfil = perfil.copy(
                    partidas = perfil.partidas + 1,
                    recorde = maxOf(perfil.recorde, pontos),
                    pontosTotais = perfil.pontosTotais + pontos
                )
            },
            aoVoltar = { tela = "perfil" }
        )
    }
}
