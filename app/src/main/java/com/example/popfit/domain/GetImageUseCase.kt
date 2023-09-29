package com.example.popfit.domain

import com.example.popfit.data.ImageSharedPrefRepImpl
import javax.inject.Inject

class GetImageUseCase @Inject constructor(private val sharedPreferences: ImageSharedPrefRepImpl) {
    fun getImage(): String? = sharedPreferences.get()
}