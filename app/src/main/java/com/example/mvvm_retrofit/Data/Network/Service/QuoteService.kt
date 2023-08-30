package com.example.mvvm_retrofit.Data.Network.Service

import com.example.mvvm_retrofit.Core.RetrofitHelper
import com.example.mvvm_retrofit.Data.Model.QuoteModel
import com.example.mvvm_retrofit.Data.Network.Interface.QuoteApiClient
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext

class QuoteService {

    private val retrofit=RetrofitHelper.getRetrofit()

    suspend fun getQuote():List<QuoteModel> {
        // Esto me sirve para ejecutar la accion en un hilo secundario, es una tarea asincrona "Corrutinas"
        return withContext(Dispatchers.IO) {
            val response = retrofit.create(QuoteApiClient::class.java).getAllQuoutes()
            response.body() ?: emptyList()
        }
    }
}