package com.example.popfit.data

import android.os.Parcelable
import androidx.room.Entity
import androidx.room.PrimaryKey
import kotlinx.parcelize.Parcelize

@Parcelize
@Entity
data class Exercise(
    @PrimaryKey(autoGenerate = true)
    val id: Int = 0,
    var title: String,
    var currentWeighInKg: Float,
    var upWeightInNextTime: Boolean
) : Parcelable