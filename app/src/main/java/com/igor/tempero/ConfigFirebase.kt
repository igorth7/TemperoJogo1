package com.igor.tempero

// 7) Os dados do SEU projeto no Firebase.
// Pegue no console do Firebase: ⚙️ Configurações do projeto -> Seus apps -> app Android.
object ConfigFirebase {
    const val API_KEY = "AIzaSyAUuFy_ZDqz7cUfpE1hHe__x-vOBbchnok"          // "Chave de API da Web" (começa com AIza...)
    const val APP_ID = "1:648024153483:android:9ca02c6dfb79ac09d9638e"            // "ID do app" (1:123...:android:...)
    const val PROJECT_ID = "aplicativo-b6ecf"    // "ID do projeto" (ex: jogo-do-tempero)

    // Enquanto não colar os dados, o app funciona sem o ranking online
    val configurado: Boolean
        get() = !API_KEY.startsWith("COLE")
}
