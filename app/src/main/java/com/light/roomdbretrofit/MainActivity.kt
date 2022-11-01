package com.light.roomdbretrofit

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.lifecycle.ViewModelProvider
import com.light.roomdbretrofit.databinding.ActivityMainBinding
import com.light.roomdbretrofit.viewmodels.MainViewModel
import com.light.roomdbretrofit.viewmodels.MainViewModelFactory
import javax.inject.Inject

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding

    lateinit var mainViewModel: MainViewModel

    // In order to create an instance of this we need to use inject now we need to say dagger that we have
    // added @Inject so initialize it.
    // We use component to do this.
    // This is called field injection.
    @Inject
    lateinit var mainViewModelFactory: MainViewModelFactory

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        val view = binding.root
        setContentView(view)

        (application as FakerApplication).applicationComponent.inject(this)
        mainViewModel = ViewModelProvider(this, mainViewModelFactory).get(MainViewModel::class.java)

        mainViewModel.productsLiveData.observe(this, {
            binding.products.text = it.joinToString { x -> x.title + "\n\n" }
        })
    }
}