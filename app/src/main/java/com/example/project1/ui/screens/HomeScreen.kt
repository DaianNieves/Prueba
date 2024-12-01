package com.example.project1.ui.screens

import android.util.Log
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.lazy.rememberLazyListState
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Add
import androidx.compose.material3.BottomAppBar
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.FloatingActionButton
import androidx.compose.material3.Icon
import androidx.compose.material3.ModalBottomSheet
import androidx.compose.material3.Scaffold
import androidx.compose.material3.rememberModalBottomSheetState
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.colorResource
import androidx.navigation.NavController
import com.example.project1.R
import com.example.project1.data.model.DataBase.AppDatabase
import com.example.project1.data.model.DataBase.DatabaseProvider
import com.example.project1.data.model.controller.ServiceViewModel
import com.example.project1.data.model.model.ServiceEntity
import com.example.project1.data.model.model.ServiceModel
import com.example.project1.ui.components.ServiceCard
import com.example.project1.ui.components.ServiceDetailCard
import com.example.project1.ui.components.TopBar
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun HomeScreen(
    navController: NavController,
    viewModel: ServiceViewModel = androidx.lifecycle.viewmodel.compose.viewModel()
) {
    val db: AppDatabase = DatabaseProvider.getDatabase(LocalContext.current)
    var serviceDetail by remember { mutableStateOf<ServiceEntity?>(null) }  // Usamos ServiceEntity ahora
    var sheetState = rememberModalBottomSheetState(
        skipPartiallyExpanded = false
    )

    var showBottomSheet by remember { mutableStateOf(false) }

    var services by remember { mutableStateOf<List<ServiceEntity>>(emptyList()) }
    val serviceDao = db.serviceDao()

    // Scaffold para la estructura básica
    Scaffold(
        topBar = { TopBar("Password Manager", navController, false) },
        bottomBar = {
            BottomAppBar(
                containerColor = Color.Black,
                contentColor = Color.White
            ) {
            }
        },
        floatingActionButton = {
            FloatingActionButton(
                containerColor = colorResource(R.color.purple_500),
                contentColor = Color.Black,
                onClick = {
                    navController.navigate("manage-service/0")
                }) {
                Icon(Icons.Default.Add, contentDescription = "Add icon")
            }
        }
    ) { innerPadding ->

        // Si no hay servicios, mostramos un indicador de carga
        if (services.isEmpty()) {
            CircularProgressIndicator()
        }

        // Cargar los servicios desde la base de datos en lugar de la API
        LaunchedEffect(Unit) {
            services = withContext(Dispatchers.IO) {
                serviceDao.getAll() // Obtenemos los servicios desde la base de datos local
            }
        }

        val listState = rememberLazyListState()
        LazyColumn(
            modifier = Modifier
                .padding(innerPadding)
                .background(colorResource(R.color.black))
                .fillMaxSize(),
            state = listState
        ) {
            items(services) { service ->
                ServiceCard(
                    service.id,
                    service.name,
                    service.username,
                    service.imageURL,
                    onButtonClick = {
                        // Al hacer clic, obtenemos el servicio desde la base de datos usando el ID
                        serviceDetail = service // Usamos la entidad ServiceEntity
                        showBottomSheet = true // Mostramos el modal con los detalles
                    }
                )
            }
        }

        // Si el modal está activo, mostrar los detalles del servicio
        if (showBottomSheet) {
            ModalBottomSheet(
                containerColor = colorResource(id = R.color.teal_200),
                contentColor = Color.White,
                modifier = Modifier.fillMaxHeight(),
                onDismissRequest = { showBottomSheet = false },
                sheetState = sheetState
            ) {
                ServiceDetailCard(
                    id = serviceDetail?.id ?: 0,
                    name = serviceDetail?.name ?: "",
                    username = serviceDetail?.username ?: "",
                    password = serviceDetail?.password ?: "",
                    description = serviceDetail?.description ?: "",
                    imageURL = serviceDetail?.imageURL,
                    onEditClick = {
                        showBottomSheet = false
                        navController.navigate("manage-service/" + serviceDetail?.id)
                    }
                )
            }
        }
    }
}
