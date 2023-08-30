package com.example.mvvm_retrofit.Data.Network.Repository

import com.example.mvvm_retrofit.Data.Model.ProveedorModel
import com.example.mvvm_retrofit.Data.Model.Provider.ProveedorProvider
import com.example.mvvm_retrofit.Data.Network.Service.ProveedorService
import java.lang.Exception

class ProveedoresRepository {

    private val api= ProveedorService()

    suspend fun getAllProveedores():List<ProveedorModel>{
        try {
            val response = api.getProveedores()
            ProveedorProvider.proveedores = response
            return response
        }catch (e:Exception) {
            val message = e.message
            return emptyList()
        }

        }
    }