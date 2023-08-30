package com.example.mvvm_retrofit.Data.Network.Service

import com.example.mvvm_retrofit.Core.RetrofitHelper
import com.example.mvvm_retrofit.Data.Model.ProveedorModel
import com.example.mvvm_retrofit.Data.Network.Interface.ProveedorApiClient
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext

class ProveedorService {

    private val retrofit=RetrofitHelper.getProveedores()

    suspend fun getProveedores():List<ProveedorModel>{
        return withContext(Dispatchers.IO){
            val response= retrofit.create(ProveedorApiClient::class.java).getAllProveedores()
            response.body() ?: emptyList()
        }
    }
}