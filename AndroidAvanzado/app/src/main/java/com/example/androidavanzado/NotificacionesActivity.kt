package com.example.androidavanzado

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.Gravity
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import android.widget.Toast
import com.google.android.material.snackbar.Snackbar


class NotificacionesActivity : AppCompatActivity() {

    private val tareaList = mutableListOf<String>()
    private var ultimaTarea = ""
    override fun onCreate(savedInstanceState: Bundle?) {
        //ejercicio 1
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_notificaciones)

        val button = findViewById<Button>(R.id.toasting)
        val editText = findViewById<EditText>(R.id.editable2)

        button.setOnClickListener {
            val texto = editText.text.toString()

            if (texto.isNotBlank()) {
                mostrarToastPersonalizado(texto)
                editText.text.clear()
            } else {
                mostrarToastPersonalizado("Escribe un texto")
            }
        }

        //ejercicio 2
        val button2 = findViewById<Button>(R.id.addTarea)

        button2.setOnClickListener {
            val nuevaTarea = editText.text.toString()

            if (nuevaTarea.isNotBlank()) {
                tareaList.add(nuevaTarea)
                actualizarListaTareas()

                mostrarSnackbar()
                Log.i("My tag", tareaList.toString())

                editText.text.clear()
            } else {
                mostrarSnackbar("Escribe un texto")
            }
        }
    }

    private fun actualizarListaTareas() {
        var tareasTextView = findViewById<TextView>(R.id.tareasTextView)
        tareasTextView.text = tareaList.joinToString("\n")
    }

    private fun mostrarSnackbar(mensaje: String = "Tarea añadida") {
        val snackbar = Snackbar.make(
            findViewById(android.R.id.content),
            mensaje,
            Snackbar.LENGTH_LONG
        )
        snackbar.setAction("Deshacer") {
            if (tareaList.isNotEmpty()) {
                ultimaTarea = tareaList.last()
                tareaList.removeAt(tareaList.size - 1)
                actualizarListaTareas()
            }
        }
        snackbar.show()
    }

    private fun mostrarToastPersonalizado(mensaje: String) {
        val inflater: LayoutInflater = layoutInflater
        val layout: View = inflater.inflate(
            R.layout.toast_layout,
            findViewById<ViewGroup>(R.id.custom_toast_container)
        )

        val textoToast = layout.findViewById<TextView>(R.id.textoToast)
        textoToast.text = mensaje

        val toast = Toast(applicationContext)
        toast.setGravity(Gravity.CENTER, 0, 0)
        toast.duration = Toast.LENGTH_SHORT
        toast.view = layout
        toast.show()
    }
}