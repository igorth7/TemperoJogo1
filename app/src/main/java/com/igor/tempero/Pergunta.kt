package com.igor.tempero

// 2) O "molde" de uma pergunta do jogo (data class)
data class Pergunta(
    val nivel: String,          // "Fácil", "Médio" ou "Difícil"
    val emoji: String,          // a "foto" do prato
    val dica: String,           // uma pista sobre o prato
    val opcoes: List<String>,   // as 5 alternativas
    val resposta: String        // a resposta certa
)

// Os 3 níveis do jogo
val niveis = listOf("Fácil", "Médio", "Difícil")

// A lista de perguntas: receitas do app Tempero, 4 de cada nível
val perguntas = listOf(
    Pergunta(
        "Fácil", "🍰", "massa fofinha, laranja por dentro e coberta de chocolate",
        listOf("Lasanha", "Bolo de cenoura", "Salada", "Pudim", "Panqueca"),
        "Bolo de cenoura"
    ),
    Pergunta(
        "Difícil", "🍗", "prato de origem russa, servido com arroz e batata palha",
        listOf("Strogonoff de frango", "Brigadeiro", "Pizza", "Feijoada", "Sushi"),
        "Strogonoff de frango"
    ),
    Pergunta(
        "Médio", "🍝", "camadas e mais camadas que vão ao forno numa travessa",
        listOf("Pudim", "Sopa", "Omelete", "Lasanha", "Tapioca"),
        "Lasanha"
    ),
    Pergunta(
        "Difícil", "🥗", "prato frio e leve, cheio de proteína vegetal",
        listOf("Hambúrguer", "Bolo de chocolate", "Salada de grão-de-bico", "Coxinha", "Churrasco"),
        "Salada de grão-de-bico"
    ),
    Pergunta(
        "Fácil", "🍫", "docinho enrolado na mão que não pode faltar em aniversário",
        listOf("Feijoada", "Brigadeiro", "Omelete", "Lasanha", "Salada"),
        "Brigadeiro"
    ),
    Pergunta(
        "Médio", "🍮", "doce com um furo no meio, que treme ao sair da forma",
        listOf("Pizza", "Coxinha", "Strogonoff", "Pudim", "Sopa"),
        "Pudim"
    ),
    Pergunta(
        "Difícil", "🫘", "prato tradicional de sábado, servido com laranja e farofa",
        listOf("Feijoada", "Lasanha", "Panqueca", "Brigadeiro", "Sushi"),
        "Feijoada"
    ),
    Pergunta(
        "Fácil", "🍕", "redonda, cortada em fatias e entregue numa caixa de papelão",
        listOf("Tapioca", "Pizza", "Pudim", "Salada", "Omelete"),
        "Pizza"
    ),
    Pergunta(
        "Fácil", "🍳", "feito na frigideira em minutos e dobrado ao meio",
        listOf("Bolo", "Feijoada", "Sushi", "Churrasco", "Omelete"),
        "Omelete"
    ),
    Pergunta(
        "Médio", "🍣", "enrolado em algo verde-escuro e comido com palitinhos",
        listOf("Sushi", "Coxinha", "Lasanha", "Brigadeiro", "Pizza"),
        "Sushi"
    ),
    Pergunta(
        "Médio", "🥟", "salgado de festa com formato de gota",
        listOf("Pudim", "Salada", "Coxinha", "Omelete", "Feijoada"),
        "Coxinha"
    ),
    Pergunta(
        "Difícil", "🥞", "disco fino feito na frigideira, enrolado com recheio e coberto de molho",
        listOf("Sushi", "Panqueca", "Brigadeiro", "Pizza", "Sopa"),
        "Panqueca"
    )
)
