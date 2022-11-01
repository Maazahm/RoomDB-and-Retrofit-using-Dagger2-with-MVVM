package com.light.roomdbretrofit.di

import com.light.roomdbretrofit.MainActivity
import dagger.Component
import javax.inject.Singleton

// This component has some objects which are singleton for the entire application
// If we want some application level singleton then we define our component at application level
// Components have some scoped objects inside them hence we mark singleton
@Singleton
@Component(modules = [NetworkModule::class])
interface ApplicationComponent {

    // We will annotate few fields of MainActivity with @Inject. So when dagger reaches this component
    // it will check which fields are annotated with @Inject dagger will initialize them. This is called
    // field injection.
    fun inject(mainActivity: MainActivity)
}