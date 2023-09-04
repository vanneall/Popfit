package com.example.popfit.view.info_fragment

import androidx.lifecycle.ViewModel
import com.example.popfit.domain.DeleteUseCase
import com.example.popfit.domain.Exercise
import com.example.popfit.domain.UpdateUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class InfoViewModel @Inject constructor(
    private val updateUseCase: UpdateUseCase,
    private val deleteUseCase: DeleteUseCase
) : ViewModel() {

    private lateinit var initExercise: Exercise

    fun setInitialExercise(exercise: Exercise) {
        initExercise = exercise
    }

    private fun isTheSameObject(newExercise: Exercise) = initExercise == newExercise

    fun update(newExercise: Exercise) {
        if (!isTheSameObject(newExercise)) {
            updateUseCase.update(exercise = newExercise)
        }
    }

    fun delete(exercise: Exercise) {
        deleteUseCase.delete(exercise)
    }

}