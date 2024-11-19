package com.example.project1

import android.content.Context
import android.net.ConnectivityManager
import android.net.wifi.WifiManager
import android.os.Bundle
import android.widget.Toast
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.compose.material3.Surface
import androidx.compose.runtime.Composable
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import androidx.work.OneTimeWorkRequestBuilder
import androidx.work.WorkManager
import com.example.project1.ui.screens.AlarmScreen
import com.example.project1.ui.screens.AlarmWorker
import com.example.project1.ui.screens.BiometricsScreen
import com.example.project1.ui.screens.CalendarAPIScreen
import com.example.project1.ui.screens.CameraScreen
import com.example.project1.ui.screens.ComponentsScreen
import com.example.project1.ui.screens.HomeScreen
import com.example.project1.ui.screens.LocationScreen
import com.example.project1.ui.screens.MenuScreen
import com.example.project1.ui.screens.WifiDatosScreen
import java.util.concurrent.TimeUnit

//import androidx.navigation.compose.NavHostController

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            ComposeMultiScreenApp(this)
            /*
            /*Project1Theme {
                Scaffold(modifier = Modifier.fillMaxSize()) { innerPadding ->
                    Greeting(
                        name = "Daián",
                        modifier = Modifier.padding(innerPadding)
                    )
                }
            }*/

            //layouts

           /*Column{
                Text(text = "First Row")
                Text(text = "Second Row")
                Text(text = "Third Row")
                Row{
                    Text(text = "TEXT 1")
                    Text(text = "TEXT 2")
                    Text(text = "TEXT 3")
                    Text(text = "TEXT 4")
                }
                Box{
                    Text(text = "Label 1")
                    Text(text = "Label 2")
                }
                Greeting(name = "World")
            }*/

            Column(
                modifier = Modifier.fillMaxSize()
                    .fillMaxSize()
                    .verticalScroll(rememberScrollState()),
                verticalArrangement = Arrangement.Center,
                horizontalAlignment = androidx.compose.ui.Alignment.CenterHorizontally
            ){
                CustomText()
                PictureComposable()
                Content1()
                Content2()
                BoxExample()
                BoxExample2()

            }*/

        }
    }

    fun scheduleAlarm(delayInMillis: Long) {
        val workRequest = OneTimeWorkRequestBuilder<AlarmWorker>()
            .setInitialDelay(delayInMillis, TimeUnit.MILLISECONDS)
            .build()

        WorkManager.getInstance(this).enqueue(workRequest)
        Toast.makeText(this, "Alarma programada", Toast.LENGTH_SHORT).show()
    }

}
/*
@Composable
fun Greeting(name: String, modifier: Modifier = Modifier) {
    Text(
        text = "Hello $name!",
        modifier = modifier
    )
}

//@Preview(showBackground = true)
@Composable
fun GreetingPreview() {
    Project1Theme {
        Greeting("Android")
    }
}

//@Preview(showBackground = true)
@Composable
fun ModifierExample(){
    Column(
        modifier = Modifier
            .padding(24.dp)
    ) {
        Text(text = "Hello World")
    }
}

//@Preview(showBackground = true)
@Composable
fun ModifierExample2(){
    Column(
        modifier = Modifier
            .padding(24.dp)
            .fillMaxWidth()
            .clickable(onClick = { clickAction() })
    ) {
        Text(text = "Hello World")
    }
}

//@Preview(showBackground = true)
@Composable
fun ModifierExample3(){
    Column(
        modifier = Modifier
            .fillMaxHeight()
            .padding(16.dp)
            .background(Color.Cyan)
            .border(width = 2.dp, color = Color.Green)
            .width(200.dp),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.SpaceEvenly
    ) {
        Text(text = "Item 1")
        Text(text = "Item 2")
        Text(text = "Item 3")
        Text(text = "Item 4")
        Text(text = "Item 5")
    }
}

//@Preview(showBackground = true)
@Composable
fun CustomText(){
    Column{
        Text(
            stringResource(R.string.hello_world_text),
            color = colorResource(R.color.purple_700),
            fontSize = 28.sp,
            fontStyle = FontStyle.Italic,
            fontWeight = FontWeight.ExtraBold
        )
        val gradientColors = listOf(Color.Cyan, Color.Blue, Color.Red)
        Text(
            stringResource(R.string.hello_world_text),
            style = TextStyle(brush = Brush.linearGradient(colors = gradientColors))
        )
    }
}

//@Preview(showBackground = true)
@Composable
fun PictureComposable(){
    Column (
        modifier = Modifier
            .fillMaxWidth()
            .background(Color.Black)
    ){
        Image(
            modifier = Modifier
                .fillMaxWidth(),
            painter = painterResource(R.drawable.android_logo),
            contentDescription = "Logo Android",
            contentScale = ContentScale.Crop
        )
    }
}


//@Preview(showBackground = true)
@Composable
fun Content1(){
    Card(
        modifier = Modifier
            .background(Color.LightGray)
            .fillMaxWidth()
            .padding(5.dp)
    ){
        Text (text = "This is a Title",
        fontSize = 24.sp,
            fontWeight = FontWeight.Bold,
            modifier = Modifier
                .padding(10.dp)
        )
        Image(
            modifier = Modifier
                .fillMaxWidth(),
            painter = painterResource(id = R.drawable.android_logo),
            contentDescription = "Android Logo",
            contentScale = ContentScale.Crop
        )
        Text(
            stringResource(R.string.text_card),
            textAlign = TextAlign.Justify,
            lineHeight = 18.sp,
            modifier = Modifier
            .padding(10.dp)
        )
    }
}

//@Preview(showBackground = true)
@Composable
fun Content2(){
    Card(
        modifier = Modifier
            .background(Color.LightGray)
            .fillMaxWidth()
            .padding(5.dp)
    ){
        Row {
            Image(
                modifier = Modifier
                    .width(150.dp)
                    .height(150.dp),
                    //.fillMaxWidth()
                painter = painterResource(id = R.drawable.android_logo),
                contentDescription = "Android Logo",
                contentScale = ContentScale.Crop
            )
            Column {
                Text (text = "This is a Title",
                    fontSize = 24.sp,
                    fontWeight = FontWeight.Bold,
                    modifier = Modifier
                        .padding(10.dp)
                )
                Text(
                    stringResource(R.string.text_card),
                    textAlign = TextAlign.Justify,
                    lineHeight = 18.sp,
                    maxLines = 4,
                    modifier = Modifier
                        .padding(10.dp)
                )
            }


        }

    }
}

@Preview(showBackground = true)
@Composable
fun BoxExample(){
    Box(
        modifier = Modifier
            .background(Color.DarkGray)
            .fillMaxWidth()
            .padding(5.dp)
    ){
        Image(painterResource(R.drawable.android_logo),
            contentDescription = "Android Logo",
            contentScale = ContentScale.FillBounds
        )

        Row(
            modifier = Modifier
                .background(Color.Red)
                .fillMaxWidth()
                .padding(0.dp,0.dp),
            horizontalArrangement = Arrangement.Center

        ){
            Icon(
                Icons.Filled.AccountBox,
                contentDescription = "Icon Account"
            )
            Text(text = "Text")
        }



    }
}

@Preview(showBackground = true)
@Composable
fun BoxExample2(){
    Box(
        modifier = Modifier
            .background(Color.Magenta)
            .padding(5.dp)
            .size(250.dp)
    ){
        Text(text = "TopStart", Modifier.align(Alignment.TopStart))
        Text(text = "TopEnd", Modifier.align(Alignment.TopEnd))

        Text(text = "CenterStart", Modifier.align(Alignment.CenterStart))
        Text(text = "Center", Modifier.align(Alignment.Center))
        Text(text = "CenterEnd", Modifier.align(Alignment.CenterEnd))

        Text(text = "BottomStart", Modifier.align(Alignment.BottomStart))
        Text(text = "BottomEnd", Modifier.align(Alignment.BottomEnd))

    }
}

fun clickAction(){
    println("Column Clicked")
}
*/

@Composable
fun ComposeMultiScreenApp(activity: AppCompatActivity){
    val navController = rememberNavController()
    Surface (color = Color.White) {
        SetupNavGraph(navController = navController, activity)
    }
}

@Composable
fun SetupNavGraph(navController: NavHostController, activity: AppCompatActivity) {
    NavHost(navController = navController, startDestination = "menu") {
        composable("menu") { MenuScreen(navController) }
        composable("home") { HomeScreen(navController) }
        composable("componentes") { ComponentsScreen(navController) }
        composable("alarm") {
            AlarmScreen { delay ->
                (navController.context as MainActivity).scheduleAlarm(delay)
            }
        }
        composable("Location"){ LocationScreen((navController)) }
        composable("CalendarAPIScreen"){ CalendarAPIScreen(navController) }
        composable("Biometrics") { BiometricsScreen(activity)}
        composable("Camera") { CameraScreen(navController) }
        composable("WifiDatos") {
            val context = LocalContext.current as? ComponentActivity
            if (context != null) {
                val wifiManager = context.getSystemService(Context.WIFI_SERVICE) as? WifiManager
                val connectivityManager =
                    context.getSystemService(Context.CONNECTIVITY_SERVICE) as? ConnectivityManager

                if (wifiManager != null && connectivityManager != null) {
                    WifiDatosScreen(
                        wifiManager = wifiManager,
                        connectivityManager = connectivityManager,
                        context = context,

                        )
                }
            }
        }
    }
}

