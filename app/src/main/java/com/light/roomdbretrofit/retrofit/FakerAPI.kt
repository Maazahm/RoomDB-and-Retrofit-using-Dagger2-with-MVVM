package com.light.roomdbretrofit.retrofit

import com.light.roomdbretrofit.models.Product
import retrofit2.Response
import retrofit2.http.GET

interface FakerAPI {

    @GET("products")
    suspend fun getProducts() : Response<List<Product>>

    // Retrofit object is provided by dagger which is implemented in NetworkModule class
}