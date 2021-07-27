package com.example.myapplication

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material.*
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.getValue
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.myapplication.utils.AverageCalc
import com.example.myapplication.utils.Validations
import java.lang.Exception

@Composable
fun HomeScreen() {
    Box(
        modifier = Modifier
            .background(Color.White)
            .fillMaxSize()
    ) {
        Column(
            modifier = Modifier.padding(horizontal = 24.dp, vertical = 16.dp)
        ) {
            var grade1 by remember { mutableStateOf("") }
            var grade2 by remember { mutableStateOf("") }
            var result by remember { mutableStateOf("") }
            var isGrade1Double by remember { mutableStateOf(true) }
            var isGrade2Double by remember { mutableStateOf(true) }

            OutlinedTextField(
                value = grade1,
                onValueChange = { grade1 = it },
                label = { Text(text = "Insira a primeira nota") },
                modifier = Modifier.fillMaxWidth(),
                keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Number),
                isError = !isGrade1Double
            )

            OutlinedTextField(
                value = grade2,
                onValueChange = { grade2 = it },
                label = { Text(text = "Insira a segunda nota") },
                modifier = Modifier.fillMaxWidth(),
                keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Number),
                isError = !isGrade2Double,

                )

            Text(text = result, modifier = Modifier.padding(top = 16.dp), fontSize = 18.sp)

            Button(
                onClick = {
                    isGrade1Double = Validations.isDouble(grade1)
                    isGrade2Double = Validations.isDouble(grade2)
                    if (isGrade1Double && isGrade2Double)
                        result =
                            try {
                                AverageCalc.calculateAverage(grade1.toDouble(), grade2.toDouble())
                            } catch (e: Exception) {
                                e.message ?: "Error"
                            }
                },
                modifier = Modifier.padding(top = 16.dp)
            ) {
                Text(text = "Calcular média")
            }
        }
    }
}
