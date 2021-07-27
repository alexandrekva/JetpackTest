package com.example.myapplication

import com.example.myapplication.utils.AverageCalc
import com.example.myapplication.utils.Validations
import io.mockk.every
import io.mockk.verify
import junit.framework.Assert.assertEquals
import org.junit.Assert
import org.junit.Test

class AverageCalcIntegratedTest {

    @Test
    fun `average calc out of limits high`() {
        val grade1 = 10.1
        val grade2 = 10.1


        val exception = Assert.assertThrows(Exception::class.java) {
            AverageCalc.calculateAverage(grade1, grade2)
        }

        val actual = exception.message
        val expected = "Nota fora do intervalo!"

        assertEquals(expected, actual)
    }

    @Test
    fun `average calc out of limits low`() {
        val grade1 = -0.1
        val grade2 = -0.1


        val exception = Assert.assertThrows(Exception::class.java) {
            AverageCalc.calculateAverage(grade1, grade2)
        }

        val actual = exception.message
        val expected = "Nota fora do intervalo!"

        assertEquals(expected, actual)
    }

    @Test
    fun `average calc reproved 0,0`() {
        val grade1 = 0.0
        val grade2 = 0.0

        val actual = AverageCalc.calculateAverage(grade1, grade2)
        val expected = "0,0 e Reprovado!"

        assertEquals(expected, actual)
    }

    @Test
    fun `average calc reproved 4,9`() {
        val grade1 = 5.9
        val grade2 = 3.9

        val actual = AverageCalc.calculateAverage(grade1, grade2)
        val expected = "4,9 e Reprovado!"

        assertEquals(expected, actual)
    }

    @Test
    fun `average calc final exam 5,0`() {
        val grade1 = 0.0
        val grade2 = 10.0

        val actual = AverageCalc.calculateAverage(grade1, grade2)
        val expected = "5,0 e Prova final!"

        assertEquals(expected, actual)
    }

    @Test
    fun `average calc final exam 5,9`() {
        val grade1 = 1.8
        val grade2 = 10.0

        val actual = AverageCalc.calculateAverage(grade1, grade2)
        val expected = "5,9 e Prova final!"

        assertEquals(expected, actual)
    }

    @Test
    fun `average calc approved 6,0`() {
        val grade1 = 5.0
        val grade2 = 7.0

        val actual = AverageCalc.calculateAverage(grade1, grade2)
        val expected = "6,0 e Aprovado!"

        assertEquals(expected, actual)
    }

    @Test
    fun `average calc approved 10,0`() {
        val grade1 = 10.0
        val grade2 = 10.0

        val actual = AverageCalc.calculateAverage(grade1, grade2)
        val expected = "10,0 e Aprovado!"

        assertEquals(expected, actual)
    }

}