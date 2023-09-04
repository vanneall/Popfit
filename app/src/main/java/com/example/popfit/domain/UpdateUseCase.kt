package com.example.popfit.domain

import com.example.popfit.data.Exercise
import com.example.popfit.data.ExerciseRepository
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import javax.inject.Inject

class UpdateUseCase @Inject constructor(private val repository: ExerciseRepository) {

    fun update(exercise: Exercise) {
        CoroutineScope(Dispatchers.IO).launch {repository.update(exercise)}
    }

}