package com.example.myapplication

import com.example.myapplication.utils.AverageCalc
import com.example.myapplication.utils.Validations
import io.mockk.every
import io.mockk.mockkStatic
import io.mockk.unmockkObject
import io.mockk.verify
import junit.framework.Assert.assertEquals
import org.junit.After
import org.junit.Assert.assertThrows
import org.junit.Before
import org.junit.Test


class AverageCalcTest {

    @Before
    fun setUp() {
        mockkStatic(Validations::class)
    }

    @After
    fun after() {
        unmockkObject(Validations::class)
    }

    @Test
    fun `average calc out of limits high`() {
        val grade1 = 10.1
        val grade2 = 10.1

        every { Validations.isGradeOutOfLimits(grade1) } returns true
        every { Validations.isGradeOutOfLimits(grade2) } returns true

        val exception = assertThrows(Exception::class.java) {
            AverageCalc.calculateAverage(grade1, grade2)
        }

        val actual = exception.message
        val expected = "Nota fora do intervalo!"

        verify() { Validations.isGradeOutOfLimits(any()) }
        assertEquals(expected, actual)
    }

    @Test
    fun `average calc out of limits low`() {
        val grade1 = -0.1
        val grade2 = -0.1

        every { Validations.isGradeOutOfLimits(grade1) } returns true
        every { Validations.isGradeOutOfLimits(grade2) } returns true

        val exception = assertThrows(Exception::class.java) {
            AverageCalc.calculateAverage(grade1, grade2)
        }

        val actual = exception.message
        val expected = "Nota fora do intervalo!"

        verify() { Validations.isGradeOutOfLimits(any()) }
        assertEquals(expected, actual)
    }

    @Test
    fun `average calc reproved 0,0`() {
        val grade1 = 0.0
        val grade2 = 0.0
        every { Validations.isGradeOutOfLimits(grade1) } returns false
        every { Validations.isGradeOutOfLimits(grade2) } returns false

        val actual = AverageCalc.calculateAverage(grade1, grade2)
        val expected = "0,0 e Reprovado!"

        verify(exactly = 2) { Validations.isGradeOutOfLimits(any()) }
        assertEquals(expected, actual)
    }

    @Test
    fun `average calc reproved 4,9`() {
        val grade1 = 0.0
        val grade2 = 9.8

        every { Validations.isGradeOutOfLimits(grade1) } returns false
        every { Validations.isGradeOutOfLimits(grade2) } returns false

        val actual = AverageCalc.calculateAverage(grade1, grade2)
        val expected = "4,9 e Reprovado!"

        verify(exactly = 2) { Validations.isGradeOutOfLimits(any()) }
        assertEquals(expected, actual)
    }

    @Test
    fun `average calc final exam 5,0`() {
        val grade1 = 3.0
        val grade2 = 7.0

        every { Validations.isGradeOutOfLimits(grade1) } returns false
        every { Validations.isGradeOutOfLimits(grade2) } returns false

        val actual = AverageCalc.calculateAverage(grade1, grade2)
        val expected = "5,0 e Prova final!"

        verify(exactly = 2) { Validations.isGradeOutOfLimits(any()) }
        assertEquals(expected, actual)
    }

    @Test
    fun `average calc final exam 5,9`() {
        val grade1 = 6.9
        val grade2 = 4.9

        every { Validations.isGradeOutOfLimits(grade1) } returns false
        every { Validations.isGradeOutOfLimits(grade2) } returns false

        val actual = AverageCalc.calculateAverage(grade1, grade2)
        val expected = "5,9 e Prova final!"

        verify(exactly = 2) { Validations.isGradeOutOfLimits(any()) }
        assertEquals(expected, actual)
    }

    @Test
    fun `average calc approved 6,0`() {
        val grade1 = 10.0
        val grade2 = 2.0

        every { Validations.isGradeOutOfLimits(grade1) } returns false
        every { Validations.isGradeOutOfLimits(grade2) } returns false

        val actual = AverageCalc.calculateAverage(grade1, grade2)
        val expected = "6,0 e Aprovado!"

        verify(exactly = 2) { Validations.isGradeOutOfLimits(any()) }
        assertEquals(expected, actual)
    }

    @Test
    fun `average calc approved 10,0`() {
        val grade1 = 10.0
        val grade2 = 10.0

        every { Validations.isGradeOutOfLimits(grade1) } returns false
        every { Validations.isGradeOutOfLimits(grade2) } returns false

        val actual = AverageCalc.calculateAverage(grade1, grade2)
        val expected = "10,0 e Aprovado!"

        verify(exactly = 2) { Validations.isGradeOutOfLimits(any()) }
        assertEquals(expected, actual)
    }

}