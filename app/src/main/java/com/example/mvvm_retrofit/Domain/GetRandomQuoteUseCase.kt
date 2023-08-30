package com.example.mvvm_retrofit.Domain

import com.example.mvvm_retrofit.Data.Model.QuoteModel
import com.example.mvvm_retrofit.Data.Model.Provider.QuoteProvider

class GetRandomQuoteUseCase {


    operator fun invoke():QuoteModel?{
        val quotes = QuoteProvider.quotes
        if(!quotes.isNullOrEmpty()){
            val randomnumber=(quotes.indices).random()
            return quotes[randomnumber]
        }
        return null
    }
}