package com.enavarrocunat.agendaappkotlin_jc.views.register

import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController
import com.enavarrocunat.agendaappkotlin_jc.viewmodels.RegisterViewModel

@Composable
fun RegisterView(navController: NavHostController, registerVm: RegisterViewModel) {
    Text(text = "Registro de usuario")
}