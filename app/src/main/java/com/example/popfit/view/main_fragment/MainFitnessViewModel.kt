package com.example.popfit.view.main_fragment

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.popfit.domain.Exercise
import com.example.popfit.domain.GetAllExerciseUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class MainFitnessViewModel @Inject constructor(private val useCase: GetAllExerciseUseCase) :
    ViewModel() {

    fun getAllExercise(): LiveData<List<Exercise>> = useCase.getAllExercise()
}