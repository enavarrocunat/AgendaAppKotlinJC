package com.enavarrocunat.agendaappkotlin_jc.viewmodels

import android.content.Context
import android.util.Log
import android.widget.Toast
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.enavarrocunat.agendaappkotlin_jc.models.UserModel
import com.google.firebase.Firebase
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.auth.auth
import com.google.firebase.firestore.FirebaseFirestore
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.MutableSharedFlow
import kotlinx.coroutines.launch

class LoginViewModel: ViewModel() {

    private val auth: FirebaseAuth = Firebase.auth
    val toastMessages = MutableSharedFlow<String>()

    fun login(email: String, password: String, onSuccess : () -> Unit ){

        viewModelScope.launch (Dispatchers.IO) {
            viewModelScope.launch {
                try {
                    auth.signInWithEmailAndPassword(email, password)
                        .addOnCompleteListener { task ->
                            if(task.isSuccessful){
                                onSuccess()
                            } else {
                                viewModelScope.launch {
                                    toastMessages.emit("Error al iniciar sesión - Completada pero error")
                                }
                            }
                        }
                        .addOnFailureListener {
                            viewModelScope.launch {
                                toastMessages.emit("Error al iniciar sesión - Fallo")
                            }
                            Log.d("Error", "Error al iniciar sesión")
                        }
                } catch (e: Exception){
                    Log.d("Error", "${e.message}")
                }
            }
        }
    }
}