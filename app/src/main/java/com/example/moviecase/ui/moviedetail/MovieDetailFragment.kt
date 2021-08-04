package com.example.moviecase.ui.moviedetail

import android.os.Bundle
import android.view.Menu
import android.view.MenuInflater
import androidx.lifecycle.Observer
import com.example.moviecase.BuildConfig
import com.example.moviecase.R
import com.example.moviecase.base.BaseFragment
import com.example.moviecase.databinding.MovieDetailFragmentBinding
import com.squareup.picasso.Picasso

class MovieDetailFragment : BaseFragment<MovieDetailViewModel, MovieDetailFragmentBinding>() {
    override val getLayoutId: Int = R.layout.movie_detail_fragment
    override val viewModelClass: Class<MovieDetailViewModel> = MovieDetailViewModel::class.java

    private var movieId: Int? = 0


    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        setHasOptionsMenu(true)
        init()
        observe()
    }

    private fun init() {
        movieId = arguments?.getInt("id")
        movieId?.let { viewModel.getMovieDetail(it) }
    }

    override fun onCreateOptionsMenu(menu: Menu, inflater: MenuInflater) {
        activity?.menuInflater?.inflate(R.menu.filter_menu, menu)
    }

    private fun observe() {
        var count = 0
        viewModel.data.observe(this, Observer { data ->
            Picasso.get().load(BuildConfig.BASE_URL + data.poster_path.replace("/","")).into(binding.productImageView)
            binding.overviewValue.text = data.overview
            binding.voteAverage.text = data.vote_average.toString()
            binding.productTitleText.text = data.original_title
            binding.releaseDateValue.text = data.release_date
            data.spoken_languages.forEach{language ->
                binding.spokenLanguagesValue.append(language.english_name)
                if (count < data.spoken_languages.size -1){
                    binding.spokenLanguagesValue.append(", ")
                }
                count++
            }
            count = 0
            data.genres.forEach{ genre ->
                binding.genresValue.append(genre.name)
                if (count < data.genres.size -1){
                    binding.genresValue.append(", ")
                }
                count++
            }
            count = 0
            data.production_companies.forEach{company ->
                binding.productionCompaniesValue.append(company.name)
                if (count < data.production_companies.size -1){
                    binding.productionCompaniesValue.append(", ")
                }
                count++
            }
            count = 0
            data.production_countries.forEach{country ->
                binding.productionCountriesValue.append(country.name)
                if (count < data.production_countries.size -1){
                    binding.productionCountriesValue.append(", ")
                }
                count++
            }
        })
    }

}