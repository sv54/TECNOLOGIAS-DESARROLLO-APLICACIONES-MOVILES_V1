package es.ua.eps.filmoteca

import android.content.Intent
import android.os.Bundle
import android.view.MenuItem
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import es.ua.eps.filmoteca.databinding.ActivityFilmEditBinding
import es.ua.eps.filmoteca.databinding.ActivityFilmRecyclerListBinding

class FilmRecyclerListActivity : AppCompatActivity() {
    lateinit var binding: ActivityFilmRecyclerListBinding

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        // Si el usuario hace clic en el botón de home
        if (item.itemId == android.R.id.home) {
            // Volvemos a la actividad principal
            val intent = Intent(this, FilmListActivity::class.java)
            intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP)
            startActivity(intent)
        }

        return super.onOptionsItemSelected(item)
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityFilmRecyclerListBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val actionBar = supportActionBar
        actionBar?.setDisplayHomeAsUpEnabled(true)

        var adapter = PeliculasRecyclerAdapter(FilmDataSource.films)
        binding.lista.layoutManager = LinearLayoutManager(this)
        binding.lista.setAdapter(adapter)

        adapter.setOnItemClickListener { pelicula, position ->
            Toast.makeText(
                this@FilmRecyclerListActivity,
                "Pulsado " + pelicula.title, Toast.LENGTH_LONG
            ).show()

            val intent = Intent(this, FilmDataActivity::class.java)
            intent.putExtra("extraPeliculaPosicion", position)
            intent.putExtra("extraTitulo", pelicula.title)
            intent.putExtra("extraDirector", pelicula.director)
            intent.putExtra("extraAnyo", pelicula.year.toString())
            intent.putExtra("extraImg", pelicula.imageResId)
            intent.putExtra("extraFormato", pelicula.format)
            intent.putExtra("extraGenero", pelicula.genre)
            intent.putExtra("extraEnlaceIMDB", pelicula.imdbUrl)

            startActivity(intent)

        }

    }
}