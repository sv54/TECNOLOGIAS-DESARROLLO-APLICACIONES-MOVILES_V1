package es.ua.eps.filmoteca

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button

class FilmListActivity : AppCompatActivity() {

    val EXTRA_FILM_TITLE = "EXTRA_FILM_TITLE";

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_film_list)

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

        val acercaDe = findViewById<Button>(R.id.acercaDe)
        acercaDe.setOnClickListener {
            val data = Intent(this@FilmListActivity, AboutActivity::class.java)
            startActivity(data)
        }
    }
}