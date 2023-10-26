package com.example.androidavanzado

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.TextView
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.launch

class CorrutinasActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_corrutinas)

        val tvCrono = findViewById<TextView>(R.id.tvCronoCorrutinas)

        GlobalScope.launch(Dispatchers.IO){
            var t = 10
            do {
                launch(Dispatchers.Main){
                    tvCrono.text = "Contador: $t"
                }
                Thread.sleep(1000)
                t--
            } while (t > 0)
            launch(Dispatchers.Main){
                tvCrono.text = "Contador terminado"
            }
        }



    }
}