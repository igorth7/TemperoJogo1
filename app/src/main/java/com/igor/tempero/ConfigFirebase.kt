package com.igor.tempero

// 7) Os dados do SEU projeto no Firebase.
// Pegue no console do Firebase: ⚙️ Configurações do projeto -> Seus apps -> app Android.
object ConfigFirebase {
    const val API_KEY = "COLE_AQUI_A_API_KEY"          // "Chave de API da Web" (começa com AIza...)
    const val APP_ID = "COLE_AQUI_O_APP_ID"            // "ID do app" (1:123...:android:...)
    const val PROJECT_ID = "COLE_AQUI_O_PROJECT_ID"    // "ID do projeto" (ex: jogo-do-tempero)

    // Enquanto não colar os dados, o app funciona sem o ranking online
    val configurado: Boolean
        get() = !API_KEY.startsWith("COLE")
}
