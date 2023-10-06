package es.ua.eps.filmoteca

import android.content.Intent
import android.net.Uri
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.MenuItem
import android.widget.Button
import android.widget.Toast

class AboutActivity : AppCompatActivity() {

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        // Si el usuario hace clic en el botón de home
        if (item.itemId == android.R.id.home) {
            // Volvemos a la actividad principal
            val intent = Intent(this, FilmListActivity::class.java)
            intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP)
            startActivity(intent)
        }

        return super.onOptionsItemSelected(item)
    }
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_about)


        val actionBar = supportActionBar
        actionBar?.setDisplayHomeAsUpEnabled(true)

        val button = findViewById<Button>(R.id.button)
        button.setOnClickListener {
            //Toast.makeText(this, R.string.textError, Toast.LENGTH_LONG).show()
            val viewIntent = Intent(
                Intent.ACTION_VIEW,
                Uri.parse("http://www.google.com"))
            startActivity(viewIntent)

        }
        val button2 = findViewById<Button>(R.id.button2)
        button2.setOnClickListener {
            //Toast.makeText(this, R.string.textError, Toast.LENGTH_LONG).show()
            val sendIntent = Intent(
                Intent.ACTION_SENDTO,
                Uri.parse("mailto:sergswa7@gmail.com")
            )
            startActivity(sendIntent)

        }
        val button3 = findViewById<Button>(R.id.button3)
        button3.setOnClickListener {
            finish()
        }

    }
}