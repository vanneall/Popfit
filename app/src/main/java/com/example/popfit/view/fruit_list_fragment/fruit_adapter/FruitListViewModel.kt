package com.example.popfit.view.fruit_list_fragment.fruit_adapter

import android.widget.Toast
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.popfit.data.Fruit
import com.example.popfit.domain.GetAllFruitsUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import retrofit2.HttpException
import retrofit2.Retrofit
import java.io.IOException
import java.lang.Exception
import java.net.ConnectException
import javax.inject.Inject

@HiltViewModel
class FruitListViewModel @Inject constructor(private val getAllFruitsUseCase: GetAllFruitsUseCase) :  ViewModel() {

    val allFruits = MutableLiveData<List<Fruit>>()
    var toastShower: ShowToast? = null
    fun initializeAllFruitsList() {
        viewModelScope.launch{
            try {
                allFruits.postValue(getAllFruitsUseCase.getAllFruits())
            } catch (ex: IOException) {
                toastShower?.makeToastAndShow("Отсутствует подключение к интернету")
            }
        }
    }

}