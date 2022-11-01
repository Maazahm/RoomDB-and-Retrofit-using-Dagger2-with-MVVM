package com.light.roomdbretrofit.repository

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import com.light.roomdbretrofit.db.FakerDB
import com.light.roomdbretrofit.models.Product
import com.light.roomdbretrofit.retrofit.FakerAPI
import javax.inject.Inject

// Dagger will provide object of FakerAPI as constructor injection is used.
class ProductRepository @Inject constructor(private val fakerAPI: FakerAPI, private val fakerDB: FakerDB) {

    // We don't want anyone to change our data so we make it private and expose LiveData.
    // MutableLiveData can be changed while LiveData is immutable.
    private val _products = MutableLiveData<List<Product>>()
    val products: LiveData<List<Product>>
    get() = _products

    // This suspend function calls api which gets products and MutableLiveData is set.
    suspend fun getProducts(){
        val result = fakerAPI.getProducts()
        if (result.isSuccessful && result.body()!=null) {
            fakerDB.getFakerDao().addProducts(result.body()!!)
            _products.postValue(result.body())
        }
    }
}