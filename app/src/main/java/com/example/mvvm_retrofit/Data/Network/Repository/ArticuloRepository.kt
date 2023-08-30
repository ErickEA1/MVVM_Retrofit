package com.example.mvvm_retrofit.Data.Network.Repository

import com.example.mvvm_retrofit.Data.Model.ArticuloModel
import com.example.mvvm_retrofit.Data.Model.Provider.ArticuloProvider
import com.example.mvvm_retrofit.Data.Network.Service.ArticuloService
import java.lang.Exception

class ArticuloRepository {

    private val Servicio = ArticuloService()

    suspend fun GetAllArticulos(idProveedor:String):List<ArticuloModel>{
        try {
            val response = Servicio.GetListArticulos(idProveedor)
            ArticuloProvider.articulos = response
            return response
        }catch (e:Exception){
            return emptyList()
        }
    }

}