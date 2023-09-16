package com.example.popfit.domain

import com.example.popfit.data.Fruit
import com.example.popfit.data.FruitRepository
import javax.inject.Inject

class GetAllFruitsUseCase @Inject constructor(private val api: FruitRepository) {
    suspend fun getAllFruits() : List<Fruit> {
        return api.getFruitInfo()
    }

}