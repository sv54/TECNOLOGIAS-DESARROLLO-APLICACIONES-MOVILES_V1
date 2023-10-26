package com.example.androidavanzado

import android.os.AsyncTask
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.TextView

class AsyncActivity : AppCompatActivity() {
    lateinit var tvCrono: TextView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_async)

        tvCrono = findViewById(R.id.tvCronoAsync)
        val asyncVal = AsyncTarea().execute()

    }
    inner class AsyncTarea: AsyncTask<Int, Int, String>() {

        override fun doInBackground(vararg p0: Int?): String? {

            var t = 10
            do {
                publishProgress(t)
                Thread.sleep(1000)
                t--
            } while (t > 0)

            return "Contador terminado"

        }

        override fun onProgressUpdate(vararg values: Int?) {
            val value = values[0] ?: 0

            tvCrono.text = "Contador: $value"
        }

        override fun onPostExecute(result: String) {
            tvCrono.text = result
        }

    }

}