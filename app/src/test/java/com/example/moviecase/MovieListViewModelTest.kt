package com.example.moviecase

import androidx.arch.core.executor.testing.InstantTaskExecutorRule
import androidx.lifecycle.LiveData
import androidx.lifecycle.Observer
import com.example.moviecase.model.Movie
import com.example.moviecase.ui.movie.MovieListRepository
import com.example.moviecase.ui.movie.MovieListViewModel
import io.mockk.*
import io.mockk.impl.annotations.MockK
import kotlinx.coroutines.ExperimentalCoroutinesApi
import kotlinx.coroutines.test.runBlockingTest
import org.junit.Before
import org.junit.Rule
import org.junit.Test
import kotlin.test.assertEquals

@ExperimentalCoroutinesApi
class MovieListViewModelTest {

    private lateinit var movieListViewModel: MovieListViewModel

    @MockK
    lateinit var movieListRepository: MovieListRepository

    @get:Rule
    var instantExecutorRule = InstantTaskExecutorRule()

    @get:Rule
    var mainCoroutineRule = MainCoroutinesRule()

    @Before
    fun setup() {
        MockKAnnotations.init(this, relaxUnitFun = true)
        movieListViewModel = MovieListViewModel(movieListRepository)
    }

    @Test
    fun testMovie() = runBlockingTest {

        val movieObserver: Observer<List<Movie>> = mockk(relaxed = true)
        val movieListLiveData: LiveData<List<Movie>> = movieListViewModel.data

        val itemFactory = ItemFactory()
        val results = arrayListOf<Movie>()
        results.add(itemFactory.createMovie())
        results.add(itemFactory.createMovie())
        results.add(itemFactory.createMovie())
        results.add(itemFactory.createMovie())

        coEvery {
            movieListRepository.getMovieList(movieListViewModel, "test", page = 1).toString()
        } returns itemFactory.createMovieListEntity().toString()
        assertEquals(
            itemFactory.createMovieListEntity().toString(),
            movieListViewModel.getMovieList("test", page = 1).toString()
        )
        coVerify { movieListViewModel.getMovieList("test", page = 1).toString() }



        movieListLiveData.observeForever(movieObserver)

        verify {
            movieObserver.onChanged(results)
        }

        movieListLiveData.removeObserver(movieObserver)

    }
}