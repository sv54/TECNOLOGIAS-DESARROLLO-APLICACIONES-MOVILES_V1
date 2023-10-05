package es.ua.eps.filmoteca

import android.app.Activity
import android.content.Intent
import android.graphics.Bitmap
import android.os.Bundle
import android.provider.MediaStore
import android.util.Log
import android.widget.Button
import android.widget.ImageView
import androidx.activity.result.contract.ActivityResultContracts
import androidx.appcompat.app.AppCompatActivity
import es.ua.eps.filmoteca.databinding.ActivityFilmEditBinding

class FilmEditActivity : AppCompatActivity() {
    val cameraRequestCode = 1
    lateinit var binding: ActivityFilmEditBinding
    val galleryLauncher = registerForActivityResult(ActivityResultContracts.GetContent()) {
        val galleryUri = it
        try{
            binding.poster.setImageURI(galleryUri)
        }catch(e:Exception){
            e.printStackTrace()
        }

    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityFilmEditBinding.inflate(layoutInflater)
        setContentView(binding.root)


        val titulo = intent.getStringExtra("extraTitulo")
        val genero = intent.getIntExtra("extraGenero",-1)
        val director = intent.getStringExtra("extraDirector")
        val img = intent.getIntExtra("extraImg", 0)
        val formato = intent.getIntExtra("extraFormato", 99)
        val anyo = intent.getStringExtra("extraAnyo")
        val enlaceIMDB = intent.getStringExtra("extraEnlaceIMDB")
        val peliculaPosicion = intent.getIntExtra("extraPeliculaPosicion", 0)


        binding.editTitulo.setText(titulo)
        binding.editDirector.setText(director)
        binding.editAnyo.setText(anyo)
        binding.spinnerFormato.setSelection(formato)
        binding.spinnerGenero.setSelection(genero)
        binding.editEnlaceIMDB.setText(enlaceIMDB)
//        binding.editDirector.text = director

//        binding.editAnyo.text = anyo
//        binding.poster.setImageResource(img)


        binding.seleccionarImg.setOnClickListener {
            galleryLauncher.launch("image/*")
        }

        val camera = findViewById<Button>(R.id.tomarFoto)
        camera.setOnClickListener {
            val intent = Intent("android.media.action.IMAGE_CAPTURE")
            startActivityForResult(intent, cameraRequestCode)
        }

        val guardar = findViewById<Button>(R.id.Guardar)
        guardar.setOnClickListener {
            val pelicula = FilmDataSource.films[peliculaPosicion]
            pelicula.title = binding.editTitulo.text.toString()
            pelicula.director = binding.editDirector.text.toString()
            pelicula.year = binding.editAnyo.text.toString().toInt()
            pelicula.genre = binding.spinnerGenero.selectedItemPosition
            pelicula.format = binding.spinnerFormato.selectedItemPosition
            pelicula.imdbUrl = binding.editEnlaceIMDB.text.toString()

            FilmDataSource.films[peliculaPosicion] = pelicula
            Log.i("My Tag", peliculaPosicion.toString() ?: "sin Titulo")

            setResult(Activity.RESULT_OK)
            finish()
        }

        val volver = findViewById<Button>(R.id.Cancelar)
        volver.setOnClickListener {
            setResult(Activity.RESULT_CANCELED)
            finish()
        }

    }

    fun openCamera() {
        val cameraIntent = Intent(MediaStore.ACTION_IMAGE_CAPTURE)
        startActivityForResult(cameraIntent, cameraRequestCode)
    }

    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
        super.onActivityResult(requestCode, resultCode, data)

        if (requestCode == cameraRequestCode && resultCode == Activity.RESULT_OK) {
            val photo = data?.extras?.get("data") as Bitmap
            val imageView = findViewById<ImageView>(R.id.poster)
            imageView.setImageBitmap(photo)
        }
    }
}