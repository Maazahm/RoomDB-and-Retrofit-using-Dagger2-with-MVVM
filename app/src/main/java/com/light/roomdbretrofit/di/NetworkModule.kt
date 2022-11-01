package com.light.roomdbretrofit.di

import com.light.roomdbretrofit.retrofit.FakerAPI
import com.light.roomdbretrofit.utils.Constants
import dagger.Module
import dagger.Provides
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import javax.inject.Singleton

@Module
class NetworkModule {

    // It is a provides method so we annotate with Provides annotation and one instance of retrofit
    // is required throughout the application so we use singleton as annotation.
    @Singleton
    @Provides
    fun providesRetrofit() : Retrofit {
        return Retrofit.Builder()
            .baseUrl(Constants.BASE_URL)
            .addConverterFactory(GsonConverterFactory.create())
            .build()
    }

    // This function will provide implementation for our interface/ api FakerAPI.
    // For that we need Retrofit object which the above function provides.
    // When dagger sees the function it checks if any function is providing Retrofit object
    // and from above function dagger will provide the object in the function as a parameter.
    // Only one object of our API is created throughout our application.
    @Singleton
    @Provides
    fun providesFakerAPI(retrofit: Retrofit) : FakerAPI {// Returns FakerAPI
        return retrofit.create(FakerAPI::class.java)
    }
}