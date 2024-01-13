package com.example.unitconverterapp

import android.os.Bundle
import android.widget.Toast
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowDropDown
import androidx.compose.material3.Button
import androidx.compose.material3.DropdownMenu
import androidx.compose.material3.DropdownMenuItem
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.runtime.Composable
import androidx.compose.runtime.currentCompositionLocalContext
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.unitconverterapp.ui.theme.UnitConverterAppTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            UnitConverterAppTheme {
                // A surface container using the 'background' color from the theme
                Surface(modifier = Modifier.fillMaxSize(), color = MaterialTheme.colorScheme.background) {
                    UnitConverter()
                }
            }
        }
    }
}

@Composable
fun UnitConverter() {
    Column(
        // used to fill max size of the screen
        modifier = Modifier.fillMaxSize(),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        // Here all the UI elements will be stacked below each other
        Text(text = "Unit Converter" /* modifier = Modifier.padding(20.dp) */)

//        Padding : Apply all dp of additional space along each edge of the content,
//        left, top, right and bottom.
//        Spacer : Component that represents an empty space layout, whose size can be defined using
//        Modifier.width, Modifier.height and Modifier.size modifiers.

        Spacer(modifier = Modifier.height(18.dp))
        OutlinedTextField(value = "", onValueChange = {
            // here goes what should happen, when the values of our OutlinedTextField changes
        })
        Spacer(modifier = Modifier.height(18.dp))

        Row {
            // Here all the UI elements will be stacked side each other
//            Greeting(name = "Shrunal")
//            Greeting(name = "Shrunal")
//            val context = LocalContext.current
//            Button(onClick = {
//                Toast.makeText(context,
//                    "You Clicked me!",
//                    Toast.LENGTH_LONG).show() })
//            {
//                Text(text = "Select")
//            }

            Box {
                Button(onClick = { /*TODO*/ }) {
                    Text(text = "Select")
                    Icon(Icons.Default.ArrowDropDown, contentDescription = " Arrow Down" )
                }

                DropdownMenu(expanded = false,
                    onDismissRequest = { /*TODO*/ })
                {
                    DropdownMenuItem(text = {
                        Text(text = "CentiMeters")},
                        onClick = { /*TODO*/ })

                    DropdownMenuItem(text = {
                        Text(text = "MilliMeters")},
                        onClick = { /*TODO*/ })

                    DropdownMenuItem(text = {
                        Text(text = "Meters")},
                        onClick = { /*TODO*/ })

                    DropdownMenuItem(text = {
                        Text(text = "KiloMeters")},
                        onClick = { /*TODO*/ })
                }
            }

            Spacer(modifier = Modifier.width(16.dp))

            Box {
                Button(onClick = { /*TODO*/ }) {
                    Text(text = "Select")
                    Icon(Icons.Default.ArrowDropDown, contentDescription = " Arrow Down" )
                }

                DropdownMenu(expanded = false,
                    onDismissRequest = { /*TODO*/ })
                {
                    DropdownMenuItem(text = {
                        Text(text = "CentiMeters")},
                        onClick = { /*TODO*/ })

                    DropdownMenuItem(text = {
                        Text(text = "MilliMeters")},
                        onClick = { /*TODO*/ })

                    DropdownMenuItem(text = {
                        Text(text = "Meters")},
                        onClick = { /*TODO*/ })

                    DropdownMenuItem(text = {
                        Text(text = "KiloMeters")},
                        onClick = { /*TODO*/ })
                }
            }
            
        }

        Spacer(modifier = Modifier.padding(18.dp))
        Text(text = "Exit!")
    }
}

@Preview(showBackground = true)
@Composable
fun UnitConverterPreview(){
    UnitConverter()
}

//@Composable
//fun Greeting(name: String, modifier: Modifier = Modifier) {
//    Text(
//        text = "Hello $name!",
//        modifier = modifier
//    )
//}

//@Preview(showBackground = true)
//@Composable
//fun GreetingPreview() {
//    UnitConverterAppTheme {
//        Greeting("Android")
//    }
//}