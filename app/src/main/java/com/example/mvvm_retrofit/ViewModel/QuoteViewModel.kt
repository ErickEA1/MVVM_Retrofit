package com.example.mvvm_retrofit.ViewModel

import android.annotation.SuppressLint
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.mvvm_retrofit.Data.Model.QuoteModel
import com.example.mvvm_retrofit.Domain.GetQuotesUsesCase
import com.example.mvvm_retrofit.Domain.GetRandomQuoteUseCase
import kotlinx.coroutines.launch

class QuoteViewModel : ViewModel(){
        val quoteModel= MutableLiveData<QuoteModel>()
        val Loading = MutableLiveData<Boolean>()

        var getQuotesUsesCase = GetQuotesUsesCase()
        var getRandomQuotesUsesCase=GetRandomQuoteUseCase()
    fun onCreate() {
        viewModelScope.launch {
            Loading.postValue(true)
            val result = getQuotesUsesCase()


            if (!result.isNullOrEmpty()) {
                quoteModel.postValue(result[0])
                Loading.postValue(false )
            }
        }
    }

    @SuppressLint("NullSafeMutableLiveData")
    fun randomQuote() {
        Loading.postValue(true)
val quote=getRandomQuotesUsesCase()

        if (quote!=null){
            quoteModel.postValue(quote)
            Loading.postValue(false)
        }


        //val currentQuote: QuoteModel = QuoteProvider.Random()
        //quoteModel.postValue(currentQuote)
    }



}
