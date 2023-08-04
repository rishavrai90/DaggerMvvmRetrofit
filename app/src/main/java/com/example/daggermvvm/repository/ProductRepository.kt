package com.example.daggermvvm.repository

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import com.example.daggermvvm.models.Products
import com.example.daggermvvm.retrofit.ApiGet
import javax.inject.Inject

class ProductRepository @Inject constructor(private val dataApi: ApiGet) {

    private val _products = MutableLiveData<List<Products>>()
    val products: LiveData<List<Products>>
        get() = _products

    suspend fun getProducts() {
        val result = dataApi.getProducts()
        if (result.isSuccessful && result.body()!=null){
            _products.postValue(result.body())
        }
    }
}