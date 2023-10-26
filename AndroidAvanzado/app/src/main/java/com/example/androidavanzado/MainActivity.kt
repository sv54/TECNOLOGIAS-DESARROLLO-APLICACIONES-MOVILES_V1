package com.example.androidavanzado

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
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

        binding.botonNotificaciones.setOnClickListener{
            val notificacacion = Intent(this@MainActivity, NotificacionesActivity::class.java)
            startActivity(notificacacion)
        }

        binding.botonNotificaciones2.setOnClickListener{
            val notificacacion2 = Intent(this@MainActivity, Notificaciones2Activity::class.java)
            startActivity(notificacacion2)
        }

        binding.botonNotificaciones3.setOnClickListener{
            val notificacacion3 = Intent(this@MainActivity, Notificaciones3Activity::class.java)
            startActivity(notificacacion3)
        }

        binding.botonPantallaTactil.setOnClickListener{
            val pantalla = Intent(this@MainActivity, PantallaTactilYGestosActivity::class.java)
            startActivity(pantalla)
        }

    }


}