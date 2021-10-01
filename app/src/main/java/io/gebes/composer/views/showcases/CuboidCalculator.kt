package io.gebes.composer.views.showcases

import androidx.compose.foundation.layout.*
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.ImeAction
import androidx.compose.ui.text.input.KeyboardCapitalization
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.unit.dp
import androidx.navigation.NavHostController

@Composable
fun CuboidCalculatorShowcase(navController: NavHostController) {
    var a by remember { mutableStateOf("1") }
    var b by remember { mutableStateOf("2") }
    var c by remember { mutableStateOf("3") }

    val keyboardOptions = KeyboardOptions(
        capitalization = KeyboardCapitalization.None,
        autoCorrect = true,
        keyboardType = KeyboardType.Number,
        imeAction = ImeAction.Next
    )

    var result by remember { mutableStateOf("") }
    val calculateResult = {
        val sideA = a.toIntOrNull() ?: 0
        val sideB = b.toIntOrNull() ?: 0
        val sideC = c.toIntOrNull() ?: 0

        val volume = sideA * sideB * sideC
        val surface = 2 * ((sideA * sideB) + (sideA * sideC) + (sideB * sideC))

        result = "The volume of the cube is $volume and the surface is $surface"

    }
    calculateResult()


    Scaffold(

        topBar = {
            TopAppBar(
                title = { Text("CuboidCalculator") },
                navigationIcon = {
                    IconButton(onClick = {
                        navController.popBackStack()
                    }) {
                        Icon(
                            imageVector = Icons.Filled.ArrowBack,
                            contentDescription = "Back",
                        )
                    }
                }
            )
        },

        ) {
        Column(
            modifier = Modifier
                .padding(10.dp)
                .fillMaxSize(),
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.Top
        ) {

            OutlinedTextField(
                keyboardOptions = keyboardOptions,
                value = a,
                onValueChange = { a = it
                    calculateResult()},
                label = { Text("Side A") },
                modifier = Modifier
                    .padding(start = 16.dp, end = 16.dp, top = 20.dp)
                    .fillMaxWidth(),
            )

            OutlinedTextField(
                keyboardOptions = keyboardOptions,
                value = b,
                onValueChange = { b = it
                    calculateResult()},
                label = { Text("Side B") },
                modifier = Modifier
                    .padding(start = 16.dp, end = 16.dp, top = 20.dp)
                    .fillMaxWidth(),
            )

            OutlinedTextField(
                keyboardOptions = keyboardOptions,
                value = c,
                onValueChange = { c = it },
                label = { Text("Side C")
                    calculateResult()},
                modifier = Modifier
                    .padding(start = 16.dp, end = 16.dp, top = 20.dp)
                    .fillMaxWidth(),
            )


            Text(
                text = "Result", fontWeight = FontWeight.Bold,
                modifier = Modifier.padding(top = 20.dp)
            )
            Text(result)


        }
    }
}

