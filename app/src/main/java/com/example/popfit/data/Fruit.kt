package com.example.popfit.data

import androidx.room.Entity
import androidx.room.PrimaryKey
import androidx.room.TypeConverters

@Entity
data class Fruit(
    val name: String,
    @PrimaryKey
    val id: Int,
    val family: String,
    val order: String,
    val genus: String,
    val nutritions: Nutritions
)