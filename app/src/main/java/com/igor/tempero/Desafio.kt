package com.igor.tempero

// 9) Um desafio: emoji, título e a regra que diz se ele foi cumprido
data class Desafio(
    val emoji: String,
    val titulo: String,
    val cumprido: (Perfil) -> Boolean
)

// A lista de desafios (a regra olha os dados do perfil)
val desafios = listOf(
    Desafio("🎮", "Jogue sua primeira partida") { perfil -> perfil.partidas >= 1 },
    Desafio("🔁", "Jogue 5 partidas") { perfil -> perfil.partidas >= 5 },
    Desafio("🥉", "Acerte todas no Fácil") { perfil -> "Fácil" in perfil.gabaritos },
    Desafio("🥈", "Acerte todas no Médio") { perfil -> "Médio" in perfil.gabaritos },
    Desafio("🥇", "Acerte todas no Difícil") { perfil -> "Difícil" in perfil.gabaritos },
    Desafio("⭐", "Chegue ao nível 3") { perfil -> perfil.nivelJogador >= 3 }
)
