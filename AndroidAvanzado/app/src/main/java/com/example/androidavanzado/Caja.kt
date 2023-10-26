package com.example.androidavanzado

import android.content.Context
import android.graphics.Canvas
import android.graphics.Color
import android.graphics.Paint
import android.util.Log
import android.view.GestureDetector
import android.view.MotionEvent
import android.view.View
import androidx.core.view.GestureDetectorCompat

class Caja(context: Context) : View(context), GestureDetector.OnGestureListener {
    private val paint = Paint()
    var rectX = 0f
    var rectY = 0f
    private var initialX = 0f
    private var initialY = 0f

    private var colorRed = true
    private var isMoving = false

    private val detector = GestureDetectorCompat(context, this)

    init {
        paint.color = Color.RED
    }

    override fun onDraw(canvas: Canvas) {
        Log.i("1", "hola")
        super.onDraw(canvas)
        canvas.drawRect(rectX, rectY, rectX + 50f, rectY + 50f, paint)
        if (initialX != 0f && initialY != 0f) {
            canvas.drawLine(initialX, initialY, rectX + (50 / 2), rectY + (50 / 2), paint)
        }

    }

    override fun onTouchEvent(event: MotionEvent): Boolean {
        detector.onTouchEvent(event)
//        if(event!= null && event.action == MotionEvent.ACTION_DOWN) {
//            return event.x >= rectX && event.x <= rectX + 50f && event.y >= rectY && event.y <= rectY + 50f
//
//        }
//        if(event!= null && event.action == MotionEvent.ACTION_MOVE) {
//            rectX = event.x
//            rectY = event.y
//            this.invalidate()
//        }
        return true
    }

    override fun onDown(event: MotionEvent): Boolean {
        if(event.x >= rectX && event.x <= rectX + 50f && event.y >= rectY && event.y <= rectY + 50f) {
            rectX = event.x
            rectY = event.y
            isMoving = true
        }
        else{
            isMoving = false
        }
        return true
    }

    override fun onShowPress(p0: MotionEvent) {
    }

    override fun onSingleTapUp(event: MotionEvent): Boolean {
        if(event.x >= rectX && event.x <= rectX + 50f && event.y >= rectY && event.y <= rectY + 50f) {
            if(colorRed) {
                paint.color = Color.BLUE
                colorRed = false
            }
            else{
                paint.color = Color.RED
                colorRed = true
            }
        }
        invalidate()

        return true
    }

    override fun onScroll(p0: MotionEvent, p1: MotionEvent, p2: Float, p3: Float): Boolean {
        if(isMoving) {
            rectX = rectX - p2
            rectY = rectY - p3
            invalidate()
        }
        return true
    }

    override fun onLongPress(p0: MotionEvent) {
        TODO("Not yet implemented")
    }

    override fun onFling(e1: MotionEvent, e2: MotionEvent, velocityX: Float, velocityY: Float): Boolean {
        if (isMoving) {
            initialX = e1?.x!!
            initialY = e1?.y!!
            invalidate()
            rectX = e2.x - (50 / 2)
            rectY = e2.y - (50 / 2)
        }

        return true
    }

}