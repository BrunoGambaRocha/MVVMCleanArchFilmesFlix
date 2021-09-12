package br.com.brunoti.filmesflix.presenter

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import androidx.lifecycle.ViewModelProvider
import br.com.brunoti.filmesflix.databinding.ActivityMainBinding
import br.com.brunoti.filmesflix.domain.Movie
import br.com.brunoti.filmesflix.framework.viewmodel.MovieListViewModel

class MainActivity : AppCompatActivity() {

    private val binding by lazy { ActivityMainBinding.inflate(layoutInflater) }

    private lateinit var movieListViewModel: MovieListViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(binding.root)

        movieListViewModel = ViewModelProvider.NewInstanceFactory().create(MovieListViewModel::class.java)
        movieListViewModel.init()
        initObserver()
        loadingVisibility(true)
    }

    private fun initObserver() {
        movieListViewModel.moviesList.observe(this, { list ->
            if (list.isNotEmpty()) {
                populateList(list)
                loadingVisibility(false)
            }
        })
    }

    private fun populateList(list: List<Movie>) {
        binding.moviesList.apply {
            hasFixedSize()
            adapter = MoviesAdapter(list)
        }
    }

    private fun loadingVisibility(isLoading: Boolean) {
        binding.progressBar.visibility = if (isLoading) View.VISIBLE else View.GONE
    }

}