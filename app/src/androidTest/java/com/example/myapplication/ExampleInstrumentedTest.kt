package com.example.myapplication

import androidx.compose.ui.test.junit4.createAndroidComposeRule
import androidx.compose.ui.test.onNodeWithText
import androidx.compose.ui.test.performClick
import androidx.compose.ui.test.performTextInput
import androidx.test.platform.app.InstrumentationRegistry
import androidx.test.ext.junit.runners.AndroidJUnit4

import org.junit.Test
import org.junit.runner.RunWith

import org.junit.Assert.*
import org.junit.Rule

/**
 * Instrumented test, which will execute on an Android device.
 *
 * See [testing documentation](http://d.android.com/tools/testing).
 */
@RunWith(AndroidJUnit4::class)
class ExampleInstrumentedTest {

    @get:Rule
    val composeTestRule = createAndroidComposeRule<MainActivity>()

    @Test
    fun checkLayout() {
        composeTestRule.onNodeWithText("Insira a primeira nota").assertExists()
        composeTestRule.onNodeWithText("Insira a segunda nota").assertExists()
        composeTestRule.onNodeWithText("Calcular média").assertExists()
    }

    @Test
    fun reproved() {
        composeTestRule.onNodeWithText("Insira a primeira nota").performTextInput("0.0")
        composeTestRule.onNodeWithText("Insira a segunda nota").performTextInput("0.0")
        composeTestRule.onNodeWithText("Calcular média").performClick()
        composeTestRule.onNodeWithText("0.0 e Reprovado!").assertExists()
    }

    @Test
    fun finalExam() {
        composeTestRule.onNodeWithText("Insira a primeira nota").performTextInput("5.0")
        composeTestRule.onNodeWithText("Insira a segunda nota").performTextInput("5.0")
        composeTestRule.onNodeWithText("Calcular média").performClick()
        composeTestRule.onNodeWithText("5.0 e Prova final!").assertExists()
    }

    @Test
    fun approved() {
        composeTestRule.onNodeWithText("Insira a primeira nota").performTextInput("10.0")
        composeTestRule.onNodeWithText("Insira a segunda nota").performTextInput("10.0")
        composeTestRule.onNodeWithText("Calcular média").performClick()
        composeTestRule.onNodeWithText("10.0 e Aprovado!").assertExists()
    }
}