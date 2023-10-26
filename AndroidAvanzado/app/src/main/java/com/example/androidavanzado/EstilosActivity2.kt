package com.example.androidavanzado

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button

class EstilosActivity2 : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_estilos2)

        val boton = findViewById<Button>(R.id.volver)
        boton.setOnClickListener{
            finish()
        }
    }
}