package com.example.mvvm_retrofit.Domain

import com.example.mvvm_retrofit.Data.Model.ArticuloModel
import com.example.mvvm_retrofit.Data.Network.Repository.ArticuloRepository

class GetArticulosUseCase {

    private val respository= ArticuloRepository()

    suspend operator fun invoke(idProveedor:String): List<ArticuloModel>{
        return respository.GetAllArticulos(idProveedor)
    }



}