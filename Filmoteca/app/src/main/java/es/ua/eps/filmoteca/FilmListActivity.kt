package es.ua.eps.filmoteca

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.View
import android.widget.AdapterView
import android.widget.Button
import android.widget.ListView

class FilmListActivity : AppCompatActivity() {

    val EXTRA_FILM_TITLE = "EXTRA_FILM_TITLE";

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_film_list)

        var adaptador = PeliculasArrayAdapter(this, R.layout.item_pelicula ,FilmDataSource.films)
        var lista = findViewById<ListView>(R.id.pelis)
        lista.adapter = adaptador

        lista.setOnItemClickListener { parent: AdapterView<*>, view: View, position: Int, id: Long ->
            val selectedFilm = FilmDataSource.films[position]

            val intent = Intent(this, FilmDataActivity::class.java)
            intent.putExtra("extraPeliculaPosicion", position)
            intent.putExtra("extraTitulo", selectedFilm.title)
            intent.putExtra("extraDirector", selectedFilm.director)
            intent.putExtra("extraAnyo", selectedFilm.year.toString())
            intent.putExtra("extraImg", selectedFilm.imageResId)
            intent.putExtra("extraFormato", selectedFilm.format)
            intent.putExtra("extraGenero", selectedFilm.genre)
            intent.putExtra("extraEnlaceIMDB", selectedFilm.imdbUrl)

            startActivity(intent)
        }


        val peliA = findViewById<Button>(R.id.peliA)
        peliA.setOnClickListener {
            val data = Intent(this@FilmListActivity, FilmDataActivity::class.java)
            data.putExtra(EXTRA_FILM_TITLE, "A")
            startActivity(data)
        }

        val peliB = findViewById<Button>(R.id.peliB)
        peliB.setOnClickListener {
            val data = Intent(this@FilmListActivity, FilmDataActivity::class.java)
            data.putExtra(EXTRA_FILM_TITLE, "B")
            startActivity(data)
        }

        val recycler = findViewById<Button>(R.id.Recycler)
        recycler.setOnClickListener {
            val data = Intent(this@FilmListActivity, FilmRecyclerListActivity::class.java)
            startActivity(data)
        }

        val acercaDe = findViewById<Button>(R.id.acercaDe)
        acercaDe.setOnClickListener {
            val data = Intent(this@FilmListActivity, AboutActivity::class.java)
            startActivity(data)
        }
    }
}