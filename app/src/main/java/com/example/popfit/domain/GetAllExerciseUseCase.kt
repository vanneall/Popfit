package com.example.popfit.domain

import com.example.popfit.data.ExerciseRepository
import javax.inject.Inject

class GetAllExerciseUseCase @Inject constructor(private val repository: ExerciseRepository) {
    fun getAllExercise() = repository.getAllExercise()
}