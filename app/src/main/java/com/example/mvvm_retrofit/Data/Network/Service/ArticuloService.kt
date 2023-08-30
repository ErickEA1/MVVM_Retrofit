package com.example.mvvm_retrofit.Data.Network.Service

import com.example.mvvm_retrofit.Core.RetrofitHelper
import com.example.mvvm_retrofit.Data.Model.ArticuloModel
import com.example.mvvm_retrofit.Data.Model.Provider.ArticuloProvider
import com.example.mvvm_retrofit.Data.Network.Interface.ArticuloApiClient
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext

class ArticuloService {

    private val retrofit = RetrofitHelper.getArticulos()

    suspend fun GetListArticulos( idProveedor:String):List<ArticuloModel>{
        return withContext(Dispatchers.IO){
            val response= retrofit.create(ArticuloApiClient::class.java).GetAllArticulo("$idProveedor")
            response.body() ?: emptyList()
        }
    }




}