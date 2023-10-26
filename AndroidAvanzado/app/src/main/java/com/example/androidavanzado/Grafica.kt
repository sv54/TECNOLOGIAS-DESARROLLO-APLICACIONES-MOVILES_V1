package com.example.androidavanzado

import android.content.Context
import android.graphics.Canvas
import android.graphics.Color
import android.graphics.Paint
import android.util.AttributeSet
import android.view.View

class Grafica(context: Context, attrs: AttributeSet) : View(context, attrs) {
    private var porcentaje: Int = 50

    private val paintRojo = Paint(Paint.ANTI_ALIAS_FLAG)
    private val paintAzul = Paint(Paint.ANTI_ALIAS_FLAG)

    init {
        paintRojo.color = Color.RED
        paintAzul.color = Color.BLUE
    }

    override fun onDraw(canvas: Canvas) {
        super.onDraw(canvas)
        val anchura = width.toFloat()
        val altura = height.toFloat()
        val angulo = (porcentaje / 100f) * 360
        canvas.drawArc(0f, 0f, anchura, altura, angulo, 360 - angulo, true, paintAzul)
        canvas.drawArc(0f, 0f, anchura, altura, 0f, angulo, true, paintRojo)
    }

    fun setPercentage(percentage: Int) {
        this.porcentaje = percentage
        //pintarlo otra vez
        invalidate()
    }
    override fun onMeasure(widthMeasureSpec: Int, heightMeasureSpec: Int) {
        val desiredSize = 100
        setMeasuredDimension(
            resolveSize(desiredSize, widthMeasureSpec),
            resolveSize(desiredSize, heightMeasureSpec)
        )
    }



}


