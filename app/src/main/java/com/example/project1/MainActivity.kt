package com.example.project1

import android.os.Bundle
import android.widget.Toast
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.material3.Surface
import androidx.compose.runtime.Composable
import androidx.compose.ui.graphics.Color
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import androidx.work.OneTimeWorkRequestBuilder
import androidx.work.WorkManager
import com.example.project1.ui.screens.AlarmScreen
import com.example.project1.ui.screens.AlarmWorker
import com.example.project1.ui.screens.ComponentsScreen
import com.example.project1.ui.screens.HomeScreen
import com.example.project1.ui.screens.MenuScreen
import com.example.project1.ui.theme.Project1Theme
import java.util.concurrent.TimeUnit

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            Project1Theme {
                ComposeMultiScreenApp()
            }
        }
    }

    // Método para programar la alarma en segundo plano
    fun scheduleAlarm(delayInMillis: Long) {
        val workRequest = OneTimeWorkRequestBuilder<AlarmWorker>()
            .setInitialDelay(delayInMillis, TimeUnit.MILLISECONDS)
            .build()

        WorkManager.getInstance(this).enqueue(workRequest)
        Toast.makeText(this, "Alarma programada", Toast.LENGTH_SHORT).show()
    }
}

@Composable
fun ComposeMultiScreenApp() {
    val navController = rememberNavController()
    Surface(color = Color.White) {
        SetupNavGraph(navController = navController)
    }
}

@Composable
fun SetupNavGraph(navController: NavHostController) {
    NavHost(navController = navController, startDestination = "menu") {
        composable("menu") { MenuScreen(navController) }
        composable("home") { HomeScreen(navController) }
        composable("componentes") { ComponentsScreen(navController) }
        composable("alarm") {
            AlarmScreen(onSetAlarm = { delay ->
                (navController.context as MainActivity).scheduleAlarm(delay)
            })
        }
    }
}