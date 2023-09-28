package com.example.popfit.domain

import com.example.popfit.storage.FruitDao
import javax.inject.Inject

class GetAllFruitsFromDbUseCase @Inject constructor(private val fruitDao: FruitDao) {

    fun getAllFruits() = fruitDao.getAllFruits()

}