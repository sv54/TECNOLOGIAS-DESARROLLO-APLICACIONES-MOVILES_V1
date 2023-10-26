package com.example.androidavanzado

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button

class EstilosTemasActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_estilos_temas)

        val boton = findViewById<Button>(R.id.continuar)
        boton.setOnClickListener{
            val estiloContinuar = Intent(this@EstilosTemasActivity, EstilosActivity2::class.java)

            startActivity(estiloContinuar)
        }
    }
}