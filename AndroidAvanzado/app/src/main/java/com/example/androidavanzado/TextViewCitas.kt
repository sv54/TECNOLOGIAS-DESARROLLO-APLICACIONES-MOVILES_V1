package com.example.androidavanzado

import android.content.Context
import android.util.AttributeSet
import android.view.MotionEvent
import android.widget.TextView
import androidx.appcompat.widget.AppCompatTextView

class TextViewCitas : AppCompatTextView {
    constructor(context: Context?, attrs: AttributeSet?, defStyle: Int)
            : super(context!!, attrs, defStyle) {}
    constructor(context: Context?, attrs: AttributeSet?) : super(context!!, attrs) {}
    constructor(context: Context?) : super(context!!) {}

    val citasFamosas = arrayOf(
        "El éxito no es la clave de la felicidad. La felicidad es la clave del éxito. Si te gusta lo que haces, tendrás éxito.",
        "La vida es como una bicicleta. Para mantener el equilibrio, debes seguir moviéndote.",
        "El éxito es aprender a ir de fracaso en fracaso sin perder el entusiasmo.",
        "No hay nada imposible para el hombre que tenga la voluntad de intentarlo.",
        "El futuro pertenece a aquellos que creen en la belleza de sus sueños.",
        "La vida no es un problema para ser resuelto, sino una realidad para ser experimentada.",
        "No hay nada imposible para una mente decidida.",
        "La vida es lo que ocurre cuando estás ocupado haciendo otros planes.",
        "La vida es un viaje, no un destino.",
        "El amor es la fuerza más poderosa del mundo.",
    )

    override fun onTouchEvent(event: MotionEvent?): Boolean {
        val citaAleatoria = citasFamosas.random()
        text = citaAleatoria
        return super.onTouchEvent(event)
    }
}