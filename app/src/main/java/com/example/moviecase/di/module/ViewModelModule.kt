package com.example.moviecase.di.module

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.example.moviecase.base.ViewModelFactory
import com.example.moviecase.di.qualifiers.ViewModelKey
import com.example.moviecase.ui.movie.MovieListViewModel
import com.example.moviecase.ui.moviedetail.MovieDetailViewModel
import dagger.Binds
import dagger.Module
import dagger.multibindings.IntoMap

@Module
abstract class ViewModelModule {
    @Binds
    abstract fun bindViewModelFactory(factory: ViewModelFactory): ViewModelProvider.Factory

    @Binds
    @IntoMap
    @ViewModelKey(MovieListViewModel::class)
    abstract fun movieListBindViewModel(movieViewModel: MovieListViewModel): ViewModel

    @Binds
    @IntoMap
    @ViewModelKey(MovieDetailViewModel::class)
    abstract fun movieDetailBindViewModel(movieDetailViewModel: MovieDetailViewModel): ViewModel
}
