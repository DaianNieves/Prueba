package com.example.project1.ui.screens

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController

@Composable
fun MenuScreen(navController: NavController){
    Column (){

        Text(text = "This is the Menu Screen", modifier = Modifier
            .padding(0.dp,30.dp,0.dp,0.dp))

        Button(onClick =  {navController.navigate(route = "home") } ){
            Text(text = "Home Screen")
        }
        Button(onClick =  {navController.navigate(route = "componentes") } ){
            Text(text = "Component Screen")
        }
        Button(onClick = {navController.navigate(route = "Alarm")}){
            Text(text = "Alarm Screen")
        }
        Button(onClick = {navController.navigate(route = "Location")}){
            Text(text = "Location Screen")
        }
        Button(onClick = {navController.navigate(route = "CalendarAPIScreen")}){
            Text(text = "Calendar Screen")
        }
        Button(onClick = {navController.navigate(route = "Biometrics")}){
            Text(text = "Biometrics Screen")
        }
        Button(onClick = {navController.navigate(route = "Camera")}){
            Text(text = "Camera Screen")
        }
        Button(onClick = {navController.navigate(route = "WifiDatos")}){
            Text(text = "WifiDatos Screen")
        }
    }
}