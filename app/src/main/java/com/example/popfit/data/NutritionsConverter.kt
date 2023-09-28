package com.example.popfit.data

import androidx.room.TypeConverter

class NutritionsConverter {

    @TypeConverter
    fun fromNutritions(nutritions: Nutritions): String {
        return "${nutritions.calories},${nutritions.fat},${nutritions.carbohydrates},${nutritions.protein},${nutritions.sugar}"
    }

    @TypeConverter
    fun toNutritions(line: String): Nutritions {
        val vals = line.split(",")
        return Nutritions(
            calories = vals[0].toDouble(),
            fat = vals[1].toDouble(),
            carbohydrates = vals[2].toDouble(),
            protein = vals[3].toDouble(),
            sugar = vals[4].toDouble()
        )
    }

}