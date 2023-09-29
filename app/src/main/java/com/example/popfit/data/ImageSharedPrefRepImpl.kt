package com.example.popfit.data

import android.content.Context
import javax.inject.Inject

class ImageSharedPrefRepImpl @Inject constructor(private val context: Context) {

    fun load(uri: String) {
        val sharedPref = context.getSharedPreferences("image_storage", Context.MODE_PRIVATE)
        sharedPref.edit().putString("image", uri).apply()
    }

    fun get(): String? {
        val sharedPref = context.getSharedPreferences("image_storage", Context.MODE_PRIVATE)
        return sharedPref.getString("image", null)
    }

}