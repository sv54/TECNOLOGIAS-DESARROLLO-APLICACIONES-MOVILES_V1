package com.example.androidavanzado

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.TextView

class EjemploHilosActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_ejemplo_hilos)

        val threadButton = findViewById<Button>(R.id.thread)
        val asyncButton= findViewById<Button>(R.id.async)
        val corrutinasButton= findViewById<Button>(R.id.corrutinas)

        threadButton.setOnClickListener{
            val hilos = Intent(this@EjemploHilosActivity, ThreadActivity::class.java)
            startActivity(hilos)
        }

        asyncButton.setOnClickListener{
            val hilos2 = Intent(this@EjemploHilosActivity, AsyncActivity::class.java)
            startActivity(hilos2)
        }

        corrutinasButton.setOnClickListener{
            val hilos3 = Intent(this@EjemploHilosActivity, CorrutinasActivity::class.java)
            startActivity(hilos3)
        }
    }
}