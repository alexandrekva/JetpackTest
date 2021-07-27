package com.example.myapplication

import com.example.myapplication.utils.Validations
import org.junit.Assert.*
import org.junit.Test

class ValidationsTest {

    @Test
    fun outOfLimitsGrade2() {
        val outOfLimitGrade = 10.1
        val expected = true
        val actual = Validations.isGradeOutOfLimits(outOfLimitGrade)

        assertEquals(expected, actual)
    }

    @Test
    fun outOfLimitsGrade1() {
        val outOfLimitGrade = -0.1
        val expected = true
        val actual = Validations.isGradeOutOfLimits(outOfLimitGrade)

        assertEquals(expected, actual)
    }

    @Test
    fun insideLimitGrade1() {
        val insideLimitGrade = 0.0
        val expected = false
        val actual = Validations.isGradeOutOfLimits(insideLimitGrade)

        assertEquals(expected, actual)
    }

    @Test
    fun insideLimitGrade2() {
        val insideLimitGrade = 10.0
        val expected = false
        val actual = Validations.isGradeOutOfLimits(insideLimitGrade)

        assertEquals(expected, actual)
    }

    @Test
    fun isDouble() {
        val double = "10.0"
        val expected = true
        val actual = Validations.isDouble(double)

        assertEquals(expected, actual)
    }

    @Test
    fun notDouble() {
        val notDouble = "teste"
        val expected = false
        val actual = Validations.isDouble(notDouble)

        assertEquals(expected, actual)
    }


}