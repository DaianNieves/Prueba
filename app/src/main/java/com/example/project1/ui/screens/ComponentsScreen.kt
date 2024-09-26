package com.example.project1.ui.screens

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.AccountBox
import androidx.compose.material.icons.filled.Add
import androidx.compose.material3.AssistChip
import androidx.compose.material3.AssistChipDefaults
import androidx.compose.material3.Button
import androidx.compose.material3.DrawerValue
import androidx.compose.material3.ElevatedButton
import androidx.compose.material3.ExtendedFloatingActionButton
import androidx.compose.material3.FilledTonalButton
import androidx.compose.material3.FilterChip
import androidx.compose.material3.FloatingActionButton
import androidx.compose.material3.HorizontalDivider
import androidx.compose.material3.Icon
import androidx.compose.material3.LargeFloatingActionButton
import androidx.compose.material3.ModalDrawerSheet
import androidx.compose.material3.ModalNavigationDrawer
import androidx.compose.material3.NavigationDrawerItem
import androidx.compose.material3.OutlinedButton
import androidx.compose.material3.SmallFloatingActionButton
import androidx.compose.material3.Text
import androidx.compose.material3.TextButton
import androidx.compose.material3.rememberDrawerState
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import androidx.navigation.Navigation
import kotlinx.coroutines.launch

@Composable
fun ComponentsScreen(navController: NavController) {
    var component by remember { mutableStateOf("") } //Actualizar el valor de la variable
    val drawerState = rememberDrawerState(initialValue = DrawerValue.Closed)
    val scope = rememberCoroutineScope()
    ModalNavigationDrawer(  //current state of drawer
        drawerState = drawerState,
        //drawer content
        drawerContent = {
            ModalDrawerSheet {
                Text("Menu", modifier = Modifier.padding(16.dp))
                //Content 1
                HorizontalDivider()
                NavigationDrawerItem(
                    label = { Text(text = "Content 1") },
                    selected = false,
                    onClick = {
                        component = "Content 1"
                        scope.launch {
                            drawerState.apply {
                                close()
                            }
                        }
                    }
                )

                //Content 2
                NavigationDrawerItem(
                    label = { Text(text = "Content 2") },
                    selected = false,
                    onClick = {
                        component = "Content 2"
                        scope.launch {
                            drawerState.apply {
                                close()
                            }
                        }
                    }
                )

                //Buttons
                NavigationDrawerItem(
                    label = { Text(text = "Buttons") },
                    selected = false,
                    onClick = {
                        component = "Buttons"
                        scope.launch {
                            drawerState.apply {
                                close()
                            }
                        }
                    }
                )

                //FloatingButtons
                NavigationDrawerItem(
                    label = { Text(text = "FloatingButtons") },
                    selected = false,
                    onClick = {
                        component = "FloatingButtons"
                        scope.launch {
                            drawerState.apply {
                                close()
                            }
                        }
                    }
                )

                //Chips
                NavigationDrawerItem(
                    label = { Text(text = "Chips") },
                    selected = false,
                    onClick = {
                        component = "Chips"
                        scope.launch {
                            drawerState.apply {
                                close()
                            }
                        }
                    }
                )
            }
        }
    ) {
        //ScreenContent
        Column {
            when (component) {
                "Content 1" -> {
                    Content1()
                }

                "Content 2" -> {
                    Content2()
                }

                "Buttons" -> {
                    Buttons()
                }

                "FloatingButtons" -> {
                    FloatingButtons()
                }

                "Chips" -> {
                    Chips()
                }
            }
        }
    }
}

@Composable
fun Content1() {
    Text(
        text = "Content 1", modifier = Modifier
            .padding(0.dp, 30.dp, 0.dp, 0.dp)
    )
}

@Composable
fun Content2() {
    Text(
        text = "Content 2", modifier = Modifier
            .padding(0.dp, 30.dp, 0.dp, 0.dp)
    )
}

@Composable
fun Buttons() {
    Column(
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.SpaceEvenly,
        modifier = Modifier
            .fillMaxSize()
    ) {
        Button(onClick = {}) {
            Text(text = "Filled")
        }

        FilledTonalButton(onClick = {}) {
            Text(text = "Tonal")
        }

        OutlinedButton(onClick = {}) {
            Text(text = "Outlined")
        }

        ElevatedButton(onClick = {}) {
            Text(text = "Elevated")
        }

        TextButton(onClick = {}) {
            Text(text = "Text")
        }
    }
}

@Composable
fun FloatingButtons() {
    Column(
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.SpaceEvenly,
        modifier = Modifier
            .fillMaxSize()
    ) {

        FloatingActionButton(onClick = {}) {
            Icon(Icons.Filled.Add, contentDescription = "")
        }

        SmallFloatingActionButton(onClick = {}) {
            Icon(Icons.Filled.Add, contentDescription = "")
        }

        LargeFloatingActionButton(onClick = {}) {
            Icon(Icons.Filled.Add, contentDescription = "")
        }

        ExtendedFloatingActionButton(
            onClick = {},
            icon = { Icon(Icons.Filled.Add, contentDescription = "") },
            text = { Text(text = "Extended FAB") }
        )
    }
}

@Preview(showBackground = true)
@Composable
fun Chips() {
    Column(
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.SpaceEvenly,
        modifier = Modifier
            .fillMaxSize()
    ) {
        AssistChip(
            onClick = {},
            label = { Text(text = "Assist Chip") },
            leadingIcon = {
                Icon(
                    Icons.Filled.AccountBox, contentDescription = "",
                    modifier = Modifier
                        .size(AssistChipDefaults.IconSize)
                )
            }
        )

        var selected by remember { mutableStateOf(false) }

        FilterChip(
            selected = selected,
            onClick = { selected = !selected },
            label = { Text(text = "Filter Chip") },
            leadingIcon = if (selected) {
                {
                    Icon(
                        Icons.Filled.AccountBox, contentDescription = "",
                        modifier = Modifier
                            .size(AssistChipDefaults.IconSize)
                    )
                }
            } else{
                null
            }
        )
    }
}
