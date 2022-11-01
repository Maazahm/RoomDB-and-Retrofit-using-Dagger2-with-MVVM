package com.light.roomdbretrofit.viewmodels

import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.light.roomdbretrofit.models.Product
import com.light.roomdbretrofit.repository.ProductRepository
import kotlinx.coroutines.launch
import javax.inject.Inject

class MainViewModel2 @Inject constructor(private val repository: ProductRepository) : ViewModel() {

    val productsLiveData : LiveData<List<Product>>
    get() = repository.products

    init {
        viewModelScope.launch {
            repository.getProducts()
        }
    }
}