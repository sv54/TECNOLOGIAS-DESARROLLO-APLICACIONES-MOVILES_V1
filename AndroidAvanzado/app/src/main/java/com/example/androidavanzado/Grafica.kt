package com.example.androidavanzado

import android.content.Context
import android.graphics.Canvas
import android.graphics.Color
import android.graphics.Paint
import android.graphics.RectF
import android.util.AttributeSet
import android.view.View

class Grafica: View {
    private var percentage: Int = 50
    private var colorRed : Int = Color.RED
    private var colorBlue: Int= Color.BLUE

    constructor(context: Context): this (context, null)
    constructor(context: Context, attrs: AttributeSet?) : this(context, attrs, 0)
    constructor(context: Context, attrs: AttributeSet?, defStyleAttr: Int) : super(context, attrs, defStyleAttr) {
        // Obtener los atributos del XML
        val attributes = context.obtainStyledAttributes(attrs, R.styleable.Grafica)
        percentage = attributes.getInt(R.styleable.Grafica_percentage, 50)
        colorRed = attributes.getColor(R.styleable.Grafica_colorRed, Color.RED)
        colorBlue = attributes.getColor(R.styleable.Grafica_colorBlue, Color.BLUE)
        attributes.recycle()
    }

    override fun onMeasure(widthMeasureSpec: Int, heightMeasureSpec: Int) {
        setMeasuredDimension(100, 100)
    }

    override fun onDraw(canvas: Canvas) {
        // Obtener el ancho y el alto de la vista
        val width = measuredWidth
        val height = measuredHeight

        // Dibuja el círculo rojo
        val cx = width / 2f
        val cy = height / 2f
        val radius = Math.min(width, height) / 2f
        canvas.drawCircle(cx, cy, radius, Paint().apply {
            color = colorRed
            style = Paint.Style.FILL
        })

        // Dibuja el círculo azul
        val arcAngle = (360f * percentage) / 100f
        canvas.drawArc(
            RectF(cx - radius, cy - radius, cx + radius, cy + radius),
            0f,
            arcAngle,
            true,
            Paint().apply {
                color = colorBlue
                style = Paint.Style.FILL
            }
        )
    }

    fun setPercentage(percentage: Int) {
        this.percentage = percentage
        invalidate()
    }

}

private fun <TypedArray> TypedArray.getColor(graficaColorred: IntArray?, red: Int): Int {
    val color = if (graficaColorred == null) red else graficaColorred[0]
    return color
}

private fun <TypedArray> TypedArray.getInt(graficaPercentage: IntArray?, i: Int): Int {
    val percentage = if (graficaPercentage == null) i else graficaPercentage[0]
    return percentage
}
