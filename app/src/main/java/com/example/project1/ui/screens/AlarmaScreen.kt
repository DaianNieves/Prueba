package com.example.project1.ui.screens

import android.app.TimePickerDialog
import android.widget.Toast
import androidx.compose.foundation.layout.*
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import java.util.*

@Composable
fun AlarmScreen(onSetAlarm: (Long) -> Unit) {
    var selectedTime by remember { mutableStateOf("") }
    var calendar = Calendar.getInstance()
    val context = LocalContext.current

    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(16.dp),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Text(
            text = "Configura la Alarma",
            fontSize = 24.sp,
            modifier = Modifier.padding(bottom = 16.dp)
        )

        Text(text = "Hora seleccionada: $selectedTime", fontSize = 18.sp)

        Spacer(modifier = Modifier.height(16.dp))

        Button(onClick = {
            TimePickerDialog(
                context,
                { _, hour: Int, minute: Int ->
                    calendar = Calendar.getInstance().apply {
                        set(Calendar.HOUR_OF_DAY, hour)
                        set(Calendar.MINUTE, minute)
                        set(Calendar.SECOND, 0)
                    }
                    selectedTime = String.format("%02d:%02d", hour, minute)

                    val currentTime = Calendar.getInstance().timeInMillis
                    val delayInMillis = calendar.timeInMillis - currentTime

                    if (delayInMillis > 0) {
                        onSetAlarm(delayInMillis)
                    } else {
                        Toast.makeText(context, "Selecciona una hora futura", Toast.LENGTH_SHORT).show()
                    }
                },
                calendar.get(Calendar.HOUR_OF_DAY),
                calendar.get(Calendar.MINUTE),
                true
            ).show()
        }) {
            Text("Seleccionar Hora")
        }
    }
}