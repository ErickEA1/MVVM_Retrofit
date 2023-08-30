package com.example.mvvm_retrofit.ViewModel

import android.annotation.SuppressLint
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelStore
import androidx.lifecycle.viewModelScope
import androidx.lifecycle.viewmodel.viewModelFactory
import com.example.mvvm_retrofit.Data.Model.ProveedorModel
import com.example.mvvm_retrofit.Domain.GetProveedoresUseCase
import kotlinx.coroutines.launch

class ProveedorViewModel : ViewModel (){

     val proveedores= MutableLiveData<List<ProveedorModel>>()
    val Loading = MutableLiveData<Boolean>()

    val getProveeUseCase=GetProveedoresUseCase()

    @SuppressLint("NullSafeMutableLiveData")
    fun onCreate(){
        viewModelScope.launch{
            Loading.postValue(true)
            val result = getProveeUseCase()

            if (!result.isNullOrEmpty()){
                proveedores.postValue(result)
                Loading.postValue(false)
            }
        }
    }


}