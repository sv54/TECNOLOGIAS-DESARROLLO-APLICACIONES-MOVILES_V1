package com.example.androidavanzado

import android.graphics.Paint
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.GestureDetector
import android.view.MotionEvent
import android.widget.FrameLayout
import androidx.core.view.GestureDetectorCompat

class PantallaTactilYGestosActivity : AppCompatActivity() {

    var customBox: Caja? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val frameLayout = FrameLayout(this)
        customBox = Caja(this)

        frameLayout.addView(customBox)
        setContentView(frameLayout)


    }

}