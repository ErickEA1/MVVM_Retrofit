package com.example.mvvm_retrofit.Data.Network.Interface

import com.example.mvvm_retrofit.Data.Model.ArticuloModel
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Path
import retrofit2.http.Query

interface ArticuloApiClient {

    @GET("api/articulo/{IdProveedor}")
    suspend fun GetAllArticulo(@Path("IdProveedor") id: String): Response<List<ArticuloModel>>
}