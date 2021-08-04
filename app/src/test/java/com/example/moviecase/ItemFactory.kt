package com.example.moviecase

import com.example.moviecase.model.Genre
import com.example.moviecase.model.Movie
import com.example.moviecase.model.MovieDetailEntity
import com.example.moviecase.model.MovieListEntity
import java.util.concurrent.atomic.AtomicInteger
import kotlin.random.Random


class ItemFactory {
    private val counter = AtomicInteger(0)
    fun createMovie() : Movie {
        val id = counter.incrementAndGet()
        return Movie(
            id = id,
            adult = false,
            title = "title $id",
            vote_average = 10.0f,
            backdrop_path = "backdropPath $id",
            overview =  "overview $id",
            genre_ids = listOf(1, 2, 3),
            original_language = "en",
            original_title = "originalTitle $id",
            poster_path = "pasterPath $id",
            vote_count = 20,
            popularity = null,
            release_date = null,
            video = false
        )
    }

    fun createMovieListEntity() : MovieListEntity {
        val id = counter.incrementAndGet()
        val results = arrayListOf<Movie>()
        results.add(createMovie())
        results.add(createMovie())
        results.add(createMovie())
        results.add(createMovie())
        val randomNumber = Random(0)
        return MovieListEntity(id, results, randomNumber.nextInt(), randomNumber.nextInt())
    }

    fun createMovieDetailEntity() : MovieDetailEntity{
        val id = counter.incrementAndGet()

        var genres = arrayListOf<Genre>()
        genres.add(Genre(1,"a"))
        genres.add(Genre(2,"b"))
        genres.add(Genre(3,"c"))
        return MovieDetailEntity(
            id = id,
            adult = false,
            title = "title $id",
            vote_average = 10.0f,
            backdrop_path = "backdropPath $id",
            overview =  "overview $id",
            genres = genres,
            original_language = "en",
            original_title = "originalTitle $id",
            poster_path = "pasterPath $id",
            vote_count = 20,
            popularity = null,
            release_date = null,
            video = false
        )
    }
}