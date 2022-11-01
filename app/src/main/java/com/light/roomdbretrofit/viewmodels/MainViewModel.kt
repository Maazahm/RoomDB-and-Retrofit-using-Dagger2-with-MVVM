package com.light.roomdbretrofit.viewmodels

import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.light.roomdbretrofit.models.Product
import com.light.roomdbretrofit.repository.ProductRepository
import kotlinx.coroutines.launch

// We can't use constructor injection over here because this class creates a ViewModelProvider
// We can't directly inject as another class creates object for us which is factory.
class MainViewModel(private val repository: ProductRepository) : ViewModel() {

    // Observes the data exposed by repository
    val productsLiveData : LiveData<List<Product>>
    get() = repository.products

    // Initializes a block with a scope of viewModel
    init {
        viewModelScope.launch {
            repository.getProducts()
        }
    }
}