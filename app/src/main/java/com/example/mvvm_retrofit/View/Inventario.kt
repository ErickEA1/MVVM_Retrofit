package com.example.mvvm_retrofit.View

import android.content.Context
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.AdapterView
import android.widget.ArrayAdapter
import android.widget.Spinner
import android.widget.TextView
import android.widget.Toast
import androidx.activity.viewModels
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.isVisible
import androidx.lifecycle.Observer
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.mvvm_retrofit.Data.Model.ArticuloModel
import com.example.mvvm_retrofit.Data.Model.ProveedorModel
import com.example.mvvm_retrofit.R
import com.example.mvvm_retrofit.ViewModel.ArticuloViewModel
import com.example.mvvm_retrofit.ViewModel.ProveedorViewModel
import com.example.mvvm_retrofit.databinding.ActivityInventarioBinding
import kotlinx.coroutines.runBlocking
import java.lang.Exception
import java.util.ArrayList

class Inventario : AppCompatActivity() {
    private lateinit var binding: ActivityInventarioBinding
    private val model: ProveedorViewModel by viewModels()
    private val modelArticulo: ArticuloViewModel by viewModels()
    private val contexto: Context = this

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityInventarioBinding.inflate(layoutInflater)
        setContentView(binding.root)

        model.onCreate()

        model.proveedores.observe(this, Observer {
            val data: ArrayList<ProveedorModel> = ArrayList()
            it.forEach { x ->
                data.add(x)
            }

                populateSpinner(binding.SpinnerDataProveedor, data)

        })

        model.Loading.observe(this, Observer {
            binding.pg2.isVisible = it
        })

    }

    private fun populateSpinner(spinner: Spinner, proveedores: ArrayList<ProveedorModel>) {

        val adapter = ArrayAdapter(
            this,
            android.R.layout.simple_spinner_item,
            proveedores.map { it.razon_social })
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item)
        spinner.adapter = adapter

        spinner.onItemSelectedListener = object : AdapterView.OnItemSelectedListener {
            override fun onItemSelected(
                parent: AdapterView<*>?,
                view: View?,
                position: Int,
                id: Long
            ) {
                val proveedorSeleccionado = proveedores[position]
                val idProveedorSeleccionado = proveedorSeleccionado.id_proveedor
                Toast.makeText(contexto, idProveedorSeleccionado, Toast.LENGTH_LONG).show()
                if (idProveedorSeleccionado != null) {
                    ListadoArticulos(idProveedorSeleccionado)

                }
                // Utiliza el idProveedorSeleccionado según tu necesidad
            }

            override fun onNothingSelected(parent: AdapterView<*>?) {
                // Manejo cuando no se selecciona nada
            }

        }
    }

    private fun populateListadoArticulos(Item:ArrayList<ArticuloModel>, recyclerView: RecyclerView){
    val layoutManager = LinearLayoutManager(this)
   recyclerView.layoutManager = layoutManager

    val adapter = ItemAdapter(Item)
    recyclerView.adapter = adapter
}

    private fun ListadoArticulos(idProveedor:String) {

        modelArticulo.GetArticulo(idProveedor)
        model.Loading.observe(this, Observer {
            binding.pg2.isVisible = it
        })
try{
        modelArticulo.Articulo.observe(this, Observer {
            val data = ArrayList<ArticuloModel>()
            it.forEach { x ->
                data.add(x)
            }
            populateListadoArticulos(data, binding.rvListArticulos)
        })
    }catch (e:Exception){
        val mensaje:String=e.message.toString()
    }
    }

}

class ItemViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
    val codBarras: TextView = itemView.findViewById(R.id.txtCodBarras)
    val NomProd: TextView = itemView.findViewById(R.id.txtNombre)
}


class ItemAdapter(private val itemList: List<ArticuloModel>) : RecyclerView.Adapter<ItemViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ItemViewHolder {
        val itemView = LayoutInflater.from(parent.context).inflate(R.layout.item_list_articulo, parent, false)
        return ItemViewHolder(itemView)
    }

    override fun onBindViewHolder(holder: ItemViewHolder, position: Int) {
        val currentItem = itemList[position]
        holder.codBarras.text = currentItem.cod_barras
        holder.NomProd.text =currentItem.descripcion
        // Ejemplo de cómo obtener datos del objeto
    }

    override fun getItemCount() = itemList.size
}

