package com.igor.tempero

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.material3.MaterialTheme
import com.google.firebase.FirebaseApp
import com.google.firebase.FirebaseOptions

// 1) A Activity liga o Firebase e abre o App (que escolhe a tela)
class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()

        // Conecta o app ao projeto do Firebase (só uma vez)
        if (ConfigFirebase.configurado && FirebaseApp.getApps(this).isEmpty()) {
            val opcoes = FirebaseOptions.Builder()
                .setApiKey(ConfigFirebase.API_KEY)
                .setApplicationId(ConfigFirebase.APP_ID)
                .setProjectId(ConfigFirebase.PROJECT_ID)
                .build()
            FirebaseApp.initializeApp(this, opcoes)
        }

        setContent {
            MaterialTheme {
                App()
            }
        }
    }
}
