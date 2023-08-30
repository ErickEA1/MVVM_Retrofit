package com.example.mvvm_retrofit.Core

import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

object RetrofitHelper {
    fun getRetrofit(): Retrofit {
            return Retrofit.Builder()
                .baseUrl("https://drawsomething-59328-default-rtdb.europe-west1.firebasedatabase.app/")
                .addConverterFactory(GsonConverterFactory.create())
                .build()
    }

    fun getProveedores(): Retrofit{
        return Retrofit.Builder()
            .baseUrl("http://192.168.10.33:9094/")
            .addConverterFactory((GsonConverterFactory.create()))
            .build()
    }

    fun getArticulos():Retrofit{
        return Retrofit.Builder()
            .baseUrl("http://192.168.10.33:9093/")
            .addConverterFactory(GsonConverterFactory.create())
            .build()
    }
}