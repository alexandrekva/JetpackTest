package com.example.myapplication.utils

object AverageCalc {

    @JvmStatic
    fun calculateAverage(n1: Double, n2: Double): String {
        if (Validations.isGradeOutOfLimits(n1) || Validations.isGradeOutOfLimits(n2)) {
            throw Exception("Nota fora do intervalo!")
        }

        val average = ((n1 + n2) / 2)
        val formattedAverage = String.format("%.1f", average)

        return when {
            average < 5.0 -> {
                "$formattedAverage e Reprovado!"
            }
            average < 6.0 -> {
                "$formattedAverage e Prova final!"
            }
            else -> {
                "$formattedAverage e Aprovado!"
            }
        }
    }


}