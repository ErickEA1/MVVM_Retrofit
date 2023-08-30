package com.example.mvvm_retrofit.View

import android.opengl.Visibility
import android.os.Bundle
import androidx.activity.viewModels
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.isVisible
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModel
import com.example.mvvm_retrofit.ViewModel.QuoteViewModel
import com.example.mvvm_retrofit.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding
    private val quoteViewModel: QuoteViewModel by viewModels()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding= ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        quoteViewModel.onCreate()

        quoteViewModel.quoteModel.observe(this, Observer { currentCuote ->
            binding.txtQuote.text= currentCuote.quote
            binding.txtAutor.text=currentCuote.author
        })
        quoteViewModel.Loading.observe(this, Observer {
            binding.pginicio.isVisible= it
        })

        binding.ViewContainer.setOnClickListener{quoteViewModel.randomQuote()}
    }
}