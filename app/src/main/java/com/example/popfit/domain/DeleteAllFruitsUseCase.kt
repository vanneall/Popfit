package com.example.popfit.domain

import com.example.popfit.data.Fruit
import com.example.popfit.storage.FruitDao
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import javax.inject.Inject

class DeleteAllFruitsUseCase @Inject constructor(private val fruitDao: FruitDao) {
    fun deleteAll() {
        CoroutineScope(Dispatchers.IO).launch { fruitDao.clearAll() }
    }

}