package com.example.popfit.data

import retrofit2.http.GET

interface FruitRepository {
    suspend fun getFruitInfo() : List<Fruit>
}