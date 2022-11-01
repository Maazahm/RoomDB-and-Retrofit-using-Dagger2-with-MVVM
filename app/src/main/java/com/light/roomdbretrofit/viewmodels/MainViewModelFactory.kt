package com.light.roomdbretrofit.viewmodels

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.light.roomdbretrofit.repository.ProductRepository
import javax.inject.Inject

// Our MainViewModel says to factory to make MainViewModel object and factory says dagger to make it
// and factory will just return the object.
// Then dagger says just make sure I can create the object and I will create it. The Inject annotation
// on ProductRepository makes sure that object can be created which is passed as parameter in MainViewModel
class MainViewModelFactory @Inject constructor(
    private val map: Map<Class<*>, @JvmSuppressWildcards ViewModel>
) : ViewModelProvider.Factory {

    // Whenever MainActivity tries to access a view model class, class name is passed as a key from
    // MainActivity to here. The modelClass now has class name as the value which is passed as a key
    // to map so that object is returned.
    override fun <T : ViewModel> create(modelClass: Class<T>): T {
        return map[modelClass] as T
    }
}