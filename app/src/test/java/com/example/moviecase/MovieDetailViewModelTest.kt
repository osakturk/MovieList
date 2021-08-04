package com.example.moviecase

import androidx.arch.core.executor.testing.InstantTaskExecutorRule
import androidx.lifecycle.LiveData
import androidx.lifecycle.Observer
import com.example.moviecase.model.MovieDetailEntity
import com.example.moviecase.ui.moviedetail.MovieDetailRepository
import com.example.moviecase.ui.moviedetail.MovieDetailViewModel
import io.mockk.*
import io.mockk.impl.annotations.MockK
import kotlinx.coroutines.ExperimentalCoroutinesApi
import kotlinx.coroutines.test.runBlockingTest
import org.junit.Before
import org.junit.Rule
import org.junit.Test
import kotlin.test.assertEquals

@ExperimentalCoroutinesApi
class MovieDetailViewModelTest {

    private lateinit var movieDetailViewModel: MovieDetailViewModel

    @MockK
    lateinit var movieDetailRepository: MovieDetailRepository

    @get:Rule
    var instantExecutorRule = InstantTaskExecutorRule()

    @get:Rule
    var mainCoroutineRule = MainCoroutinesRule()

    @Before
    fun setup() {
        MockKAnnotations.init(this, relaxUnitFun = true)
        movieDetailViewModel = MovieDetailViewModel(movieDetailRepository)
    }

    @Test
    fun testMovieDetail() = runBlockingTest {

        val movieObserver: Observer<MovieDetailEntity> = mockk(relaxed = true)
        val movieLiveData: LiveData<MovieDetailEntity> = movieDetailViewModel.data

        val itemFactory = ItemFactory()
        val movie = itemFactory.createMovieDetailEntity()

        coEvery {
            movieDetailRepository.getMovieDetail(movieDetailViewModel, 749645).toString()
        } returns itemFactory.createMovieDetailEntity().toString()
        assertEquals(
            itemFactory.createMovieDetailEntity().toString(),
            movieDetailViewModel.getMovieDetail(749645).toString()
        )
        coVerify { movieDetailViewModel.getMovieDetail(749645) }

        movieLiveData.observeForever(movieObserver)

        verify {
            movieObserver.onChanged(movie)
        }

        movieLiveData.removeObserver(movieObserver)

    }
}