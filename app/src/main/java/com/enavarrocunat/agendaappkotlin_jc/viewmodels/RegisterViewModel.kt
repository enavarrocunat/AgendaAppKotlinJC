package com.enavarrocunat.agendaappkotlin_jc.viewmodels

import android.util.Log
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.enavarrocunat.agendaappkotlin_jc.models.UserModel
import com.google.firebase.Firebase
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.auth.auth
import com.google.firebase.firestore.FirebaseFirestore
import com.google.firebase.firestore.firestore
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class RegisterViewModel: ViewModel() {

    private val auth: FirebaseAuth = Firebase.auth

    fun createUser(username:String,
                   email:String,
                   password:String,
                   onSuccess : () -> Unit){
        viewModelScope.launch {
            try {
                auth.createUserWithEmailAndPassword(email, password)
                    .addOnCompleteListener { task ->
                        if(task.isSuccessful){
                            saveUser(username)
                            onSuccess()
                         } else {
                             Log.d("Error", "Error al crear usuario")
                         }
                    }
            } catch (e: Exception){
                Log.d("Error", "${e.message}")
            }
        }
    }

    fun saveUser(username: String){
        val id = auth.currentUser?.uid
        val email = auth.currentUser?.email?:""

        viewModelScope.launch (Dispatchers.IO) {
            val user = UserModel(userId = id.toString(), email = email, username = username)

            FirebaseFirestore.getInstance().collection("Users")
                .add(user)
                .addOnSuccessListener {
                    Log.d("Success", "Usuario registrado correctamente")
                }
                .addOnFailureListener {
                    Log.d("Error", "Fallo al registrar el usuario")
                }
        }
    }

}