package com.igor.tempero

// 2) O "molde" de uma pergunta do jogo (data class)
data class Pergunta(
    val nivel: String,          // "Fácil", "Médio" ou "Difícil"
    val emoji: String,          // a "foto" do prato
    val dica: String,           // os ingredientes
    val opcoes: List<String>,   // as 5 alternativas
    val resposta: String        // a resposta certa
)

// Os 3 níveis do jogo
val niveis = listOf("Fácil", "Médio", "Difícil")

// A lista de perguntas: receitas do app Tempero, 4 de cada nível
val perguntas = listOf(
    Pergunta(
        "Fácil", "🍰", "cenoura, ovos, açúcar e farinha",
        listOf("Lasanha", "Bolo de cenoura", "Salada", "Pudim", "Panqueca"),
        "Bolo de cenoura"
    ),
    Pergunta(
        "Difícil", "🍗", "frango, creme de leite e ketchup",
        listOf("Strogonoff de frango", "Brigadeiro", "Pizza", "Feijoada", "Sushi"),
        "Strogonoff de frango"
    ),
    Pergunta(
        "Médio", "🍝", "massa, carne moída, queijo e presunto",
        listOf("Pudim", "Sopa", "Omelete", "Lasanha", "Tapioca"),
        "Lasanha"
    ),
    Pergunta(
        "Difícil", "🥗", "grão-de-bico, tomate e cebola roxa",
        listOf("Hambúrguer", "Bolo de chocolate", "Salada de grão-de-bico", "Coxinha", "Churrasco"),
        "Salada de grão-de-bico"
    ),
    Pergunta(
        "Fácil", "🍫", "leite condensado, cacau e manteiga",
        listOf("Feijoada", "Brigadeiro", "Omelete", "Lasanha", "Salada"),
        "Brigadeiro"
    ),
    Pergunta(
        "Médio", "🍮", "leite condensado, leite, ovos e calda de açúcar",
        listOf("Pizza", "Coxinha", "Strogonoff", "Pudim", "Sopa"),
        "Pudim"
    ),
    Pergunta(
        "Difícil", "🫘", "feijão preto, linguiça, carne seca e couve",
        listOf("Feijoada", "Lasanha", "Panqueca", "Brigadeiro", "Sushi"),
        "Feijoada"
    ),
    Pergunta(
        "Fácil", "🍕", "massa, molho de tomate, muçarela e orégano",
        listOf("Tapioca", "Pizza", "Pudim", "Salada", "Omelete"),
        "Pizza"
    ),
    Pergunta(
        "Fácil", "🍳", "ovos batidos, sal, queijo e tomate",
        listOf("Bolo", "Feijoada", "Sushi", "Churrasco", "Omelete"),
        "Omelete"
    ),
    Pergunta(
        "Médio", "🍣", "arroz, peixe cru e alga",
        listOf("Sushi", "Coxinha", "Lasanha", "Brigadeiro", "Pizza"),
        "Sushi"
    ),
    Pergunta(
        "Médio", "🥟", "massa de batata, frango desfiado e farinha de rosca",
        listOf("Pudim", "Salada", "Coxinha", "Omelete", "Feijoada"),
        "Coxinha"
    ),
    Pergunta(
        "Difícil", "🥞", "farinha, leite, ovos e recheio de carne",
        listOf("Sushi", "Panqueca", "Brigadeiro", "Pizza", "Sopa"),
        "Panqueca"
    )
)
