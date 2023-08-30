package com.example.mvvm_retrofit.Data.Model

import java.math.BigDecimal
import java.time.LocalDateTime
import java.util.UUID

data class ArticuloModel(
    val cod_barras: String?,
    val cod_asociado: String?,
    val id_clasificacion: Long?,
    val cod_interno: String?,
    val descripcion: String?,
    val descripcion_corta: String?,
    val cantidad_um: BigDecimal?,
    val id_unidad: String,
    val id_proveedor: String,
    val precio_compra: BigDecimal?,
    val utilidad: BigDecimal?,
    val precio_venta: BigDecimal?,
    val tipo_articulo: String?,
    val stock: BigDecimal?,
    val stock_min: BigDecimal?,
    val stock_max: BigDecimal?,
    val iva: BigDecimal?,
    val kit_fecha_ini: String?,
    val kit_fecha_fin: String?,
    val articulo_disponible: Boolean?,
    val kit: Boolean?,
    val fecha_registro: String?,
    val visible: Boolean?,
    val puntos: String?,
    val last_update_inventory: String?,
    val cve_producto: String?
)
