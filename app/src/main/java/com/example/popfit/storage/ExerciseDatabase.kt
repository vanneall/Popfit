package com.example.popfit.storage

import androidx.room.Database
import androidx.room.RoomDatabase
import androidx.room.TypeConverters
import com.example.popfit.data.Exercise
import com.example.popfit.data.Fruit
import com.example.popfit.data.NutritionsConverter

@Database(entities = [Exercise::class, Fruit::class], version = 2)
@TypeConverters(NutritionsConverter::class)
abstract class ExerciseDatabase : RoomDatabase() {
    abstract fun createExerciseDao(): ExerciseDao
    abstract fun createFruitDao(): FruitDao

}