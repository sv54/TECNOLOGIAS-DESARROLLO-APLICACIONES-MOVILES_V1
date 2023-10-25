package com.example.androidavanzado

import android.content.DialogInterface
import android.graphics.Color
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.TypedValue
import android.widget.Button
import android.widget.TextView
import androidx.appcompat.app.AlertDialog
import org.w3c.dom.Text

class Notificaciones2Activity : AppCompatActivity() {

    lateinit var textView: TextView
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_notificaciones2)
        var colorButton = findViewById<Button>(R.id.color)
        var sizeButton = findViewById<Button>(R.id.tamano)
        textView = findViewById<TextView>(R.id.textitos)
        colorButton.setOnClickListener {
            mostrarDialogoColor()
        }

        sizeButton.setOnClickListener {
            mostrarDialogoTamaño()
        }
    }

    private fun mostrarDialogoColor() {
        val colores = arrayOf("Blanco y Negro", "Negro y Blanco", "Negro y Verde")

        val builder = AlertDialog.Builder(this)
        builder.setTitle("Selecciona un esquema de colores")
        builder.setItems(colores) { dialog: DialogInterface, which: Int ->
            when (which) {
                0 -> {
                    textView.setTextColor(Color.BLACK)
                    textView.setBackgroundColor(Color.WHITE)
                }
                1 -> {
                    textView.setTextColor(resources.getColor(android.R.color.white))
                    textView.setBackgroundColor(Color.BLACK)
                }
                2 -> {
                    textView.setTextColor(Color.GREEN)
                    textView.setBackgroundColor(Color.BLACK)

                }
            }
            dialog.dismiss()
        }
        builder.create().show()
    }

    private fun mostrarDialogoTamaño() {
        val tamanos = arrayOf("Pequeño", "Normal", "Grande")

        val builder = AlertDialog.Builder(this)
        builder.setTitle("Selecciona un tamaño de texto")
        builder.setItems(tamanos) { dialog: DialogInterface, which: Int ->
            when (which) {
                0 -> textView.setTextSize(TypedValue.COMPLEX_UNIT_SP, 8f)
                1 -> textView.setTextSize(TypedValue.COMPLEX_UNIT_SP, 12f)
                2 -> textView.setTextSize(TypedValue.COMPLEX_UNIT_SP, 20f)
            }
            dialog.dismiss()
        }
        builder.create().show()
    }
}