package com.example.popfit.view.add_fragment

import androidx.lifecycle.ViewModel
import com.example.popfit.data.Exercise
import com.example.popfit.domain.InsertUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class AddViewModel @Inject constructor(private val insertUseCase: InsertUseCase) : ViewModel() {

    fun insertUser(title: String, weight: Float) {
        insertUseCase.insert(
            Exercise(
                title = title,
                currentWeighInKg = weight,
                upWeightInNextTime = false
            )
        )
    }

}