package com.igor.tempero

// 3) O perfil do jogador (data class)
data class Perfil(
    val nome: String = "",
    val partidas: Int = 0,       // quantas vezes jogou
    val recorde: Int = 0,        // maior pontuação numa partida
    val pontosTotais: Int = 0    // soma de todos os pontos
) {
    // Nível do jogador: começa no 1 e sobe 1 a cada 5 pontos ganhos
    val nivelJogador: Int
        get() = 1 + pontosTotais / 5
}
