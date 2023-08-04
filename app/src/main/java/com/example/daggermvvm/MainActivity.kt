package com.example.daggermvvm

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.TextView
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import com.example.daggermvvm.viewmodels.MainViewModel
import com.example.daggermvvm.viewmodels.MainViewModelFactory
import javax.inject.Inject

class MainActivity : AppCompatActivity() {


    lateinit var mainViewModel: MainViewModel

    /**
     * MainViewModelFactory ko maine Inject karvaya hai Inject karvane ke liye hme component access karna hoga -
     * -
     */
    @Inject
    lateinit var mainViewModelFactory: MainViewModelFactory

    private val products:TextView
        get()=findViewById(R.id.products)

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        /**
         * Iske Through maine component access kiya
         */
        (application as ApplicationLevel).applicationComponent.inject(this)
                mainViewModel = ViewModelProvider(this,mainViewModelFactory).get(MainViewModel::class.java)

        mainViewModel.productsLiveData.observe(this, Observer {
            products.text=it.joinToString { x->x.title +"\n\n" }
        })
    }
}