package br.com.brunoti.filmesflix.usecase

import br.com.brunoti.filmesflix.data.MovieRepository

class MoviesListUseCase(private val movieRepository: MovieRepository) {

    operator fun invoke() = movieRepository.getAllMoviesFromDataSource()

}