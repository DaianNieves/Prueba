package com.example.project1.ui.screens

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.offset
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.foundation.lazy.grid.items
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.AccountBox
import androidx.compose.material.icons.filled.Add
import androidx.compose.material.icons.filled.Check
import androidx.compose.material.icons.filled.Close
import androidx.compose.material.icons.filled.DateRange
import androidx.compose.material.icons.filled.Home
import androidx.compose.material.icons.filled.Menu
import androidx.compose.material.icons.filled.Person
import androidx.compose.material.icons.filled.Settings
import androidx.compose.material.icons.filled.ShoppingCart
import androidx.compose.material.icons.filled.Star
import androidx.compose.material.icons.filled.Warning
import androidx.compose.material.icons.outlined.Email
import androidx.compose.material.icons.outlined.Home
import androidx.compose.material.icons.outlined.Menu
import androidx.compose.material.icons.outlined.Person
import androidx.compose.material.icons.outlined.Search
import androidx.compose.material.icons.outlined.Settings
import androidx.compose.material3.AlertDialog
import androidx.compose.material3.AssistChip
import androidx.compose.material3.AssistChipDefaults
import androidx.compose.material3.Badge
import androidx.compose.material3.BadgedBox
import androidx.compose.material3.Button
import androidx.compose.material3.Checkbox
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.material3.DatePicker
import androidx.compose.material3.DrawerValue
import androidx.compose.material3.ElevatedButton
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.ExtendedFloatingActionButton
import androidx.compose.material3.FilledTonalButton
import androidx.compose.material3.FilterChip
import androidx.compose.material3.FloatingActionButton
import androidx.compose.material3.HorizontalDivider
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.InputChip
import androidx.compose.material3.InputChipDefaults
import androidx.compose.material3.LargeFloatingActionButton
import androidx.compose.material3.LinearProgressIndicator
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.ModalDrawerSheet
import androidx.compose.material3.ModalNavigationDrawer
import androidx.compose.material3.NavigationDrawerItem
import androidx.compose.material3.OutlinedButton
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Slider
import androidx.compose.material3.SmallFloatingActionButton
import androidx.compose.material3.Snackbar
import androidx.compose.material3.SnackbarHost
import androidx.compose.material3.SnackbarHostState
import androidx.compose.material3.Switch
import androidx.compose.material3.Text
import androidx.compose.material3.TextButton
import androidx.compose.material3.TimeInput
import androidx.compose.material3.TimePicker
import androidx.compose.material3.adaptive.currentWindowAdaptiveInfo
import androidx.compose.material3.rememberDatePickerState
import androidx.compose.material3.rememberDrawerState
import androidx.compose.material3.rememberTimePickerState
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.runtime.setValue
import androidx.compose.runtime.structuralEqualityPolicy
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.shadow
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.compose.ui.window.Popup
import androidx.navigation.NavController
import androidx.navigation.Navigation
import androidx.window.core.layout.WindowHeightSizeClass
import androidx.window.core.layout.WindowWidthSizeClass
import com.example.project1.R
import com.example.project1.data.model.MenuModel
import com.example.project1.data.model.PostModel
import com.example.project1.ui.components.PostCard
import com.example.project1.ui.components.PostCardCompact
import kotlinx.coroutines.launch
import java.text.SimpleDateFormat
import java.util.Calendar
import java.util.Date
import java.util.Locale

@Composable
fun ComponentsScreen(navController: NavController) {
    var component by rememberSaveable { mutableStateOf("") } //Actualizar el valor de la variable
    val drawerState = rememberDrawerState(initialValue = DrawerValue.Closed)
    val scope = rememberCoroutineScope()
    ModalNavigationDrawer(  //current state of drawer
        drawerState = drawerState,
        //drawer content
        drawerContent = {

            ModalDrawerSheet {
                Text("Menu", modifier = Modifier.padding(16.dp))
                HorizontalDivider()

                val menuOptions = arrayOf(
                    MenuModel(1,"Buttons","Buttons", Icons.Filled.AccountBox),
                    MenuModel(2,"FloatingButtons","FloatingButtons", Icons.Filled.DateRange),
                    MenuModel(3,"Chips","Chips", Icons.Filled.Add),
                    MenuModel(4,"Progress","Progress", Icons.Filled.Menu),
                    MenuModel(5,"Sliders","Sliders", Icons.Filled.ShoppingCart),
                    MenuModel(6,"Switches","Switches", Icons.Filled.Home),
                    MenuModel(7,"Badges","Badges", Icons.Filled.AccountBox),
                    MenuModel(8,"TimePickers","TimePickers", Icons.Filled.DateRange),
                    MenuModel(9,"DatePickers","DatePickers", Icons.Filled.AccountBox),
                    MenuModel(10,"SnackBar","SnackBar", Icons.Filled.DateRange),
                    MenuModel(11,"AlertDialogs","AlertDialogs", Icons.Filled.AccountBox),
                    MenuModel(12,"Bars","Bars", Icons.Filled.AccountBox),
                    MenuModel(13,"Adaptive","Adaptive", Icons.Filled.Star),

                    )
                LazyColumn {
                    items(menuOptions) {item ->
                        NavigationDrawerItem(
                            icon = {Icon(item.icon, contentDescription = "")},
                            label = {Text(text=item.title)},
                            selected = false,
                            onClick = {
                                component = item.option
                                scope.launch {
                                    drawerState.apply {
                                        close()
                                    }
                                }
                            }
                        )

                    }
                }

                /*

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

                //Progress
                NavigationDrawerItem(
                    label = { Text(text = "Progress") },
                    selected = false,
                    onClick = {
                        component = "Progress"
                        scope.launch {
                            drawerState.apply {
                                close()
                            }
                        }
                    }
                )

                //Sliders
                NavigationDrawerItem(
                    label = { Text(text = "Sliders") },
                    selected = false,
                    onClick = {
                        component = "Sliders"
                        scope.launch {
                            drawerState.apply {
                                close()
                            }
                        }
                    }
                )

                //Switches
                NavigationDrawerItem(
                    label = { Text(text = "Switches") },
                    selected = false,
                    onClick = {
                        component = "Switches"
                        scope.launch {
                            drawerState.apply {
                                close()
                            }
                        }
                    }
                )

                //Badges
                NavigationDrawerItem(
                    label = { Text(text = "Badges") },
                    selected = false,
                    onClick = {
                        component = "Badges"
                        scope.launch {
                            drawerState.apply {
                                close()
                            }
                        }
                    }
                )
                //TimePickers
                NavigationDrawerItem(
                    label = { Text(text = "TimePickers") },
                    selected = false,
                    onClick = {
                        component = "TimePickers"
                        scope.launch {
                            drawerState.apply {
                                close()
                            }
                        }
                    }
                )

                //DatePickers
                NavigationDrawerItem(
                    label = { Text(text = "DatePickers") },
                    selected = false,
                    onClick = {
                        component = "DatePickers"
                        scope.launch {
                            drawerState.apply {
                                close()
                            }
                        }
                    }
                )

                //SnackBar
                NavigationDrawerItem(
                    label = { Text(text = "SnackBar") },
                    selected = false,
                    onClick = {
                        component = "SnackBar"
                        scope.launch {
                            drawerState.apply {
                                close()
                            }
                        }
                    }
                )

                //AlertDialogs
                NavigationDrawerItem(
                    label = { Text(text = "AlertDialogs") },
                    selected = false,
                    onClick = {
                        component = "AlertDialogs"
                        scope.launch {
                            drawerState.apply {
                                close()
                            }
                        }
                    }
                )

                //Bars
                NavigationDrawerItem(
                    label = { Text(text = "Bars") },
                    selected = false,
                    onClick = {
                        component = "Bars"
                        scope.launch {
                            drawerState.apply {
                                close()
                            }
                        }
                    }
                )

                 */
            }
        }
    ) {
        //ScreenContent
        Column {
            when (component) {

                "Buttons" -> {
                    Buttons()
                }

                "FloatingButtons" -> {
                    FloatingButtons()
                }

                "Chips" -> {
                    Chips()
                }

                "Progress" -> {
                    Progress()
                }

                "Sliders" -> {
                    Sliders()
                }

                "Switches" -> {
                    Switches()
                }

                "Badges" -> {
                    Badges()
                }

                "TimePickers" -> {
                    TimePickers()
                }

                "DatePickers" -> {
                    DatePickers()
                }

                "SnackBar" -> {
                    SnackBar()
                }

                "AlertDialogs" -> {
                    AlertDialogs()
                }

                "Bars" -> {
                    Bars()
                }

                "Adaptive" -> {
                    Adaptive()
                }
            }
        }
    }
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
            } else {
                null
            }
        )
    }

    InputChipExample(
        text = "Dismiss",
        {}
    )

}

@Composable
fun InputChipExample(
    text: String,
    onDismiss: () -> Unit
) {
    var enabled by remember { mutableStateOf(true) }

    if (!enabled) return

    InputChip(
        label = { Text(text) },
        selected = enabled,
        onClick = {
            onDismiss()
            enabled = !enabled
        },

        avatar = {
            Icon(
                Icons.Filled.Person,
                contentDescription = "",
                Modifier.size(InputChipDefaults.AvatarSize)

            )
        },

        trailingIcon = {
            Icon(
                Icons.Filled.Close,
                contentDescription = "",
                Modifier.size(InputChipDefaults.AvatarSize)

            )
        }
    )
}

@Preview(showBackground = true)
@Composable
fun Progress() {
    Column(
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.SpaceEvenly,
        modifier = Modifier
            .fillMaxSize()
    ) {

        LinearProgressIndicator(
            modifier = Modifier
                .fillMaxWidth()
        )

        CircularProgressIndicator(
            modifier = Modifier
                .width(64.dp)
        )

    }
}

@Preview(showBackground = true)
@Composable
fun Sliders() {
    Column(
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.SpaceEvenly,
        modifier = Modifier
            .fillMaxSize()
    ) {

        var sliderPosition by remember { mutableStateOf(50f) }

        Column() {
            Slider(
                value = sliderPosition,
                onValueChange = { sliderPosition = it },
                steps = 10,
                valueRange = 0f..100f
            )

            Text(
                textAlign = TextAlign.Center,
                modifier = Modifier
                    .fillMaxWidth(),
                text = sliderPosition.toString()
            )

        }

    }
}

@Composable
fun Switches() {
    Column(
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.SpaceEvenly,
        modifier = Modifier
            .fillMaxSize()
    ) {

        var checked by remember { mutableStateOf(true) }

        Switch(
            checked = checked,
            onCheckedChange = {
                checked = it
            }
        )

        var checked2 by remember { mutableStateOf(true) }

        Switch(
            checked = checked2,
            onCheckedChange = {
                checked2 = it
            },
            thumbContent = if (checked2) {
                {
                    Icon(
                        Icons.Filled.Check,
                        contentDescription = "",
                        Modifier.size(InputChipDefaults.AvatarSize)

                    )
                }
            } else {
                null
            }
        )

        var checked3 by remember { mutableStateOf(true) }
        Checkbox(
            checked = checked3,
            onCheckedChange = { checked3 = it }
        )

    }
}

@Preview(showBackground = true)
@Composable
fun Badges() {
    Column(
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.SpaceEvenly,
        modifier = Modifier
            .fillMaxSize()
    ) {
        var itemCount by remember { mutableStateOf(0) }

        BadgedBox(
            badge = {
                if (itemCount > 0) {
                    Badge(
                        containerColor = Color.Red,
                        contentColor = Color.White
                    ) {
                        Text("$itemCount")
                    }
                }
            }
        ) {
            Icon(
                imageVector = Icons.Filled.ShoppingCart,
                contentDescription = ""
            )
        }

        Button(
            onClick = { itemCount++ }
        ) {
            Text("Add item")
        }
    }
}

@Preview(showBackground = true)
@Composable
fun TimePickers() {
    Column(
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.SpaceEvenly,
        modifier = Modifier
            .fillMaxSize()
    ) {

        DialExample()
        InputExample()
    }
}

@Preview(showBackground = true)
@Composable
fun DatePickers() {
    Column(
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.SpaceEvenly,
        modifier = Modifier
            .fillMaxSize()
    ) {

        DatePickerDocked()
    }
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun DialExample() {
    val currentTime = Calendar.getInstance()

    val timePickerState = rememberTimePickerState(
        initialHour = currentTime.get(Calendar.HOUR_OF_DAY),
        initialMinute = currentTime.get(Calendar.MINUTE),
        is24Hour = true,
    )

    Column {
        TimePicker(
            state = timePickerState,
        )

    }
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun InputExample() {

    val currentTime = Calendar.getInstance()

    val timePickerState = rememberTimePickerState(
        initialHour = currentTime.get(Calendar.HOUR_OF_DAY),
        initialMinute = currentTime.get(Calendar.MINUTE),
        is24Hour = true,
    )

    Column {
        TimeInput(
            state = timePickerState,
        )

    }
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun DatePickerDocked() {
    var showDatePicker by remember { mutableStateOf(false) }
    val datePickerState = rememberDatePickerState()
    val selectedDate = datePickerState.selectedDateMillis?.let {
        convertMillisToDate(it)
    } ?: ""

    Box(
        modifier = Modifier.fillMaxWidth()
    ) {
        OutlinedTextField(
            value = selectedDate,
            onValueChange = { },
            label = { Text("DOB") },
            readOnly = true,
            trailingIcon = {
                IconButton(onClick = { showDatePicker = !showDatePicker }) {
                    Icon(
                        imageVector = Icons.Default.DateRange,
                        contentDescription = "Select date"
                    )
                }
            },
            modifier = Modifier
                .fillMaxWidth()
                .height(64.dp)
        )

        if (showDatePicker) {
            Popup(
                onDismissRequest = { showDatePicker = false },
                alignment = Alignment.TopStart
            ) {
                Box(
                    modifier = Modifier
                        .fillMaxWidth()
                        .offset(y = 64.dp)
                        .shadow(elevation = 4.dp)
                        .background(MaterialTheme.colorScheme.surface)
                        .padding(16.dp)
                ) {
                    DatePicker(
                        state = datePickerState,
                        showModeToggle = false
                    )
                }
            }
        }
    }
}

fun convertMillisToDate(millis: Long): String {
    val formatter = SimpleDateFormat("MM/dd/yyyy", Locale.getDefault())
    return formatter.format(Date(millis))
}

@Preview(showBackground = true)
@Composable
fun SnackBar() {
    Column(
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.SpaceEvenly,
        modifier = Modifier
            .fillMaxSize()
    ) {

        val snackState = remember { SnackbarHostState() }
        val snackScope = rememberCoroutineScope()

        SnackbarHost(hostState = snackState, Modifier)

        fun launchSnackBar() {
            snackScope.launch { snackState.showSnackbar("The message was sent") }
        }

        Button(::launchSnackBar) {
            Text("Show Snackbar")
        }

    }
}

@Preview(showBackground = true)
@Composable
fun AlertDialogs() {
    Column(
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.SpaceEvenly,
        modifier = Modifier
            .fillMaxSize()
    ) {

        var showAlertDialog by remember { mutableStateOf(false) }
        var selectedOption by remember { mutableStateOf("") }

        if (showAlertDialog) {
            AlertDialog(
                icon = { Icon(Icons.Filled.Warning, contentDescription = "") },
                title = { Text("Confirm deletion") },
                text = { Text("Are you sure you want to delete the file?") },
                onDismissRequest = {},
                confirmButton = {
                    TextButton(
                        onClick = {
                            selectedOption = "Confirm"
                            showAlertDialog = false
                        }
                    ) { Text("Confirm") }
                },
                dismissButton = {
                    TextButton(
                        onClick = {
                            selectedOption = "Dismiss"
                            showAlertDialog = false
                        }
                    ) { Text("Dismiss") }
                }
            )
        }
        Text(selectedOption)
        Button(onClick = {showAlertDialog = true}) {
            Text("Show alert dialog")
        }
    }
}

@Preview(showBackground = true)
@Composable
fun Bars(){
    Box(
        modifier = Modifier
            .fillMaxSize()
            .background(Color.DarkGray)
    ){
        Row(
            modifier = Modifier
                .align(Alignment.TopCenter)
                .fillMaxWidth()
                .background(Color.Black)
                .padding(10.dp,50.dp,10.dp,10.dp),
            horizontalArrangement = Arrangement.SpaceBetween

        ){
            Icon(Icons.Filled.Menu, contentDescription = "", tint = Color.White)
            Text(
                "App Title",
                color = Color.White,
                fontWeight = FontWeight.Bold
            )
            Icon(Icons.Filled.Settings, contentDescription = "", tint = Color.White)

        }

        val post = arrayOf(
            PostModel(1,"Title 1", "Text 1", painterResource(R.drawable.android_logo)),
            PostModel(2,"Title 2", "Text 2", painterResource (R.drawable.android_logo)),
            PostModel(3,"Title 3", "Text 3", painterResource (R.drawable.android_logo)),
            PostModel(4,"Title 4", "Text 4", painterResource(R.drawable.android_logo)),
            PostModel(5,"Title 5", "Text 5", painterResource (R.drawable.android_logo)),
            PostModel(6,"Title 6", "Text 6", painterResource (R.drawable.android_logo)),
            PostModel(7,"Title 7", "Text 7", painterResource(R.drawable.android_logo)),
            PostModel(8,"Title 8", "Text 8", painterResource (R.drawable.android_logo)),
            PostModel(9,"Title 9", "Text 9", painterResource (R.drawable.android_logo)),
            PostModel(10,"Title 10", "Text 10", painterResource(R.drawable.android_logo))

        )

        Column (
            modifier = Modifier
                .align(Alignment.TopCenter)
                .padding(10.dp,90.dp,10.dp,50.dp)
                .fillMaxSize()
                //.verticalScroll(rememberScrollState())
        ) {

            //Posts(post)
            //PostCard(1,"This a card title", "This is the card text", painterResource(R.drawable.android_logo))
            //PostGrid(post)
        }

        Row(
            modifier = Modifier
                .align(Alignment.BottomCenter)
                .fillMaxWidth()
                .height(65.dp)
                .background(Color.Black)
                .padding(2.dp,5.dp),
            horizontalArrangement = Arrangement.SpaceEvenly
        ) {

            Column {
                IconButton(onClick = {}, Modifier.size(30.dp)) {
                    Icon(
                        Icons.Outlined.Menu,
                        contentDescription = "",
                        tint=Color.White,
                        modifier = Modifier.fillMaxSize()
                    )
                }
                Text(text="Menu", color= Color.White)
            }

            Column {
                IconButton(onClick = {}, Modifier.size(30.dp)) {
                    Icon(
                        Icons.Outlined.Person,
                        contentDescription = "",
                        tint=Color.White,
                        modifier = Modifier.fillMaxSize()
                    )
                }
                Text(text="Acount", color= Color.White)
            }

            Column{
                IconButton(onClick = {}, Modifier.size(30.dp)) {
                    Icon(
                        Icons.Outlined.Home,
                        contentDescription = "",
                        tint=Color.White,
                        modifier = Modifier.fillMaxSize()
                    )
                }
                Text(text="Home", color= Color.White)

            }

            Column {
                IconButton(onClick = {}, Modifier.size(30.dp)) {
                    Icon(
                        Icons.Outlined.Search,
                        contentDescription = "",
                        tint=Color.White,
                        modifier = Modifier.fillMaxSize()
                    )
                }
                Text(text="Search", color= Color.White)
            }

            Column {
                IconButton(onClick = {}, Modifier.size(30.dp)) {
                    Icon(
                        Icons.Outlined.Settings,
                        contentDescription = "",
                        tint=Color.White,
                        modifier = Modifier.fillMaxSize()
                    )
                }
                Text(text="Settings", color= Color.White)
            }
        }
    }
}

@Composable
fun Posts(arrayPosts: Array<PostModel>, adaptive: String) {

    LazyColumn(
        modifier = Modifier.fillMaxSize()
    ) {
        items(arrayPosts) { post ->
            when (adaptive) {
                "PhoneP" -> {
                    PostCardCompact(post.id, post.title, post.text, post.image)
                }

                "PhoneL" -> {
                    PostCard(post.id, post.title, post.text, post.image)
                }


                /*items(arrayPosts) { post ->
                Text(
                    text = post.text,
                    color = Color.White,
                    fontSize = 16.sp
                )

                Spacer(modifier = Modifier.height(16.dp))
                HorizontalDivider(thickness = 2.dp)

            }*/
            }
        }
    }

    @Composable
    fun PostGrid(arrayPosts: Array<PostModel>) {
        LazyVerticalGrid(
            columns = GridCells.Adaptive(minSize = 128.dp), modifier = Modifier.fillMaxSize()
        ) {
            items(arrayPosts) { post ->
                PostCard(post.id, post.title, post.text, post.image)

            }
        }
    }
}

@Preview(showBackground = true, device = "spec:id=reference_tablet,shape=Normal,width=1280,height=800,unit=dp,dpi=240")
@Composable
fun Adaptive() {

    var WindowsSize = currentWindowAdaptiveInfo().windowSizeClass
    var height = currentWindowAdaptiveInfo().windowSizeClass.windowHeightSizeClass
    var width = currentWindowAdaptiveInfo().windowSizeClass.windowWidthSizeClass

    //Compact width < 600dp Phone portrait
    //Medium width >= 600dp < 840dp Tablets portrait
    //Expanded width >840dp Tablets landscape
    //Compact height < 480dp Phone landscape
    //Medium height <= 480dp < 900dp Tablet landscape or phone portrait

    val post = arrayOf(
        PostModel(1, "Title 1", "Text 1", painterResource(R.drawable.android_logo)),
        PostModel(2, "Title 2", "Text 2", painterResource(R.drawable.android_logo)),
        PostModel(3, "Title 3", "Text 3", painterResource(R.drawable.android_logo)),
        PostModel(4, "Title 4", "Text 4", painterResource(R.drawable.android_logo)),
        PostModel(5, "Title 5", "Text 5", painterResource(R.drawable.android_logo)),
        PostModel(6, "Title 6", "Text 6", painterResource(R.drawable.android_logo)),
        PostModel(7, "Title 7", "Text 7", painterResource(R.drawable.android_logo)),
        PostModel(8, "Title 8", "Text 8", painterResource(R.drawable.android_logo)),
        PostModel(9, "Title 9", "Text 9", painterResource(R.drawable.android_logo)),
        PostModel(10, "Title 10", "Text 10", painterResource(R.drawable.android_logo))

        )
    if (width == WindowWidthSizeClass.COMPACT) {
        Posts(post, "PhoneP")
    } else if (height == WindowHeightSizeClass.COMPACT) {
        Posts(post, "PhoneL")
    } else {
        Posts(post, "PhoneL")

    }
}




