package com.example.popfit.view.fruit_list_fragment.fruit_adapter

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.popfit.data.Fruit
import com.example.popfit.domain.DeleteAllFruitsUseCase
import com.example.popfit.domain.GetAllFruitsFromDbUseCase
import com.example.popfit.domain.GetAllFruitsUseCase
import com.example.popfit.domain.WriteAllFruitsToDbUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import java.io.IOException
import javax.inject.Inject

@HiltViewModel
class FruitListViewModel @Inject constructor(
    private val getAllFruitsUseCase: GetAllFruitsUseCase,
    private val writeAllFruitsToDbUseCase: WriteAllFruitsToDbUseCase,
    private val deleteAllFruitsUseCase: DeleteAllFruitsUseCase,
    private val getAllFruitsFromDbUseCase: GetAllFruitsFromDbUseCase
) : ViewModel() {

    var allFruits = getAllFruitsFromDbUseCase.getAllFruits()
    var toastShower: ShowToast? = null

    fun getFruitsFromServer() {
        viewModelScope.launch {
            try {
                val res = getAllFruitsUseCase.getAllFruits()
                writeToDb(res)
            } catch (ex: IOException) {
                toastShower?.makeToastAndShow("Отсутствует подключение к интернету")
            }
        }
    }

    fun deleteFruits() {
        deleteAllFruitsUseCase.deleteAll()
    }

    private fun writeToDb(list: List<Fruit>) {
        writeAllFruitsToDbUseCase.writeAllFruitsToDb(list)
    }

}