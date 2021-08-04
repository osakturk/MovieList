package com.example.moviecase.di.scope

import android.app.Application
import com.example.moviecase.MovieListApplication
import com.example.moviecase.di.module.ActivityModule
import com.example.moviecase.di.module.AppModule
import com.example.moviecase.di.module.NetworkModule
import dagger.BindsInstance
import dagger.Component
import dagger.android.AndroidInjectionModule
import dagger.android.support.AndroidSupportInjectionModule

@AppScope
@Component(
    modules = [
        AndroidInjectionModule::class,
        AndroidSupportInjectionModule::class,
        AppModule::class,
        ActivityModule::class,
        NetworkModule::class]
)
interface AppComponent {
    @Component.Builder
    interface Builder {
        @BindsInstance
        fun application(application: Application): Builder

        fun build(): AppComponent
    }

    fun inject(movieListApplication: MovieListApplication)
}