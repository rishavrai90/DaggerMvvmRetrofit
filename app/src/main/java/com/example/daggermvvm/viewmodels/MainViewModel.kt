package com.example.daggermvvm.viewmodels

import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.daggermvvm.models.Products
import com.example.daggermvvm.repository.ProductRepository
import kotlinx.coroutines.launch

class MainViewModel(private val repository: ProductRepository) : ViewModel() {
    val productsLiveData:LiveData<List<Products>>
        get() = repository.products

    init {
        viewModelScope.launch {
            repository.getProducts()
        }
    }
}