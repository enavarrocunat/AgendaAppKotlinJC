package com.enavarrocunat.agendaappkotlin_jc.viewmodels

import androidx.lifecycle.ViewModel
import com.google.firebase.Firebase
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.auth.auth

class NotesViewModel: ViewModel() {
    private val auth: FirebaseAuth = Firebase.auth


    fun logout(){
        auth.signOut()
    }
}