package com.enavarrocunat.agendaappkotlin_jc

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.activity.viewModels
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import com.enavarrocunat.agendaappkotlin_jc.navigation.NavManager
import com.enavarrocunat.agendaappkotlin_jc.ui.theme.AgendaAppKotlinJCTheme
import com.enavarrocunat.agendaappkotlin_jc.viewmodels.LoginViewModel
import com.enavarrocunat.agendaappkotlin_jc.viewmodels.NotesViewModel
import com.enavarrocunat.agendaappkotlin_jc.viewmodels.RegisterViewModel
import com.enavarrocunat.agendaappkotlin_jc.views.login.LoginView

class MainActivity : ComponentActivity() {
    val loginVM : LoginViewModel by viewModels()
    val registerVM : RegisterViewModel by viewModels()
    val notesVM : NotesViewModel by viewModels()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        //enableEdgeToEdge()
        setContent {
            AgendaAppKotlinJCTheme {
                Surface(modifier = Modifier.fillMaxSize()) {
                    NavManager(
                        loginVM = loginVM,
                        registerVM = registerVM,
                        notesVM = notesVM
                    )
                }
            }
        }
    }
}