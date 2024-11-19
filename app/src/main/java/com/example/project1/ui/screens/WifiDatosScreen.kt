package com.example.project1.ui.screens

import android.Manifest
import android.content.pm.PackageManager
import android.net.ConnectivityManager
import android.net.NetworkCapabilities
import android.net.TrafficStats
import android.net.wifi.WifiInfo
import android.net.wifi.WifiManager
import android.util.Log
import android.widget.Toast
import androidx.activity.ComponentActivity
import androidx.activity.compose.rememberLauncherForActivityResult
import androidx.activity.result.contract.ActivityResultContracts
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.core.content.ContextCompat
import coil.compose.rememberImagePainter
import kotlinx.coroutines.delay

@Composable
fun WifiDatosScreen(
    wifiManager: WifiManager,
    connectivityManager: ConnectivityManager,
    context: ComponentActivity
) {
    var connectionStatus by remember { mutableStateOf("Sin conexión a Internet") }
    var mobileDataUsage by remember { mutableStateOf(0L) }
    var wifiDataUsage by remember { mutableStateOf(0L) }
    var networkSpeed by remember { mutableStateOf(0) }
    val dataUsageLimit = 500 // Límite de datos en MB
    var isHighQualityImage by remember { mutableStateOf(false) }

    // Solicitar permisos de ubicación si es necesario
    val requestPermissionsLauncher =
        rememberLauncherForActivityResult(ActivityResultContracts.RequestMultiplePermissions()) { permissions ->
            if (permissions[Manifest.permission.ACCESS_FINE_LOCATION] == true ||
                permissions[Manifest.permission.ACCESS_COARSE_LOCATION] == true
            ) {
                Toast.makeText(context, "Permisos necesarios concedidos", Toast.LENGTH_SHORT).show()
            } else {
                Toast.makeText(context, "Permisos necesarios no concedidos", Toast.LENGTH_SHORT).show()
            }
        }

    LaunchedEffect(Unit) {
        val permissions = listOf(
            Manifest.permission.ACCESS_FINE_LOCATION,
            Manifest.permission.ACCESS_COARSE_LOCATION
        ).filter {
            ContextCompat.checkSelfPermission(context, it) != PackageManager.PERMISSION_GRANTED
        }

        if (permissions.isNotEmpty()) {
            requestPermissionsLauncher.launch(permissions.toTypedArray())
        }

        var lastMobileBytes = TrafficStats.getMobileRxBytes() + TrafficStats.getMobileTxBytes()
        var lastWifiBytes = TrafficStats.getTotalRxBytes() - lastMobileBytes // Bytes en WiFi

        while (true) {
            connectionStatus = getConnectionStatus(wifiManager, connectivityManager, context)
            val isMobileConnected = checkIfMobileDataActive(connectivityManager)
            isHighQualityImage = !isMobileConnected // Alta calidad si no está en datos móviles

            val currentMobileBytes = TrafficStats.getMobileRxBytes() + TrafficStats.getMobileTxBytes()
            val currentWifiBytes = TrafficStats.getTotalRxBytes() - currentMobileBytes

            val mobileDataUsed = currentMobileBytes - lastMobileBytes
            val wifiDataUsed = currentWifiBytes - lastWifiBytes

            if (isMobileConnected && mobileDataUsed > 0) {
                networkSpeed = ((mobileDataUsed * 8) / 1024).toInt() // Velocidad en kbps
                mobileDataUsage += mobileDataUsed
                lastMobileBytes = currentMobileBytes

                if ((mobileDataUsage / (1024 * 1024)) >= dataUsageLimit) {
                    Toast.makeText(
                        context,
                        "¡Has alcanzado el límite de datos móviles: $dataUsageLimit MB!",
                        Toast.LENGTH_LONG
                    ).show()
                }
            } else if (!isMobileConnected && wifiDataUsed > 0) {
                networkSpeed = ((wifiDataUsed * 8) / 1024).toInt() // Velocidad en kbps
                wifiDataUsage += wifiDataUsed
                lastWifiBytes = currentWifiBytes
            } else {
                networkSpeed = 0
            }

            Log.d("NetworkMonitoring", "Estado de la conexión: $connectionStatus")
            Log.d("NetworkMonitoring", "Consumo de datos móviles: ${mobileDataUsage / (1024 * 1024)} MB")
            Log.d("NetworkMonitoring", "Consumo de datos WiFi: ${wifiDataUsage / (1024 * 1024)} MB")
            Log.d("NetworkMonitoring", "Velocidad de red: $networkSpeed kbps")

            // Composición en tiempo real
            connectionStatus = getConnectionStatus(wifiManager, connectivityManager, context)

            delay(500L) // Actualización cada medio segundo
        }
    }

    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(16.dp),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Top
    ) {
        if (connectionStatus != "Sin conexión a Internet") {
            NetworkImage(isHighQuality = isHighQualityImage)
        } else {
            Text(
                "Sin conexión para cargar la imagen",
                fontSize = 18.sp,
                color = MaterialTheme.colorScheme.error
            )
        }

        Spacer(modifier = Modifier.height(16.dp))

        ConnectionCard("Estado de la Conexión", connectionStatus, networkSpeed)
        Spacer(modifier = Modifier.height(16.dp))
        ConnectionCard(
            "Consumo Actual de Datos Móviles",
            "${mobileDataUsage / (1024 * 1024)} MB de $dataUsageLimit MB"
        )
        Spacer(modifier = Modifier.height(16.dp))
        ConnectionCard(
            "Consumo Actual de Datos WiFi",
            "${wifiDataUsage / (1024 * 1024)} MB"
        )
    }
}

@Composable
fun NetworkImage(isHighQuality: Boolean) {
    val imageUrl = if (isHighQuality) {
        "https://st4.depositphotos.com/5906210/40964/i/450/depositphotos_409642058-stock-photo-smoky-sunset-santa-cruz-mountains.jpg"
    } else {
        "https://mott.pe/noticias/wp-content/uploads/2018/06/otro-de-los-errores-en-las-fotos-de-paisajes-es-enfocar-siempre-el-infinito-de-la-escena.png"
    }

    Image(
        painter = rememberImagePainter(data = imageUrl),
        contentDescription = "Imagen de Red",
        modifier = Modifier
            .fillMaxWidth()
            .height(200.dp)
    )
}

@Composable
fun ConnectionCard(title: String, content: String, networkSpeed: Int? = null) {
    Card(
        modifier = Modifier.fillMaxWidth(),
        shape = RoundedCornerShape(12.dp),
        elevation = CardDefaults.cardElevation(defaultElevation = 4.dp)
    ) {
        Column(
            modifier = Modifier.padding(16.dp),
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            Text(
                text = title,
                fontSize = 24.sp,
                fontWeight = FontWeight.Bold,
                color = MaterialTheme.colorScheme.primary
            )
            Text(text = content, fontSize = 18.sp, color = MaterialTheme.colorScheme.onSurface)
            networkSpeed?.let {
                Text(
                    text = "Velocidad de Red: $it kbps",
                    fontSize = 18.sp,
                    color = MaterialTheme.colorScheme.secondary
                )
            }
        }
    }
}

fun getConnectionStatus(
    wifiManager: WifiManager,
    connectivityManager: ConnectivityManager,
    context: ComponentActivity
): String {
    val networkCapabilities =
        connectivityManager.getNetworkCapabilities(connectivityManager.activeNetwork)
    val isWifiConnected =
        wifiManager.isWifiEnabled && networkCapabilities?.hasTransport(NetworkCapabilities.TRANSPORT_WIFI) == true
    val isMobileConnected =
        networkCapabilities?.hasTransport(NetworkCapabilities.TRANSPORT_CELLULAR) == true

    return when {
        isWifiConnected -> {
            if (ContextCompat.checkSelfPermission(
                    context,
                    Manifest.permission.ACCESS_FINE_LOCATION
                ) == PackageManager.PERMISSION_GRANTED
            ) {
                val wifiInfo: WifiInfo? = wifiManager.connectionInfo
                val ssid = wifiInfo?.ssid?.replace("\"", "") ?: "Desconocido"
                "Conectado a WiFi: $ssid"
            } else {
                "Conectado a WiFi (Nombre de red no disponible)"
            }
        }

        isMobileConnected -> "Conectado a Datos Móviles"
        else -> "Sin conexión a Internet"
    }
}

fun checkIfMobileDataActive(connectivityManager: ConnectivityManager): Boolean {
    return connectivityManager.getNetworkCapabilities(connectivityManager.activeNetwork)
        ?.hasTransport(NetworkCapabilities.TRANSPORT_CELLULAR) == true
}
