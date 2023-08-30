package com.example.mvvm_retrofit.Domain

import com.example.mvvm_retrofit.Data.Model.QuoteModel
import com.example.mvvm_retrofit.Data.Network.Repository.QuoteRepository

class GetQuotesUsesCase {
    private val repository= QuoteRepository()

    suspend operator fun invoke():List<QuoteModel>? =  repository.getAllQuote()

}