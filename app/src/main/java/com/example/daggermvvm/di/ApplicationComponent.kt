package com.example.daggermvvm.di

import com.example.daggermvvm.MainActivity
import dagger.Component
import javax.inject.Singleton

/**
 * Maine ise Application level pe define kiya hai
 */
@Singleton
@Component(modules = [NetworkModule::class])
interface ApplicationComponent {

    fun inject(mainActivity: MainActivity)
}