package es.ua.eps.filmoteca

import android.app.Activity
import android.content.Intent
import android.content.pm.PackageManager
import android.graphics.Bitmap
import android.os.Bundle
import android.provider.MediaStore
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
            binding.imageView4.setImageURI(galleryUri)
        }catch(e:Exception){
            e.printStackTrace()
        }

    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
binding = ActivityFilmEditBinding.inflate(layoutInflater)
        setContentView(binding.root)
        binding.seleccionarImg.setOnClickListener {
            galleryLauncher.launch("image/*")
        }



        //if (ContextCompat.checkSelfPermission(this, Manifest.permission.CAMERA) != PackageManager.PERMISSION_GRANTED) {
        //    ActivityCompat.requestPermissions(this, arrayOf(Manifest.permission.CAMERA), cameraRequestCode)
        //} else {
        //    openCamera()
        //}

        val camera = findViewById<Button>(R.id.tomarFoto)
        camera.setOnClickListener {
            val intent = Intent("android.media.action.IMAGE_CAPTURE")
            startActivityForResult(intent, cameraRequestCode)
        }

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

    fun openCamera() {
        val cameraIntent = Intent(MediaStore.ACTION_IMAGE_CAPTURE)
        startActivityForResult(cameraIntent, cameraRequestCode)
    }

    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
        super.onActivityResult(requestCode, resultCode, data)

        if (requestCode == cameraRequestCode && resultCode == Activity.RESULT_OK) {
            val photo = data?.extras?.get("data") as Bitmap
            val imageView = findViewById<ImageView>(R.id.imageView4)
            imageView.setImageBitmap(photo)
        }
    }
}