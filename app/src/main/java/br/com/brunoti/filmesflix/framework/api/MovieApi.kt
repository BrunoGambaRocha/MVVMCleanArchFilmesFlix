package br.com.brunoti.filmesflix.framework.api

import br.com.brunoti.filmesflix.domain.Movie
import retrofit2.Call
import retrofit2.http.GET

interface MovieApi {

    @GET("BrunoGambaRocha/MVVMCleanArchFilmesFlix/master/JSON/moviesList")
    fun getAllMovies(): Call<List<Movie>>

}