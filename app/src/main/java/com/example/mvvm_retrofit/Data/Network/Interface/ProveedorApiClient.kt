package com.example.mvvm_retrofit.Data.Network.Interface

import com.example.mvvm_retrofit.Data.Model.ProveedorModel
import retrofit2.Response
import retrofit2.http.GET

interface ProveedorApiClient {
    @GET("api/proveedores/")
    suspend fun getAllProveedores(): Response<List<ProveedorModel>>
}