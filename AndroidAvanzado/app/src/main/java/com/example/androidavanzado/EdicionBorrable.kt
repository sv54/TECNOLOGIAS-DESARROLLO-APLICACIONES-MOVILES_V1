package com.example.androidavanzado

import android.content.Context
import android.util.AttributeSet
import android.view.LayoutInflater
import android.widget.Button
import android.widget.EditText
import android.widget.LinearLayout

class EdicionBorrable : LinearLayout {
    var editText: EditText? = null
    var button: Button? = null

    constructor(ctx: Context?) : super(ctx) {
        inicializar()
    }
    constructor(ctx: Context?, atts: AttributeSet?)
            : super(ctx, atts) {
        inicializar()
    }
    private fun inicializar() {
        // Creamos la interfaz a partir del layout
        val li = context.getSystemService(Context.LAYOUT_INFLATER_SERVICE) as LayoutInflater
        li.inflate(R.layout.edicion_borrable_layout, this, true)

        // Obtenemos las referencias a las vistas hijas
        editText = findViewById(R.id.editText) as EditText
        button = findViewById(R.id.button) as Button

        editText = findViewById(R.id.editText) as EditText
        button = findViewById(R.id.button) as Button

        button!!.setOnClickListener { editText!!.setText("") }
    }
}
