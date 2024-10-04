package com.example.project1.ui.screens

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController

@Composable
fun HomeScreen (navController: NavController){
    Column {
        Text(text = "This is the HomeScreen",  modifier = Modifier
            .padding(0.dp,30.dp,0.dp,0.dp))
    }
}