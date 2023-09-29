package es.ua.eps.filmoteca

import android.app.Activity
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button

class FilmEditActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_film_edit)

        val volver = findViewById<Button>(R.id.Guardar)
        volver.setOnClickListener {
            setResult(Activity.RESULT_OK)
            finish()
        }

        val guardar = findViewById<Button>(R.id.Cancelar)
        guardar.setOnClickListener {
            setResult(Activity.RESULT_CANCELED)
            finish()
        }
    }
}