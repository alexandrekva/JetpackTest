package com.example.myapplication.utils

import java.lang.Exception

object Validations {

    @JvmStatic
    fun isGradeOutOfLimits(n: Double): Boolean{
        if (n > 10 || n < 0 )
            return true
        return false
    }

    @JvmStatic
    fun isDouble(n: String): Boolean {
        return try {
            n.toDouble()
            true
        } catch (e: Exception) {
            false
        }
    }

}