package com.light.roomdbretrofit.viewmodels

import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.light.roomdbretrofit.models.Product
import com.light.roomdbretrofit.repository.ProductRepository
import kotlinx.coroutines.launch
import javax.inject.Inject

// We can't use constructor injection over here because this class creates a ViewModelProvider
// We can't directly inject as another class creates object for us which is factory.

// Since we may need to add more parameters to view model we need to make those changes on factory
// also but that's not ideal. So, we say dagger to inject the parameters by making our factory
// create object of MainViewModel, this will prevent our factory to change with changing parameters
// of MainViewModel.
class MainViewModel @Inject constructor(private val repository: ProductRepository) : ViewModel() {

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