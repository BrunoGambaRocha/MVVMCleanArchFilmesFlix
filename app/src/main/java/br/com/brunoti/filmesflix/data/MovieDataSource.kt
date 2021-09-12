package br.com.brunoti.filmesflix.data

import br.com.brunoti.filmesflix.domain.Movie

interface MovieDataSource {

    fun getAllMovies(): List<Movie>

}