package com.enavarrocunat.agendaappkotlin_jc.views.login

import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.navigation.NavController
import com.enavarrocunat.agendaappkotlin_jc.utils.Routes.Companion.HomeRoute
import com.enavarrocunat.agendaappkotlin_jc.utils.Routes.Companion.LoginRoute
import com.google.firebase.auth.FirebaseAuth

@Composable
fun CheckSessionView(navController: NavController){
    LaunchedEffect(Unit) {
        if(FirebaseAuth.getInstance().currentUser?.email.isNullOrBlank()){
            navController.navigate(LoginRoute)
        } else{
            navController.navigate(HomeRoute)
        }
    }

}