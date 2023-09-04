package com.example.popfit.domain

import javax.inject.Inject

class GetAllExerciseUseCase @Inject constructor(private val repository: ExerciseRepository) {
    fun getAllExercise() = repository.getAllExercise()
}