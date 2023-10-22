package com.example.androidavanzado

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.TextView
import androidx.core.content.ContextCompat

class drawableActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_drawable)

        val drawable = findViewById<TextView>(R.id.drawable)

        val rec = getDrawable( R.drawable.ej1)
    }
}