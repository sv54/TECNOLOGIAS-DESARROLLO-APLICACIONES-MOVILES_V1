package com.example.androidavanzado

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.TextView

class ThreadActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_thread)
        val tvCrono = findViewById<TextView>(R.id.tvCronoThread)
        tvCrono.text = "hola"

        Thread{
            var t = 10
            do {
                tvCrono.post{
                    tvCrono.text = "Contador: $t"
                }
                Thread.sleep(1000)
                t--
            } while (t > 0)
            tvCrono.post{
                tvCrono.text = "Contador terminado"
            }
        }.start()

    }
}