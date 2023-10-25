package com.example.androidavanzado

import android.content.Context
import android.graphics.Canvas
import android.graphics.Color
import android.graphics.Paint
import android.util.AttributeSet
import android.view.View

class Grafica(context: Context, attrs: AttributeSet) : View(context, attrs) {
    private var percentage: Int = 50
    private val colorRed = Color.RED
    private val colorBlue = Color.BLUE
    private val paintRed = Paint(Paint.ANTI_ALIAS_FLAG)
    private val paintBlue = Paint(Paint.ANTI_ALIAS_FLAG)

    init {
        paintRed.color = colorRed
        paintBlue.color = colorBlue
    }

    override fun onDraw(canvas: Canvas) {
        super.onDraw(canvas)

        val viewWidth = width.toFloat()
        val viewHeight = height.toFloat()

        val angle = (percentage / 100f) * 360

        canvas.drawArc(0f, 0f, viewWidth, viewHeight, angle, 360 - angle, true, paintBlue)

        canvas.drawArc(0f, 0f, viewWidth, viewHeight, 0f, angle, true, paintRed)
    }
    override fun onMeasure(widthMeasureSpec: Int, heightMeasureSpec: Int) {
        val desiredSize = 100
        setMeasuredDimension(
            resolveSize(desiredSize, widthMeasureSpec),
            resolveSize(desiredSize, heightMeasureSpec)
        )
    }
    fun setPercentage(percentage: Int) {
        this.percentage = percentage
        invalidate()
    }


}


