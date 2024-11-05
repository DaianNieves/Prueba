package com.example.project1.ui.screens

import android.content.Intent
import android.hardware.biometrics.BiometricManager.Authenticators.BIOMETRIC_STRONG
import android.hardware.biometrics.BiometricManager.Authenticators.DEVICE_CREDENTIAL
import android.os.Build
import android.provider.Settings
import androidx.activity.compose.rememberLauncherForActivityResult
import androidx.activity.result.contract.ActivityResultContracts
import androidx.appcompat.app.AppCompatActivity
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Button
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import com.example.project1.ui.Biometrics.BiometricPromtManager

@Composable
fun BiometricsScreen(activity: AppCompatActivity) {
    val promptManager by lazy {
        BiometricPromtManager(activity)
    }

    Scaffold(modifier = Modifier.fillMaxSize()) { innerPadding ->
        val biometricResult by promptManager.promtResults.collectAsState(initial = null)
        val enrollLauncher = rememberLauncherForActivityResult(
            contract = ActivityResultContracts.StartActivityForResult(),
            onResult = {
                println("Activity Result $it")
            }
        )

        LaunchedEffect(biometricResult) {
            if (biometricResult is BiometricPromtManager.BiometricResult.AuthenticationNotSet) {
                if (Build.VERSION.SDK_INT >= 30) {
                    val enrollIntent = Intent(Settings.ACTION_BIOMETRIC_ENROLL).apply {
                        putExtra(
                            Settings.EXTRA_BIOMETRIC_AUTHENTICATORS_ALLOWED,
                            BIOMETRIC_STRONG or DEVICE_CREDENTIAL
                        )
                    }
                    enrollLauncher.launch(enrollIntent)
                }
            }
        }

        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(innerPadding),
            verticalArrangement = Arrangement.Center,
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            Button (onClick = {
                promptManager.showBiometricPrompt(
                    title = "Sample prompt",
                    description = "Sample prompt description"
                )
            }) {
                Text(text = "Authenticate")
            }

            biometricResult?.let { result ->
                Text(
                    text = when (result) {
                        is BiometricPromtManager.BiometricResult.AuthenticationError -> result.error
                        BiometricPromtManager.BiometricResult.AuthenticationFailed -> "Authentication failed"
                        BiometricPromtManager.BiometricResult.AuthenticationNotSet -> "Authentication not set"
                        BiometricPromtManager.BiometricResult.AuthenticationSuccess -> "Authentication success"
                        BiometricPromtManager.BiometricResult.FeatureUnavailable -> "Feature unavailable"
                        BiometricPromtManager.BiometricResult.HardwareUnavailable -> "Hardware unavailable"
                    }
                )
            }
        }
    }
}
