package es.ua.eps.filmoteca

import android.app.Activity
import android.content.Intent
import android.net.Uri
import android.os.Build
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.Button
import android.widget.TextView
import androidx.activity.result.ActivityResult
import androidx.activity.result.contract.ActivityResultContracts
import es.ua.eps.filmoteca.databinding.ActivityFilmDataBinding
import es.ua.eps.filmoteca.databinding.ActivityFilmEditBinding

class FilmDataActivity : AppCompatActivity() {

    private val CODIGO_EDITAR = 1

    private val startForResult =
        registerForActivityResult(
            ActivityResultContracts.StartActivityForResult()) { result: ActivityResult ->
            onActivityResult(CODIGO_EDITAR, result.resultCode, result.data)
        }

    lateinit var binding: ActivityFilmDataBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityFilmDataBinding.inflate(layoutInflater)
        setContentView(binding.root)


//        val pelicula = intent.getStringExtra("EXTRA_FILM_TITLE")
//        val texto = findViewById<TextView>(R.id.DatosPelicula)
        val titulo = intent.getStringExtra("extraTitulo")
        val genero = intent.getIntExtra("extraGenero",-1)
        val director = intent.getStringExtra("extraDirector")
        val img = intent.getIntExtra("extraImg", 0)
        val formato = intent.getIntExtra("extraFormato", 99)
        val anyo = intent.getStringExtra("extraAnyo")
        val enlaceIMDB = intent.getStringExtra("extraEnlaceIMDB")
        val peliculaPosicion = intent.getIntExtra("extraPeliculaPosicion", 0)

        val f = Film()

        val generoStr = f.obtenerGeneroNombre(genero)
        val formatoStr = f.obtenerFormatoNombre(formato)


        binding.TituloPelicula!!.text = titulo
        binding.DirectorStr.text = director
        binding.genero!!.text = generoStr
        binding.formato!!.text = formatoStr
        binding.anyoStr.text = anyo
        binding.portada.setImageResource(img)


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
            //val intent = Intent(this, FilmDataActivity::class.java)
            data.putExtra("extraTitulo", titulo)
            data.putExtra("extraDirector", director)
            data.putExtra("extraAnyo", anyo)
            data.putExtra("extraImg", img)
            data.putExtra("extraFormato", formato)
            data.putExtra("extraGenero", genero)
            data.putExtra("extraEnlaceIMDB", enlaceIMDB)
            data.putExtra("extraPeliculaPosicion", peliculaPosicion)
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
