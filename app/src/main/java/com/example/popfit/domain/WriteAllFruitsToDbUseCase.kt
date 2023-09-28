package com.example.popfit.domain

import com.example.popfit.data.Fruit
import com.example.popfit.storage.FruitDao
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import javax.inject.Inject

class WriteAllFruitsToDbUseCase @Inject constructor(private val fruitDao: FruitDao) {
    fun writeAllFruitsToDb(fruits: List<Fruit>) {
        CoroutineScope(Dispatchers.IO).launch {
            for (fruit in fruits) {
                fruitDao.insertFruit(fruit)
            }
        }
    }
}