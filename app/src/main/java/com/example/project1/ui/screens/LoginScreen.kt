package com.example.project1.ui.screens

import android.widget.Toast
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.text.input.PasswordVisualTransformation
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import coil.compose.AsyncImage
import com.example.project1.data.model.network.RetrofitClient
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

@Composable
fun LoginScreen(navController: NavController) {
    Column(
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.SpaceEvenly,
        modifier = Modifier
            .background(Color.Black)
            .fillMaxSize()
            .verticalScroll(rememberScrollState())
    ) {
        LoginForm(navController)
    }
}

@Composable
fun LoginForm(navController: NavController) {
    var user by remember { mutableStateOf("") }
    var password by remember { mutableStateOf("") }
    var isLoading by remember { mutableStateOf(false) }

    Card(
        colors = CardDefaults.cardColors(
            contentColor = Color.White,
            containerColor = Color.LightGray
        ),
        modifier = Modifier.padding(40.dp, 0.dp)
    ) {
        Column(
            modifier = Modifier.padding(20.dp)
        ) {

            AsyncImage(
                model = "https://pngimg.com/uploads/github/github_PNG23.png",
                contentDescription = "Github Logo",
                contentScale = ContentScale.Fit
            )

            OutlinedTextField(
                modifier = Modifier.fillMaxWidth(),
                value = user,
                maxLines = 1,
                onValueChange = { user = it },
                label = { Text("Username") },
            )

            OutlinedTextField(
                modifier = Modifier.fillMaxWidth(),
                value = password,
                maxLines = 1,
                onValueChange = { password = it },
                label = { Text("Password") },
                visualTransformation = PasswordVisualTransformation()
            )

            FilledTonalButton(
                modifier = Modifier.fillMaxWidth().padding(0.dp, 10.dp),
                onClick = {
                    if (user.isNotEmpty() && password.isNotEmpty()) {
                        isLoading = true
                        // Pasamos el setIsLoading a la función login
                        login(user, password, navController, { isLoading = it })
                    } else {
                        Toast.makeText(navController.context, "Please fill in both fields", Toast.LENGTH_SHORT).show()
                    }
                }
            ) {
                Text("LOG IN")
            }

            // Mostrar indicador de carga si isLoading es verdadero
            if (isLoading) {
                CircularProgressIndicator()
            }
        }
    }
}

// Ahora la función login toma setIsLoading como argumento
fun login(username: String, password: String, navController: NavController, setIsLoading: (Boolean) -> Unit) {
    val api = RetrofitClient.api

    val loginData = mapOf("username" to username, "password" to password)

    api.login(loginData).enqueue(object : Callback<Map<String, Any>> {
        override fun onResponse(call: Call<Map<String, Any>>, response: Response<Map<String, Any>>) {
            setIsLoading(false)  // Detener la carga
            if (response.isSuccessful) {
                // Si las credenciales son correctas, navegar a la pantalla Home
                navController.navigate("home")
                Toast.makeText(navController.context, "Login successful", Toast.LENGTH_SHORT).show()
            } else {
                // Mostrar un mensaje de error si las credenciales son incorrectas
                Toast.makeText(navController.context, "Invalid credentials, please try again", Toast.LENGTH_SHORT).show()
            }
        }

        override fun onFailure(call: Call<Map<String, Any>>, t: Throwable) {
            setIsLoading(false)  // Detener la carga
            Toast.makeText(navController.context, "Error: ${t.localizedMessage}", Toast.LENGTH_SHORT).show()
        }
    })
}
