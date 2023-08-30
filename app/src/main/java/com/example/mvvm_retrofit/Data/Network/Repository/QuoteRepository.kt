package com.example.mvvm_retrofit.Data.Network.Repository

import com.example.mvvm_retrofit.Data.Model.QuoteModel
import com.example.mvvm_retrofit.Data.Model.Provider.QuoteProvider
import com.example.mvvm_retrofit.Data.Network.Service.QuoteService

class QuoteRepository {

    private val api= QuoteService()

    suspend fun getAllQuote():List<QuoteModel>{
        val response=api.getQuote()
        QuoteProvider.quotes = response
        return response
    }
}