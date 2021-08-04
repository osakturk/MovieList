package com.example.moviecase.di.module

import com.example.moviecase.MainActivity
import com.example.moviecase.di.module.fragmentbuilders.MainFragmentBuildersModule
import dagger.Module
import dagger.android.ContributesAndroidInjector


@Module
abstract class ActivityModule {

    @ContributesAndroidInjector(modules = [MainFragmentBuildersModule::class])
    abstract fun contributeHomeActivity(): MainActivity
}