package com.example.androidavanzado

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.LayoutInflater
import com.example.androidavanzado.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.botonDrawables.setOnClickListener{
            val drawable = Intent(this@MainActivity, drawableActivity::class.java)
            startActivity(drawable)
        }

        binding.botonPersonalizacion.setOnClickListener{
            val personalizacion = Intent(this@MainActivity, personalizacionActivity::class.java)
            startActivity(personalizacion)
        }


    }


}