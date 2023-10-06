package es.ua.eps.filmoteca

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import es.ua.eps.filmoteca.databinding.ActivityFilmEditBinding
import es.ua.eps.filmoteca.databinding.ActivityFilmRecyclerviewlistBinding

class FilmRecyclerListActivity : AppCompatActivity() {
    lateinit var binding: ActivityFilmRecyclerviewlistBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityFilmRecyclerviewlistBinding.inflate(layoutInflater)
        setContentView(binding.root)
//        setContentView(R.layout.activity_film_recyclerViewList)

        var adapter = PeliculasRecyclerAdapter(FilmDataSource.films)
        binding.a1.setAdapter(adapter)
    }
}