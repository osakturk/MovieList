package com.example.moviecase.di.module.fragmentbuilders

import com.example.moviecase.ui.movie.MovieListFragment
import com.example.moviecase.ui.moviedetail.MovieDetailFragment
import dagger.Module
import dagger.android.ContributesAndroidInjector

@Module
abstract class MainFragmentBuildersModule {

    @ContributesAndroidInjector
    abstract fun movieListFragment(): MovieListFragment

    @ContributesAndroidInjector
    abstract fun movieDetailFragment(): MovieDetailFragment
}