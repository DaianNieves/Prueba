package com.example.project1.ui.navigation

import androidx.compose.runtime.Composable
import androidx.navigation.NavController
import androidx.navigation.NavType
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import androidx.navigation.navArgument
import com.example.project1.ui.viewModel.SearchViewModel
import com.example.project1.ui.views.HomeView
import com.example.project1.ui.views.MapsSearchView

@Composable
fun NavManager(searchVM: SearchViewModel){
    val navController = rememberNavController()
    NavHost(navController = navController, startDestination = "Home") {
        //Rutas
        composable("Home") {
            HomeView(navController, searchVM)
        }
        // Ruta para `MapsSearchView` que recibe latitud, longitud y dirección como argumentos
        composable("MapsSearchView/{lat}/{long}/{address}", arguments = listOf(
            navArgument("lat") { type = NavType.FloatType },
            navArgument("long") { type = NavType.FloatType },
            navArgument("address") { type = NavType.StringType }
        )) {
            // Obtención de los argumentos con valores predeterminados en caso de que falten
            val lat = it.arguments?.getFloat("lat") ?: 0.0
            val long = it.arguments?.getFloat("long") ?: 0.0
            val address = it.arguments?.getString("address") ?: ""
            MapsSearchView(lat.toDouble(), long.toDouble(), address)
        }
    }
}