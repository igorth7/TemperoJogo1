package com.igor.tempero

// 2) O "molde" de uma pergunta do jogo (data class)
data class Pergunta(
    val emoji: String,          // a "foto" do prato
    val dica: String,           // os ingredientes
    val opcoes: List<String>,   // as 3 respostas
    val resposta: String        // a resposta certa
)

// A lista de perguntas (as receitas do app Tempero)
val perguntas = listOf(
    Pergunta("🍰", "cenoura, ovos, açúcar e farinha", listOf("Lasanha", "Bolo de cenoura", "Salada"), "Bolo de cenoura"),
    Pergunta("🍗", "frango, creme de leite e ketchup", listOf("Strogonoff de frango", "Brigadeiro", "Pizza"), "Strogonoff de frango"),
    Pergunta("🍝", "massa, carne moída, queijo e presunto", listOf("Pudim", "Sopa", "Lasanha"), "Lasanha"),
    Pergunta("🥗", "grão-de-bico, tomate e cebola roxa", listOf("Salada de grão-de-bico", "Hambúrguer", "Bolo"), "Salada de grão-de-bico"),
    Pergunta("🍫", "leite condensado, cacau e manteiga", listOf("Feijoada", "Brigadeiro", "Omelete"), "Brigadeiro")
)
