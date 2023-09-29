package es.ua.eps.filmoteca

import android.app.Activity
import android.content.Intent
import android.net.Uri
import android.os.Build
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import androidx.activity.result.ActivityResult
import androidx.activity.result.contract.ActivityResultContracts

class FilmDataActivity : AppCompatActivity() {

    private val CODIGO_EDITAR = 1

    private val startForResult =
        registerForActivityResult(
            ActivityResultContracts.StartActivityForResult()) { result: ActivityResult ->
            onActivityResult(CODIGO_EDITAR, result.resultCode, result.data)
        }
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_film_data)

        val pelicula = intent.getStringExtra("EXTRA_FILM_TITLE")
        val texto = findViewById<TextView>(R.id.DatosPelicula)
        texto.setText("Pelicula: "+ pelicula)

        val relacionada = findViewById<Button>(R.id.verPeliRelacionada)
        relacionada.setOnClickListener {
            //data.putExtra("EXTRA_FILM_TITLE", pelicula)
            val viewIntent = Intent(
                Intent.ACTION_VIEW,
                Uri.parse("https://www.imdb.com"))
            startActivity(viewIntent)
            //startActivity(data)

        }

        val editar = findViewById<Button>(R.id.editar)
        editar.setOnClickListener {
            val data = Intent(this@FilmDataActivity, FilmEditActivity::class.java)
            if(Build.VERSION.SDK_INT >= 30) {
                startForResult.launch(data)
            }
            else {
                @Suppress("DEPRECATION")
                startActivityForResult(data, CODIGO_EDITAR)
            }

        }

        val volver = findViewById<Button>(R.id.volverAPrincipal)
        volver.setOnClickListener {
            val volverIntent = Intent(this@FilmDataActivity, FilmListActivity::class.java)
            volverIntent.flags = Intent.FLAG_ACTIVITY_CLEAR_TOP
            startActivity(volverIntent)
        }
    }

    override fun onActivityResult(requestCode: Int, resultCode: Int,
                                  data: Intent?) {
        super.onActivityResult(requestCode, resultCode, data)

        when (requestCode) {
            CODIGO_EDITAR -> if (resultCode == Activity.RESULT_OK) {
                val texto = findViewById<TextView>(R.id.DatosPelicula)
                texto.setText("Pelicula editada")
            } else if (resultCode == Activity.RESULT_CANCELED) {
                val texto = findViewById<TextView>(R.id.DatosPelicula)
                texto.setText("Edicion cancelada")
            }
        }
    }
}