package com.igor.tempero

// 2) O "molde" de uma pergunta do jogo (data class)
data class Pergunta(
    val emoji: String,          // a "foto" do prato
    val dica: String,           // os ingredientes
    val opcoes: List<String>,   // as 5 alternativas
    val resposta: String        // a resposta certa
)

// A lista de perguntas (receitas, como no app Tempero)
val perguntas = listOf(
    Pergunta(
        "🍰", "cenoura, ovos, açúcar e farinha",
        listOf("Lasanha", "Bolo de cenoura", "Salada", "Pudim", "Panqueca"),
        "Bolo de cenoura"
    ),
    Pergunta(
        "🍗", "frango, creme de leite e ketchup",
        listOf("Strogonoff de frango", "Brigadeiro", "Pizza", "Feijoada", "Sushi"),
        "Strogonoff de frango"
    ),
    Pergunta(
        "🍝", "massa, carne moída, queijo e presunto",
        listOf("Pudim", "Sopa", "Omelete", "Lasanha", "Tapioca"),
        "Lasanha"
    ),
    Pergunta(
        "🥗", "grão-de-bico, tomate e cebola roxa",
        listOf("Hambúrguer", "Bolo de chocolate", "Salada de grão-de-bico", "Coxinha", "Churrasco"),
        "Salada de grão-de-bico"
    ),
    Pergunta(
        "🍫", "leite condensado, cacau e manteiga",
        listOf("Feijoada", "Brigadeiro", "Omelete", "Lasanha", "Salada"),
        "Brigadeiro"
    ),
    Pergunta(
        "🍮", "leite condensado, leite, ovos e calda de açúcar",
        listOf("Pizza", "Coxinha", "Strogonoff", "Pudim", "Sopa"),
        "Pudim"
    ),
    Pergunta(
        "🫘", "feijão preto, linguiça, carne seca e couve",
        listOf("Feijoada", "Lasanha", "Panqueca", "Brigadeiro", "Sushi"),
        "Feijoada"
    ),
    Pergunta(
        "🍕", "massa, molho de tomate, muçarela e orégano",
        listOf("Tapioca", "Pizza", "Pudim", "Salada", "Omelete"),
        "Pizza"
    ),
    Pergunta(
        "🍳", "ovos batidos, sal, queijo e tomate",
        listOf("Bolo", "Feijoada", "Sushi", "Churrasco", "Omelete"),
        "Omelete"
    ),
    Pergunta(
        "🍣", "arroz, peixe cru e alga",
        listOf("Sushi", "Coxinha", "Lasanha", "Brigadeiro", "Pizza"),
        "Sushi"
    ),
    Pergunta(
        "🥟", "massa de batata, frango desfiado e farinha de rosca",
        listOf("Pudim", "Salada", "Coxinha", "Omelete", "Feijoada"),
        "Coxinha"
    ),
    Pergunta(
        "🥞", "farinha, leite, ovos e recheio de carne",
        listOf("Sushi", "Panqueca", "Brigadeiro", "Pizza", "Sopa"),
        "Panqueca"
    )
)
