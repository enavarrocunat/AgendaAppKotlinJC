package com.enavarrocunat.agendaappkotlin_jc.viewmodels

import android.util.Log
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.enavarrocunat.agendaappkotlin_jc.models.UserModel
import com.google.firebase.Firebase
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.auth.auth
import com.google.firebase.firestore.FirebaseFirestore
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class LoginViewModel: ViewModel() {

    private val auth: FirebaseAuth = Firebase.auth

    fun login(email: String, password: String, onSuccess : () -> Unit ){

        viewModelScope.launch (Dispatchers.IO) {
            viewModelScope.launch {
                try {
                    auth.signInWithEmailAndPassword(email, password)
                        .addOnCompleteListener { task ->
                            if(task.isSuccessful){
                                onSuccess()
                            } else {
                                Log.d("Error", "Error al iniciar sesión")
                            }
                        }
                        .addOnFailureListener {
                            Log.d("Error", "Error al iniciar sesión")
                        }
                } catch (e: Exception){
                    Log.d("Error", "${e.message}")
                }
            }
        }
    }
}