package com.example.mvvm_retrofit.Data.Model

import com.google.gson.annotations.SerializedName
import java.sql.Date

data class ProveedorModel(

    @SerializedName("id_proveedor") val id_proveedor:String?,
    @SerializedName("rfc") val rfc:String?,
    @SerializedName("razon_social") val razon_social:String?,
    @SerializedName("nombre_contacto") val nombre_contacto:String?,
    @SerializedName("tel_principal") val tel_principal:String?,
    @SerializedName("tel_movil") val tel_movil:String?,
    @SerializedName("e_mail") val e_mail:String?,
    @SerializedName("estatus") val estatus:String?,
    @SerializedName("fecha_registro") val fecha_registro:String?

    )