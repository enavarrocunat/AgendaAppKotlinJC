package com.enavarrocunat.agendaappkotlin_jc.navigation

import androidx.compose.runtime.Composable
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.enavarrocunat.agendaappkotlin_jc.utils.Routes.Companion.CheckSessionRoute
import com.enavarrocunat.agendaappkotlin_jc.utils.Routes.Companion.HomeRoute
import com.enavarrocunat.agendaappkotlin_jc.utils.Routes.Companion.LoginRoute
import com.enavarrocunat.agendaappkotlin_jc.utils.Routes.Companion.RegisterRoute
import com.enavarrocunat.agendaappkotlin_jc.viewmodels.LoginViewModel
import com.enavarrocunat.agendaappkotlin_jc.viewmodels.NotesViewModel
import com.enavarrocunat.agendaappkotlin_jc.viewmodels.RegisterViewModel
import com.enavarrocunat.agendaappkotlin_jc.views.login.CheckSessionView
import com.enavarrocunat.agendaappkotlin_jc.views.login.LoginView
import com.enavarrocunat.agendaappkotlin_jc.views.notes.HomeView
import com.enavarrocunat.agendaappkotlin_jc.views.register.RegisterView

@Composable
fun NavManager(
    loginVM : LoginViewModel,
    registerVM : RegisterViewModel,
    notesVM : NotesViewModel
){
    val navController = rememberNavController()

    NavHost(navController = navController, startDestination = CheckSessionRoute){
        composable(CheckSessionRoute){
            CheckSessionView(navController)
        }
        composable(LoginRoute) {
            LoginView(navController,loginVM)
        }
        composable(RegisterRoute) {
            RegisterView(navController,registerVM)
        }
        composable(HomeRoute) {
            HomeView(navController,notesVM)
        }
    }

}