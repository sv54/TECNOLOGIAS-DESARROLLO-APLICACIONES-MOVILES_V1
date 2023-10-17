package es.ua.eps.filmoteca

import android.content.Intent
import android.os.Bundle
import android.util.Log
import android.view.View
import android.widget.Button
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity

class MainActivity : AppCompatActivity(),FilmListFragment.OnItemSelectedListener {
    //...
    override fun onItemSelected(position: Int) {
        var detalleFragment = supportFragmentManager
            .findFragmentById(R.id.fragmentContainerView2) as FilmDataFragment?
        Log.d("Tag", "Clicked item at position: $position")

        if (detalleFragment != null) {
            // Tipo estático: actualizamos directamente el fragmento
            detalleFragment.setDetalleItem(position)
        } else {
            // Tipo dinámico: hacemos transición al nuevo fragmento
            detalleFragment = FilmDataFragment()
            val args = Bundle()
            args.putInt(FilmDataFragment.PARAM_POSICION, position)
            detalleFragment.arguments = args

            val t = supportFragmentManager.beginTransaction()
            t.replace(R.id.fragmentContainerView3, detalleFragment)
            t.addToBackStack(null)
            t.commit()
        }
    }
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        Toast.makeText(this, "welcome", Toast.LENGTH_SHORT).show()
        Log.i("Tag", "welcome")

        // Comprueba si estamos usando el layout dinámico
        if (findViewById<View?>(R.id.fragmentContainerView3) != null) {
            // Si se está restaurando, no hace falta cargar el fragmento
            if (savedInstanceState != null) return

            // Creamos el fragmento
            val ppalFragment = FilmListFragment()

            // Pasamos los extras del intent al fragmento
            ppalFragment.arguments = intent.extras

            // Añadimos el fragmento al contenedor
            supportFragmentManager.beginTransaction()
                .add(R.id.fragmentContainerView3, ppalFragment).commit()
        }


    }
}
