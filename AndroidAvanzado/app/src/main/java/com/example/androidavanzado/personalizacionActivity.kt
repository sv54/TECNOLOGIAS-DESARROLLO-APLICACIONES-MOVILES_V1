package com.example.androidavanzado

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.SeekBar

class personalizacionActivity : AppCompatActivity() {

    private lateinit var grafica: Grafica
    private lateinit var seekBar: SeekBar
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_personalizacion)

        // Obtener la gráfica
//        grafica = findViewById(R.id.grafica)
//
        // Obtener el SeekBar
        seekBar = findViewById(R.id.seekbar)
        seekBar.max = 100

        // Escuchar los cambios del SeekBar
        seekBar.setOnSeekBarChangeListener(object : SeekBar.OnSeekBarChangeListener {
            override fun onProgressChanged(seekBar: SeekBar, progress: Int, fromUser: Boolean) {
                grafica.setPercentage(progress)
            }

            override fun onStartTrackingTouch(seekBar: SeekBar) {}

            override fun onStopTrackingTouch(seekBar: SeekBar) {}
        })
    }
}