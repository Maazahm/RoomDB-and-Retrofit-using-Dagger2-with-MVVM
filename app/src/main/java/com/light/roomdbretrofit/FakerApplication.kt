package com.light.roomdbretrofit

import android.app.Application
import com.light.roomdbretrofit.di.ApplicationComponent
import com.light.roomdbretrofit.di.DaggerApplicationComponent

class FakerApplication : Application() {

    // Instance of ApplicationComponent is created which is an interface
    lateinit var applicationComponent: ApplicationComponent

    override fun onCreate() {
        super.onCreate()

        applicationComponent = DaggerApplicationComponent.factory().create(this)
    }
}