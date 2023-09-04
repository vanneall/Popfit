package com.example.popfit.domain

import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import javax.inject.Inject

class InsertUseCase @Inject constructor(private val repository: ExerciseRepository) {

    fun insert(exercise: Exercise){
        CoroutineScope(Dispatchers.IO).launch { repository.insert(exercise) }
    }

}