package com.example.mvvm_retrofit.Domain

import com.example.mvvm_retrofit.Data.Model.ProveedorModel
import com.example.mvvm_retrofit.Data.Network.Repository.ProveedoresRepository

class GetProveedoresUseCase {

    private val repository= ProveedoresRepository()

    suspend operator fun invoke():List<ProveedorModel>? = repository.getAllProveedores()

}