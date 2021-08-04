package com.example.moviecase.di.module

import android.app.Application
import android.content.Context
import com.example.moviecase.BuildConfig
import com.example.moviecase.di.qualifiers.BaseUrlQualifier
import com.example.moviecase.di.scope.AppScope
import dagger.Module
import dagger.Provides


@Module(includes = [ViewModelModule::class])
class AppModule {
    @Provides
    @AppScope
    fun provideContext(application: Application): Context {
        return application.applicationContext
    }

    @Provides
    @AppScope
    @BaseUrlQualifier
    fun provideBaseUrl(): String {
        return BuildConfig.BASE_URL
    }

}