package com.enavarrocunat.agendaappkotlin_jc.views.login

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material3.Button
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.text.input.PasswordVisualTransformation
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavHostController
import com.enavarrocunat.agendaappkotlin_jc.R
import com.enavarrocunat.agendaappkotlin_jc.utils.Routes.Companion.RegisterRoute
import com.enavarrocunat.agendaappkotlin_jc.viewmodels.LoginViewModel

@Composable
fun LoginView(navController: NavHostController, loginVM: LoginViewModel) {
    Column(
        horizontalAlignment = Alignment.CenterHorizontally,
        modifier = Modifier.fillMaxSize()
    ){
        var email by rememberSaveable { mutableStateOf("") }
        var password by rememberSaveable { mutableStateOf("") }

        Text(
            modifier = Modifier.padding(top = 16.dp),
            text = "Login",
            fontWeight = FontWeight.Bold,
            fontSize = 20.sp)

        Image(
            modifier = Modifier
                    .height(150.dp)
                    .width(150.dp)
                    .padding(16.dp),
            painter = painterResource(id = R.drawable.login),
            contentDescription = "Icono del login"
        )

        OutlinedTextField(
            modifier = Modifier.fillMaxWidth().padding(horizontal = 32.dp),
            value = email,
            label = {
                Text(text = "Email")
            },
            keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Email),
            onValueChange = {
                email = it
            }
        )
        Spacer(modifier = Modifier.height(8.dp))
        OutlinedTextField(
            modifier = Modifier.fillMaxWidth().padding(horizontal = 32.dp),
            value = password,
            label = {
                Text(text = "Password")
            },
            visualTransformation = PasswordVisualTransformation(),
            keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Password),
            onValueChange = {
                password = it
            }
        )

        Spacer(modifier = Modifier.height(24.dp))

        Button(
            modifier = Modifier.fillMaxWidth().padding(horizontal = 32.dp),
            onClick = {}
        ){
            Text(text = "Login")
        }
        Button(
            modifier = Modifier.fillMaxWidth().padding(horizontal = 32.dp),
            onClick = {
                navController.navigate(RegisterRoute)
            }
        ){
            Text(text = "Registro")
        }

    }
}