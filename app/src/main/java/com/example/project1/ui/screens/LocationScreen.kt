package com.example.project1.ui.screens

import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.NavController
import com.example.project1.ui.navigation.NavManager

@Composable
fun LocationScreen(navController: NavController) {
    NavManager(viewModel())
}
