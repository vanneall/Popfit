package com.example.popfit.domain

import com.example.popfit.data.ImageSharedPrefRepImpl
import javax.inject.Inject

class LoadImageUseCase @Inject constructor(private val sharedPreferences: ImageSharedPrefRepImpl) {

    fun loadImage(uri: String) {
        sharedPreferences.load(uri)
    }

}