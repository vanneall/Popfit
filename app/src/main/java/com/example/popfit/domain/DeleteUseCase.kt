package com.example.popfit.domain

import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import javax.inject.Inject

class DeleteUseCase @Inject constructor(private val repository: ExerciseRepository) {

    fun delete(exercise: Exercise) {
        CoroutineScope(Dispatchers.IO).launch { repository.delete(exercise) }
    }

}