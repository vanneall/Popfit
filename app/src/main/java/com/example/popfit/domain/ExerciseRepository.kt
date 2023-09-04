package com.example.popfit.domain

import androidx.lifecycle.LiveData

interface ExerciseRepository {

    fun getAllExercise(): LiveData<List<Exercise>>
    suspend fun insert(exercise: Exercise)
    suspend fun update(exercise: Exercise)
    suspend fun delete(exercise: Exercise)

}