package com.example.unitconverterapp

import android.os.Bundle
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
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.unitconverterapp.ui.theme.UnitConverterAppTheme
import kotlin.math.roundToInt

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

    var inputValue by remember { mutableStateOf("") }
    var outputValue by remember { mutableStateOf("") }
    var inputUnit by remember { mutableStateOf("Meters") }
    var outputUnit by remember { mutableStateOf("Meters") }
    var iExpanded by remember { mutableStateOf(false) }
    var oExpanded by remember { mutableStateOf(false) }
    val inputUnitConverter = remember { mutableStateOf(1.0) }
    val outputUnitConverter = remember { mutableStateOf(1.0) }

    fun unitCalculator(){
        val inputUnitDouble = inputValue.toDoubleOrNull() ?: 0.0
        val result = (inputUnitDouble * inputUnitConverter.value * 100.0 / outputUnitConverter.value ).roundToInt() / 100.0
        outputValue = result.toString()
    }

    val myStyle = TextStyle(
        color = Color.Magenta,
        fontSize = 32.sp,
        fontFamily = FontFamily.Serif
    )

    Column(
        // used to fill max size of the screen
        modifier = Modifier.fillMaxSize(),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        // Here all the UI elements will be stacked below each other
        Text(text = "Unit Converter" ,style = myStyle
        /* modifier = Modifier.padding(20.dp) */)

//        Padding : Apply all dp of additional space along each edge of the content,
//        left, top, right and bottom.
//        Spacer : Component that represents an empty space layout, whose size can be defined using
//        Modifier.width, Modifier.height and Modifier.size modifiers.
        Spacer(modifier = Modifier.height(18.dp))

        OutlinedTextField(value = inputValue,
            onValueChange = {
            // here goes what should happen, when the values of our OutlinedTextField changes
            inputValue = it
                unitCalculator()},
            label = {Text(text = "Enter value")})
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

            // Input box
            Box {
                // Input button
                Button(onClick = {iExpanded = true }) {
                    Text(text = inputUnit)
                    Icon(Icons.Default.ArrowDropDown, contentDescription = " Arrow Down" )
                }

                DropdownMenu(expanded = iExpanded,
                    onDismissRequest = { iExpanded = false })
                {
                    DropdownMenuItem(text = {
                        Text(text = "CentiMeters")},
                        onClick = {
                            iExpanded = false
                            inputUnit = "CentiMeters"
                            inputUnitConverter.value = 0.01
                            unitCalculator()
                        })

                    DropdownMenuItem(text = {
                        Text(text = "MilliMeters")},
                        onClick = {
                            iExpanded = false
                            inputUnit = "MilliMeters"
                            inputUnitConverter.value = 0.001
                            unitCalculator()
                        })

                    DropdownMenuItem(text = {
                        Text(text = "Meters")},
                        onClick = {
                            iExpanded = false
                            inputUnit = "Meters"
                            inputUnitConverter.value = 1.0
                            unitCalculator()
                        })

                    DropdownMenuItem(text = {
                        Text(text = "KiloMeters")},
                        onClick = {
                            iExpanded = false
                            inputUnit = "KiloMeters"
                            inputUnitConverter.value = 1000.0
                            unitCalculator()
                        })

                    DropdownMenuItem(text = {
                        Text(text = "Inch")},
                        onClick = {
                            iExpanded = false
                            inputUnit = "Inch"
                            inputUnitConverter.value = 0.0254
                            unitCalculator()
                        })

                    DropdownMenuItem(text = {
                        Text(text = "Foot")},
                        onClick = {
                            iExpanded = false
                            inputUnit = "Foot"
                            inputUnitConverter.value = 0.3048
                            unitCalculator()
                        })

                    DropdownMenuItem(text = {
                        Text(text = "Nautical Mile")},
                        onClick = {
                            iExpanded = false
                            inputUnit = "Nautical Mile"
                            inputUnitConverter.value = 1852.0
                            unitCalculator()
                        })

                    DropdownMenuItem(text = {
                        Text(text = "Yard")},
                        onClick = {
                            iExpanded = false
                            inputUnit = "Yard"
                            inputUnitConverter.value = 0.9144
                            unitCalculator()
                        })

                    DropdownMenuItem(text = {
                        Text(text = "Mile")},
                        onClick = {
                            iExpanded = false
                            inputUnit = "Mile"
                            inputUnitConverter.value = 1609.34
                            unitCalculator()
                        })
                }
            }

            Spacer(modifier = Modifier.width(16.dp))

            // Output box
            Box {
                // Output button
                Button(onClick = { oExpanded = true }) {
                    Text(text = outputUnit)
                    Icon(Icons.Default.ArrowDropDown, contentDescription = " Arrow Down" )
                }

                DropdownMenu(expanded =oExpanded,
                    onDismissRequest = { oExpanded = false})
                {
                    DropdownMenuItem(text = {
                        Text(text = "CentiMeters")},
                        onClick = {
                            oExpanded = false
                            outputUnit = "CentiMeters"
                            outputUnitConverter.value = 0.01
                            unitCalculator()
                        })

                    DropdownMenuItem(text = {
                        Text(text = "MilliMeters")},
                        onClick = {
                            oExpanded = false
                            outputUnit = "MilliMeters"
                            outputUnitConverter.value = 0.001
                            unitCalculator()
                        })

                    DropdownMenuItem(text = {
                        Text(text = "Meters")},
                        onClick = {
                            oExpanded = false
                            outputUnit = "Meters"
                            outputUnitConverter.value = 1.0
                            unitCalculator()
                        })

                    DropdownMenuItem(text = {
                        Text(text = "KiloMeters")},
                        onClick = {
                            oExpanded = false
                            outputUnit = "KiloMeters"
                            outputUnitConverter.value = 1000.0
                            unitCalculator()
                        })

                    DropdownMenuItem(text = {
                        Text(text = "Inch")},
                        onClick = {
                            oExpanded = false
                            outputUnit = "Inch"
                            outputUnitConverter.value = 0.0254
                            unitCalculator()
                        })

                    DropdownMenuItem(text = {
                        Text(text = "Foot")},
                        onClick = {
                            oExpanded = false
                            outputUnit = "Foot"
                            outputUnitConverter.value = 0.3048
                            unitCalculator()
                        })

                    DropdownMenuItem(text = {
                        Text(text = "Nautical Mile")},
                        onClick = {
                            oExpanded = false
                            outputUnit = "Nautical Mile"
                            outputUnitConverter.value = 1852.0
                            unitCalculator()
                        })

                    DropdownMenuItem(text = {
                        Text(text = "Yard")},
                        onClick = {
                            oExpanded = false
                            outputUnit = "Yard"
                            outputUnitConverter.value = 0.9144
                            unitCalculator()
                        })

                    DropdownMenuItem(text = {
                        Text(text = "Mile")},
                        onClick = {
                            oExpanded = false
                            outputUnit = "Mile"
                            outputUnitConverter.value = 1609.34
                            unitCalculator()
                        })
                }
            }

        }

        Spacer(modifier = Modifier.padding(18.dp))
        Text(text = "Result : $outputValue $outputUnit",
            style = MaterialTheme.typography.headlineSmall,
            color = Color.White)
    }
}

@Preview(showBackground = true)
@Composable
fun UnitConverterPreview(){
    UnitConverter()
}
