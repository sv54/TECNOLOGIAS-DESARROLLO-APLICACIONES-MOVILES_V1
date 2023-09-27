package es.ua.eps.filmoteca

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.Toast

class AboutActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_about)

        val button = findViewById<Button>(R.id.button)
        button.setOnClickListener {
            Toast.makeText(this, R.string.textError, Toast.LENGTH_LONG).show()

        }
        val button2 = findViewById<Button>(R.id.button2)
        button2.setOnClickListener {
            Toast.makeText(this, R.string.textError, Toast.LENGTH_LONG).show()

        }
        val button3 = findViewById<Button>(R.id.button3)
        button3.setOnClickListener {
            Toast.makeText(this, R.string.textError, Toast.LENGTH_LONG).show()

        }

    }
}