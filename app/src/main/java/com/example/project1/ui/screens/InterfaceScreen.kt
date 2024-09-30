package com.example.project1.ui.screens

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.horizontalScroll
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.layout.wrapContentWidth
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyHorizontalGrid
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.AccountBox
import androidx.compose.material.icons.filled.AccountCircle
import androidx.compose.material.icons.filled.Add
import androidx.compose.material.icons.filled.CheckCircle
import androidx.compose.material.icons.filled.Create
import androidx.compose.material.icons.filled.DateRange
import androidx.compose.material.icons.filled.Favorite
import androidx.compose.material.icons.filled.Home
import androidx.compose.material.icons.filled.Info
import androidx.compose.material.icons.filled.MailOutline
import androidx.compose.material.icons.filled.Menu
import androidx.compose.material.icons.filled.Notifications
import androidx.compose.material.icons.filled.Phone
import androidx.compose.material.icons.filled.Search
import androidx.compose.material.icons.filled.ShoppingCart
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.alpha
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import com.example.project1.R


@Composable
fun InterfaceScreen(navController: NavController) {

    //Declaración de variables de color

    val ColorFondo = Color(0xFF232323)
    val ColorBarraSup = Color(0xFF4c4c4c)
    val ColorCont1 = Color(0XFF303030)
    val ColorCont2 = Color(0XFF0f0f0f)
    val scrollState = rememberScrollState()


    Box(
        modifier = Modifier
            .fillMaxSize()
            .background(ColorFondo)
    ) {

        Box() {

            Box(
                modifier = Modifier
                    .fillMaxWidth()
                    .clip(
                        RoundedCornerShape(
                            topStart = 0.dp,
                            topEnd = 0.dp,
                            bottomStart = 16.dp,
                            bottomEnd = 16.dp
                        )
                    )
                    .background(ColorBarraSup)
                    .padding(horizontal = 16.dp)
                    .padding(top = 24.dp)
                    .height(40.dp)

            ) {
                Row(
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(horizontal = 8.dp),
                    horizontalArrangement = Arrangement.SpaceBetween,
                    verticalAlignment = Alignment.CenterVertically
                ) {

                    IconButton(
                        onClick = { /* No hace nada */ },
                        modifier = Modifier.size(30.dp)
                    ) {
                        Icon(
                            Icons.Filled.MailOutline,
                            contentDescription = "Message Icon",
                            modifier = Modifier
                                .size(30.dp),
                            tint = Color.White

                        )
                    }

                    IconButton(
                        onClick = { /* No hace nada */ },
                        modifier = Modifier.size(30.dp)
                    ) {
                        Icon(
                            Icons.Filled.AccountCircle,
                            contentDescription = "Account Icon",
                            modifier = Modifier
                                .size(30.dp),
                            tint = Color.White
                        )
                    }
                }
            }
        }


        Spacer(modifier = Modifier.height(8.dp))

        Box(
            modifier = Modifier
                .fillMaxWidth()
                .padding(20.dp, 80.dp, 20.dp, 0.dp)
        ) {
            Row(
                modifier = Modifier.fillMaxWidth(),
                verticalAlignment = Alignment.CenterVertically,
                horizontalArrangement = Arrangement.SpaceBetween
            ) {
                Spacer(modifier = Modifier.width(8.dp))
                Image(
                    modifier = Modifier
                        .width(28.dp)
                        .height(35.dp),
                    painter = painterResource(id = R.drawable.pslogo),
                    contentDescription = "PS Store Logo",
                    contentScale = ContentScale.Crop
                )

                Text(
                    modifier = Modifier
                        .padding(horizontal = 12.dp),
                    text = "PlayStation Store",
                    color = Color.LightGray,
                    fontWeight = FontWeight.Bold,
                    fontSize = 16.sp
                )

                Spacer(modifier = Modifier.width(30.dp))

                IconButton(
                    onClick = { /* No hace nada */ },
                    modifier = Modifier.size(30.dp)
                ) {
                    Icon(
                        Icons.Filled.Add,
                        contentDescription = "Account Icon",
                        modifier = Modifier
                            .size(30.dp),
                        tint = Color.White

                    )
                }

                Spacer(modifier = Modifier.width(30.dp))

                IconButton(
                    onClick = { /* No hace nada */ },
                    modifier = Modifier.size(30.dp)
                ) {
                    Icon(
                        Icons.Filled.Favorite,
                        contentDescription = "Account Icon",
                        modifier = Modifier
                            .size(30.dp),
                        tint = Color.White
                    )
                }

                Spacer(modifier = Modifier.width(30.dp))

                IconButton(
                    onClick = { /* No hace nada */ },
                    modifier = Modifier.size(30.dp)
                ) {
                    Icon(
                        Icons.Filled.Menu,
                        contentDescription = "Account Icon",
                        modifier = Modifier
                            .size(30.dp),
                        tint = Color.White

                    )
                }
            }
        }

        Box(
            modifier = Modifier
                .padding(0.dp, 130.dp, 0.dp, 100.dp)
        ) {
            Column(
                modifier = Modifier
                    .verticalScroll(rememberScrollState())
            ) {

                Spacer(modifier = Modifier.height(8.dp))

                Card(
                    modifier = Modifier
                        .padding(15.dp, 0.dp, 15.dp, 0.dp)
                        .fillMaxWidth()
                        .height(38.dp), // Ajusta la altura si es necesario
                    colors = CardDefaults.cardColors(containerColor = Color.Black),
                ) {

                    Row(
                        modifier = Modifier
                            .fillMaxWidth()
                            .horizontalScroll(scrollState), // Activar scroll horizontal
                        horizontalArrangement = Arrangement.Start,
                        verticalAlignment = Alignment.CenterVertically
                    ) {
                        Button(
                            onClick = { },
                            colors = ButtonDefaults.buttonColors(containerColor = Color.Black),
                        ) {
                            Text(text = "Más Reciente", fontSize = 14.sp)
                        }

                        Button(
                            onClick = { },
                            colors = ButtonDefaults.buttonColors(containerColor = Color.Black),
                        ) {
                            Text(text = "Colecciones", fontSize = 14.sp)
                        }

                        Button(
                            onClick = { },
                            colors = ButtonDefaults.buttonColors(containerColor = Color.Black),
                        ) {
                            Text(text = "Ofertas", fontSize = 14.sp)
                        }

                        Button(
                            onClick = { },
                            colors = ButtonDefaults.buttonColors(containerColor = Color.Black),
                        ) {
                            Text(text = "Nuevos Juegos", fontSize = 14.sp)
                        }

                        Button(
                            onClick = { },
                            colors = ButtonDefaults.buttonColors(containerColor = Color.Black),
                        ) {
                            Text(text = "Populares", fontSize = 14.sp)
                        }

                        Button(
                            onClick = { },
                            colors = ButtonDefaults.buttonColors(containerColor = Color.Black),
                        ) {
                            Text(text = "Descuentos", fontSize = 14.sp)
                        }
                    }
                }


                Spacer(modifier = Modifier.height(60.dp))

                Box(
                    modifier = Modifier
                        .background(ColorCont1)

                ) {
                    Column(
                        modifier = Modifier

                    ) {
                        Row {
                            Image(
                                modifier = Modifier
                                    .fillMaxWidth()
                                    .height(230.dp),
                                painter = painterResource(id = R.drawable.imagenprincipal),
                                contentDescription = "PS Store Logo",
                                contentScale = ContentScale.Crop
                            )
                        }

                        Row {
                            Text(
                                modifier = Modifier
                                    .padding(14.dp, 10.dp, 0.dp, 0.dp),
                                text = "Uncharted 4: A Thief’s End",
                                color = Color.White,
                                fontSize = 24.sp
                            )
                        }

                        Row {
                            Text(
                                modifier = Modifier
                                    .padding(14.dp, 8.dp, 0.dp, 0.dp),
                                text = "Explora todos los títulos épicos del mundo de Uncharted",
                                color = Color.LightGray,
                                fontSize = 14.sp
                            )
                        }

                        Row {
                            Button(
                                modifier = Modifier
                                    .padding(14.dp, 10.dp, 14.dp, 0.dp),
                                onClick = { /* No hace nada */ },
                                colors = ButtonDefaults.buttonColors(
                                    containerColor = Color.White,
                                    contentColor = Color.Black
                                ),
                            ) {
                                Text(text = "Shop Now", fontSize = 14.sp)
                            }
                        }

                        Spacer(modifier = Modifier.height(10.dp))

                        Box(
                            modifier = Modifier
                                .background(ColorCont2)
                                .fillMaxWidth()
                        ) {
                            Column {
                                Text(
                                    modifier = Modifier
                                        .padding(14.dp, 16.dp, 0.dp, 0.dp),
                                    text = "Novedades",
                                    color = Color.LightGray,
                                    fontSize = 16.sp
                                )

                                Row(
                                    modifier = Modifier
                                        .padding(40.dp, 20.dp, 40.dp, 0.dp)
                                ) {

                                    Column(
                                        modifier = Modifier
                                            .padding(0.dp, 0.dp, 0.dp, 0.dp)
                                    ) {
                                        Image(
                                            modifier = Modifier
                                                .clip(
                                                    RoundedCornerShape(
                                                        topStart = 16.dp,
                                                        topEnd = 16.dp,
                                                        bottomStart = 16.dp,
                                                        bottomEnd = 16.dp
                                                    )
                                                )
                                                .width(150.dp)
                                                .height(150.dp),
                                            painter = painterResource(id = R.drawable.juego1),
                                            contentDescription = "Juego Uno",
                                            contentScale = ContentScale.Crop
                                        )

                                        Image(
                                            modifier = Modifier
                                                .padding(0.dp, 14.dp, 0.dp, 0.dp)
                                                .clip(
                                                    RoundedCornerShape(
                                                        topStart = 16.dp,
                                                        topEnd = 16.dp,
                                                        bottomStart = 16.dp,
                                                        bottomEnd = 16.dp
                                                    )
                                                )
                                                .width(150.dp)
                                                .height(150.dp),
                                            painter = painterResource(id = R.drawable.juego3),
                                            contentDescription = "Juego Tres",
                                            contentScale = ContentScale.Crop
                                        )
                                    }

                                    Spacer(modifier = Modifier.width(30.dp))

                                    Column {
                                        Image(
                                            modifier = Modifier
                                                .clip(
                                                    RoundedCornerShape(
                                                        topStart = 16.dp,
                                                        topEnd = 16.dp,
                                                        bottomStart = 16.dp,
                                                        bottomEnd = 16.dp
                                                    )
                                                )
                                                .width(150.dp)
                                                .height(150.dp),
                                            painter = painterResource(id = R.drawable.juego2),
                                            contentDescription = "Juego Dos",
                                            contentScale = ContentScale.Crop
                                        )

                                        Image(
                                            modifier = Modifier
                                                .padding(0.dp, 14.dp, 0.dp, 0.dp)
                                                .clip(
                                                    RoundedCornerShape(
                                                        topStart = 16.dp,
                                                        topEnd = 16.dp,
                                                        bottomStart = 16.dp,
                                                        bottomEnd = 16.dp
                                                    )
                                                )
                                                .width(150.dp)
                                                .height(150.dp),
                                            painter = painterResource(id = R.drawable.juego4),
                                            contentDescription = "Juego Cuatro",
                                            contentScale = ContentScale.Crop
                                        )
                                    }
                                }

                            }
                        }


                        Box(
                            modifier = Modifier
                                .fillMaxWidth()
                                .background(ColorCont2)
                                .height(220.dp)
                                .padding(0.dp, 16.dp, 0.dp, 0.dp)

                        ) {
                            Column(

                            ) {
                                Row {
                                    Text(
                                        modifier = Modifier
                                            .padding(14.dp, 8.dp, 0.dp, 0.dp),
                                        text = "Los juegos más populares en tu país",
                                        color = Color.LightGray,
                                        fontSize = 16.sp
                                    )
                                }
                                Row(
                                    modifier = Modifier
                                        .padding(10.dp, 0.dp, 10.dp, 0.dp)

                                ) {
                                    LazyHorizontalGrid(
                                        rows = GridCells.Fixed(count = 1),
                                        modifier = Modifier.fillMaxSize(),
                                        contentPadding = PaddingValues(16.dp),
                                        horizontalArrangement = Arrangement.spacedBy(8.dp),
                                        verticalArrangement = Arrangement.spacedBy(8.dp)

                                    ) {
                                        items(4) { index ->
                                            val drawableRes = when (index) {
                                                0 -> R.drawable.juego5
                                                1 -> R.drawable.juego6
                                                2 -> R.drawable.juego7
                                                3 -> R.drawable.juego8
                                                else -> R.drawable.juego5
                                            }
                                            Image(
                                                modifier = Modifier
                                                    .clip(RoundedCornerShape(8.dp))
                                                    .width(150.dp)
                                                    .height(150.dp),
                                                painter = painterResource(id = drawableRes),
                                                contentDescription = "Juego $index",
                                                contentScale = ContentScale.Crop
                                            )
                                        }
                                    }
                                }

                            }
                        }

                        Box(
                            modifier = Modifier
                                .fillMaxWidth()
                                .background(ColorCont2)
                                .height(230.dp)
                                .padding(0.dp, 5.dp, 0.dp, 20.dp)

                        ) {
                            Column(

                            ) {
                                Row {
                                    Text(
                                        modifier = Modifier
                                            .padding(14.dp, 8.dp, 0.dp, 0.dp),
                                        text = "Nuevos juegos para ti",
                                        color = Color.LightGray,
                                        fontSize = 16.sp
                                    )
                                }
                                Row(
                                    modifier = Modifier
                                        .padding(10.dp, 0.dp, 10.dp, 0.dp)

                                ) {
                                    LazyHorizontalGrid(
                                        rows = GridCells.Fixed(count = 1),
                                        modifier = Modifier.fillMaxSize(),
                                        contentPadding = PaddingValues(16.dp),
                                        horizontalArrangement = Arrangement.spacedBy(8.dp),
                                        verticalArrangement = Arrangement.spacedBy(8.dp)
                                    ) {
                                        items(4) { index ->
                                            val drawableRes = when (index) {
                                                0 -> R.drawable.juego9
                                                1 -> R.drawable.juego10
                                                2 -> R.drawable.juego11
                                                3 -> R.drawable.juego12
                                                else -> R.drawable.juego9
                                            }
                                            Image(
                                                modifier = Modifier
                                                    .clip(RoundedCornerShape(8.dp))
                                                    .width(150.dp)
                                                    .height(150.dp),
                                                painter = painterResource(id = drawableRes),
                                                contentDescription = "Juego $index",
                                                contentScale = ContentScale.Crop
                                            )
                                        }
                                    }
                                }

                            }
                        }

                        Box(
                            modifier = Modifier
                                .background(ColorCont1)
                                .padding(0.dp,0.dp,0.dp,15.dp)

                        ) {
                            Column(
                                modifier = Modifier

                            ) {
                                Row {
                                    Image(
                                        modifier = Modifier
                                            .fillMaxWidth()
                                            .height(230.dp),
                                        painter = painterResource(id = R.drawable.imagensecundaria),
                                        contentDescription = "PS Store Logo",
                                        contentScale = ContentScale.Crop
                                    )
                                }

                                Row {
                                    Text(
                                        modifier = Modifier
                                            .padding(14.dp, 10.dp, 0.dp, 0.dp),
                                        text = "PlayStation Plus: Descuentos",
                                        color = Color.White,
                                        fontSize = 24.sp
                                    )
                                }

                                Row {
                                    Text(
                                        modifier = Modifier
                                            .padding(14.dp, 8.dp, 0.dp, 0.dp),
                                        text = "Ahorra en grandes juegos con estos descuentos exclusivos",
                                        color = Color.LightGray,
                                        fontSize = 14.sp
                                    )
                                }

                                Row {
                                    Button(
                                        modifier = Modifier
                                            .padding(14.dp, 10.dp, 14.dp, 0.dp),
                                        onClick = { /* No hace nada */ },
                                        colors = ButtonDefaults.buttonColors(
                                            containerColor = Color.White,
                                            contentColor = Color.Black
                                        ),
                                    ) {
                                        Text(text = "Suscribe Now", fontSize = 14.sp)
                                    }
                                }
                            }
                        }

                        val buttonTexts = listOf("Todos los Juegos", "Todos los Juegos", "Descuentos", "Complementos", "Nuevo Texto", "Otro Texto", "Otro otro texto","Sopa")
                        val buttonIcons = listOf(
                            Icons.Default.CheckCircle,
                            Icons.Default.CheckCircle,
                            Icons.Default.Notifications,
                            Icons.Default.Create,
                            Icons.Default.Create,
                            Icons.Default.Create,
                            Icons.Default.Home,
                            Icons.Default.Home
                        )

                        Box(
                            modifier = Modifier
                                .fillMaxWidth()
                                .background(ColorCont2)
                                .padding(0.dp, 5.dp, 0.dp, 20.dp)
                        ) {
                            Row(
                                modifier = Modifier
                                    .padding(14.dp, 8.dp, 0.dp, 0.dp),
                            ) {
                                Text(
                                    modifier = Modifier
                                        .padding(14.dp, 8.dp, 0.dp, 0.dp),
                                    text = "Nuevos juegos para ti",
                                    color = Color.LightGray,
                                    fontSize = 16.sp
                                )
                            }

                            Column(
                                modifier = Modifier
                                    .padding(0.dp, 36.dp, 0.dp, 0.dp),
                                horizontalAlignment = Alignment.CenterHorizontally
                            ) {

                                Column(
                                    modifier = Modifier
                                        .fillMaxSize()
                                        .padding(10.dp),
                                    verticalArrangement = Arrangement.spacedBy(8.dp)
                                ) {
                                    val numColumns = 2 // Número de columnas por fila
                                    val numRows = (buttonTexts.size + numColumns - 1) / numColumns // Calcula cuántas filas se necesitan

                                    repeat(numRows) { rowIndex ->
                                        Row(
                                            modifier = Modifier
                                                .fillMaxWidth()
                                                .wrapContentWidth(Alignment.CenterHorizontally),
                                            horizontalArrangement = Arrangement.spacedBy(30.dp)
                                        ) {
                                            repeat(numColumns) { columnIndex ->
                                                val index = rowIndex * numColumns + columnIndex
                                                if (index < buttonTexts.size) {
                                                    Box(
                                                        modifier = Modifier
                                                            .size(150.dp)
                                                            .clip(RoundedCornerShape(8.dp))
                                                            .background(ColorCont1)
                                                            .clickable { /* Acción del botón */ },
                                                        contentAlignment = Alignment.Center
                                                    ) {
                                                        Column(
                                                            horizontalAlignment = Alignment.CenterHorizontally,
                                                            verticalArrangement = Arrangement.Center
                                                        ) {
                                                            Icon(
                                                                imageVector = buttonIcons[index],
                                                                contentDescription = "Ícono del juego",
                                                                modifier = Modifier.size(40.dp),
                                                                tint = Color.White
                                                            )
                                                            Spacer(modifier = Modifier.height(4.dp))
                                                            Text(
                                                                text = buttonTexts[index],
                                                                fontSize = 14.sp,
                                                                color = Color.White
                                                            )
                                                        }
                                                    }
                                                }
                                            }
                                        }
                                    }
                                }
                            }
                        }


                    }
                }
            }
        }

        //Barra de Navegación Inferior
        Box(
            modifier = Modifier
                .align(Alignment.BottomCenter)
        ) {
            Box(
                modifier = Modifier
                    .fillMaxWidth()
                    .height(100.dp)
            ) {

                Column {
                    Row(
                        modifier = Modifier
                            .fillMaxWidth()
                            .alpha(0.5f)
                            .background(ColorCont1)
                            .padding(20.dp, 12.dp, 20.dp, 6.dp),
                        horizontalArrangement = Arrangement.SpaceBetween,
                        verticalAlignment = Alignment.CenterVertically
                    ) {
                        IconButton(
                            onClick = { /* No hace nada */ },
                            modifier = Modifier.size(30.dp)
                        ) {
                            Icon(
                                Icons.Filled.Phone,
                                contentDescription = "Message Icon",
                                modifier = Modifier
                                    .size(30.dp),
                                tint = Color.White

                            )
                        }
                        IconButton(
                            onClick = { /* No hace nada */ },
                            modifier = Modifier.size(30.dp)
                        ) {
                            Icon(
                                Icons.Filled.Info,
                                contentDescription = "Message Icon",
                                modifier = Modifier
                                    .size(30.dp),
                                tint = Color.White

                            )
                        }
                        IconButton(
                            onClick = { /* No hace nada */ },
                            modifier = Modifier.size(30.dp)
                        ) {
                            Icon(
                                Icons.Filled.ShoppingCart,
                                contentDescription = "Message Icon",
                                modifier = Modifier
                                    .size(30.dp),
                                tint = Color.White

                            )
                        }
                        IconButton(
                            onClick = { /* No hace nada */ },
                            modifier = Modifier.size(30.dp)
                        ) {
                            Icon(
                                Icons.Filled.DateRange,
                                contentDescription = "Message Icon",
                                modifier = Modifier
                                    .size(30.dp),
                                tint = Color.White

                            )
                        }
                        IconButton(
                            onClick = { /* No hace nada */ },
                            modifier = Modifier.size(30.dp)
                        ) {
                            Icon(
                                Icons.Filled.Search,
                                contentDescription = "Search Icon",
                                modifier = Modifier
                                    .size(30.dp),
                                tint = Color.White

                            )
                        }
                    }
                    Row(
                        modifier = Modifier
                            .fillMaxWidth()
                            .background(ColorCont1)
                            .padding(0.dp, 10.dp, 0.dp, 10.dp),
                        horizontalArrangement = Arrangement.Center
                    ) {
                        Text(
                            text = "PS Store",
                            color = Color.LightGray,
                            fontSize = 16.sp,
                        )
                    }
                }
            }
        }
    }
}

