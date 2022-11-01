package com.light.roomdbretrofit.di

import androidx.lifecycle.ViewModel
import com.light.roomdbretrofit.viewmodels.MainViewModel
import com.light.roomdbretrofit.viewmodels.MainViewModel2
import dagger.Binds
import dagger.Module
import dagger.multibindings.ClassKey
import dagger.multibindings.IntoMap
import dagger.multibindings.StringKey

@Module
abstract class ViewModelModule {

    // This is multibinding which we use to generalise the viewModelFactory
    // This annotation binds ViewModel with the function
    @Binds
    // We can pass the below string as a key to hashmap and we can access object of ViewModel. We do
    // this because we have multiple functions returning ViewModel object so to differentiate that
    // so dagger doesn't get confused we use below string as key and using hashmap we access the object.
    // This makes it easy to have one generalised factory for all viewModels instead of creating multiple
    // factories for multiple ViewModel.
    // Another way to do this is using class key where key is class name - @ClassKey(MainViewModel::class)

    // @StringKey("mainViewModel")
    @ClassKey(MainViewModel::class)
    // This annotation creates a dictionary with key value pair
    @IntoMap
    abstract fun mainViewModel(mainViewModel: MainViewModel) : ViewModel

    @Binds
    @ClassKey(MainViewModel2::class)
    abstract fun mainViewModel2(mainViewModel2: MainViewModel2) : ViewModel
}