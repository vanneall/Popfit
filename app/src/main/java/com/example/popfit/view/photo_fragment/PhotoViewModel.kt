package com.example.popfit.view.photo_fragment

import androidx.lifecycle.ViewModel
import com.example.popfit.domain.GetImageUseCase
import com.example.popfit.domain.LoadImageUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class PhotoViewModel @Inject constructor(
    private val getImageUseCase: GetImageUseCase,
    private val loadUseCase: LoadImageUseCase
) : ViewModel() {

    fun get() = getImageUseCase.getImage()

    fun load(uri: String) = loadUseCase.loadImage(uri)

}