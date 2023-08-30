package com.example.mvvm_retrofit.ViewModel

import android.view.View
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.mvvm_retrofit.Data.Model.ArticuloModel
import com.example.mvvm_retrofit.Domain.GetArticulosUseCase
import kotlinx.coroutines.launch

class ArticuloViewModel() : ViewModel( ){

     val getArticulo= GetArticulosUseCase()
     val Articulo= MutableLiveData<List<ArticuloModel>>()
     val Loading= MutableLiveData<Boolean>()

     fun GetArticulo(itemId:String){
         viewModelScope.launch {
             Loading.postValue(true)
             val result = getArticulo(itemId)

             if(!result.isNullOrEmpty()){
                 Articulo.postValue(result)
                 Loading.postValue(false)
             }
         }


        }
    }
