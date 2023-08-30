package com.example.mvvm_retrofit.Data.Model

import com.google.gson.annotations.SerializedName

data class QuoteModel(@SerializedName("quote") val quote:String,@SerializedName("author") val author:String)
