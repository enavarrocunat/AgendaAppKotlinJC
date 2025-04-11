package com.enavarrocunat.agendaappkotlin_jc.views.notes

import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController
import com.enavarrocunat.agendaappkotlin_jc.viewmodels.NotesViewModel

@Composable
fun HomeView(navController: NavHostController, notesVm: NotesViewModel) {
    Text(text = "Home view")
}