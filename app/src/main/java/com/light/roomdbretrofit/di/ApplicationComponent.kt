package com.light.roomdbretrofit.di

import android.content.Context
import com.light.roomdbretrofit.MainActivity
import dagger.BindsInstance
import dagger.Component
import javax.inject.Singleton

// This component has some objects which are singleton for the entire application
// If we want some application level singleton then we define our component at application level
// Components have some scoped objects inside them hence we mark singleton
@Singleton
@Component(modules = [NetworkModule::class, DatabaseModule::class])
interface ApplicationComponent {

    // We will annotate few fields of MainActivity with @Inject. So when dagger reaches this component
    // it will check which fields are annotated with @Inject dagger will initialize them. This is called
    // field injection.
    fun inject(mainActivity: MainActivity)

    // Factory work is to create objects and here ApplicationComponent Object is being created
    @Component.Factory
    interface Factory{
        fun create(@BindsInstance context: Context) : ApplicationComponent
    }
}