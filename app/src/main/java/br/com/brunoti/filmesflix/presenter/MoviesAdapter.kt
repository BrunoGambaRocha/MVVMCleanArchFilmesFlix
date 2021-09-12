package br.com.brunoti.filmesflix.presenter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.recyclerview.widget.RecyclerView
import br.com.brunoti.filmesflix.R
import coil.load
import br.com.brunoti.filmesflix.databinding.MovieItemLayoutBinding
import br.com.brunoti.filmesflix.domain.Movie

class MoviesAdapter(private val moviesList: List<Movie>): RecyclerView.Adapter<MoviesViewHolder>() {

    private lateinit var binding: MovieItemLayoutBinding

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MoviesViewHolder {
        val inflater = LayoutInflater.from(parent.context)
        binding = MovieItemLayoutBinding.inflate(inflater, parent, false)

        return MoviesViewHolder(binding.root)
    }

    override fun onBindViewHolder(holder: MoviesViewHolder, position: Int) {
        holder.itemView.apply {
            setOnClickListener(View.OnClickListener { Toast.makeText(context, moviesList[position].descricao, Toast.LENGTH_SHORT).show() }  )
            binding.movieTitle.text = moviesList[position].titulo
            binding.movieImage.load(moviesList[position].imagem) {
                placeholder(R.drawable.ic_image)
                fallback(R.drawable.ic_image)
            }
        }
    }

    override fun getItemCount(): Int = moviesList.size

}