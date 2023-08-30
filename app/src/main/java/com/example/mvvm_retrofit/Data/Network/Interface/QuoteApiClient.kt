package com.example.mvvm_retrofit.Data.Network.Interface

import com.example.mvvm_retrofit.Data.Model.ProveedorModel
import com.example.mvvm_retrofit.Data.Model.QuoteModel
import retrofit2.Response
import retrofit2.http.GET

interface QuoteApiClient {

    @GET ("/.json")
    suspend fun getAllQuoutes():Response<List<QuoteModel>>


}