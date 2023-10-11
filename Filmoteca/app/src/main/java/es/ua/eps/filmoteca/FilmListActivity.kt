package es.ua.eps.filmoteca

import android.content.Intent
import android.graphics.Color
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.ActionMode
import android.view.ContextMenu
import android.view.Gravity
import android.view.Menu
import android.view.MenuItem
import android.view.View
import android.widget.AbsListView
import android.widget.AdapterView
import android.widget.Button
import android.widget.ImageView
import android.widget.ListView
import androidx.appcompat.widget.Toolbar

class FilmListActivity : AppCompatActivity() {

    val EXTRA_FILM_TITLE = "EXTRA_FILM_TITLE";
    companion object {
        private val ID_MENU_ADDFILM = Menu.FIRST
        private val ID_MENU_ABOUTUS = Menu.FIRST + 1
    }

    var adaptador: PeliculasArrayAdapter? = null

    override fun onCreateOptionsMenu(menu: Menu): Boolean {
        super.onCreateOptionsMenu(menu)
        // Identificador de grupo
        val groupId = Menu.NONE
        val itemId = ID_MENU_ADDFILM
        val itemOrder = Menu.NONE
        val itemText = "Añadir película"
        val addFilm = menu.add(groupId, itemId, 0, itemText)
        val aboutUs = menu.add(groupId, ID_MENU_ABOUTUS, 1, "Acerca De")
        return true
    }

    override fun onOptionsItemSelected(elemento: MenuItem): Boolean {
        super.onOptionsItemSelected(elemento)
        when (elemento.itemId) {
            ID_MENU_ADDFILM ->{
                val f = Film()
                FilmDataSource.films.add(f)
                adaptador!!.notifyDataSetChanged();
                return true

            }

            ID_MENU_ABOUTUS ->{
                val data = Intent(this@FilmListActivity, AboutActivity::class.java)
                startActivity(data)

            }

        }
        return false
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_film_list)

        adaptador = PeliculasArrayAdapter(this, R.layout.item_pelicula ,FilmDataSource.films)
        var lista = findViewById<ListView>(R.id.pelis)
        lista.adapter = adaptador

        lista.setOnItemClickListener { parent: AdapterView<*>, view: View, position: Int, id: Long ->
            val selectedFilm = FilmDataSource.films[position]

            val intent = Intent(this, FilmDataActivity::class.java)
            intent.putExtra("extraPeliculaPosicion", position)
            intent.putExtra("extraTitulo", selectedFilm.title)
            intent.putExtra("extraDirector", selectedFilm.director)
            intent.putExtra("extraAnyo", selectedFilm.year.toString())
            intent.putExtra("extraImg", selectedFilm.imageResId)
            intent.putExtra("extraFormato", selectedFilm.format)
            intent.putExtra("extraGenero", selectedFilm.genre)
            intent.putExtra("extraEnlaceIMDB", selectedFilm.imdbUrl)

            startActivity(intent)
        }

        lista.choiceMode = ListView.CHOICE_MODE_MULTIPLE_MODAL
        lista.setMultiChoiceModeListener(
            object : AbsListView.MultiChoiceModeListener {
                override fun onCreateActionMode(mode: ActionMode,
                                                menu: Menu): Boolean {
                    val inflater = mode.menuInflater
                    inflater.inflate(R.menu.menu_contextual, menu)
                    return true
                }

                override fun onPrepareActionMode(mode: ActionMode,
                                                 menu: Menu): Boolean {
                    return false
                }

                override fun onActionItemClicked(mode: ActionMode,
                                                 item: MenuItem): Boolean {
                    return when (item.itemId) {
                        R.id.action_settings -> {
                            // Obtenemos los elementos seleccionados de la lista
                            val itemsSeleccionados = lista.checkedItemPositions

                            val posicionesSeleccionadas = mutableListOf<Int>()

                            for (i in 0 until itemsSeleccionados.size()) {
                                val posicion = itemsSeleccionados.keyAt(i)
                                val seleccionado = itemsSeleccionados.valueAt(i)

                                // Verificar si la posición está seleccionada (seleccionado == true)
                                if (seleccionado) {
                                    posicionesSeleccionadas.add(posicion)
                                }
                            }
                            posicionesSeleccionadas
                            val pos = posicionesSeleccionadas.reversed()
                            Log.i("My Tag", pos.toString())

                            for(i in pos){
                                FilmDataSource.films.removeAt(i)
                            }
                            adaptador!!.notifyDataSetChanged()
                            mode.finish()

                            true
                        }
                        else -> false
                    }
                }

                override fun onDestroyActionMode(mode: ActionMode) {}

                override fun onItemCheckedStateChanged(mode: ActionMode,
                                                       position: Int, id: Long, checked: Boolean) {
                    if (checked) {
                        val color = Color.parseColor("#99CCFF")
                        lista.getChildAt(position).setBackgroundColor(color)
                    } else {
                        lista.getChildAt(position).setBackgroundColor(Color.TRANSPARENT)

                    }
                }
            })


        val peliA = findViewById<Button>(R.id.peliA)
        peliA.setOnClickListener {
            val data = Intent(this@FilmListActivity, FilmDataActivity::class.java)
            data.putExtra(EXTRA_FILM_TITLE, "A")
            startActivity(data)
        }

        val peliB = findViewById<Button>(R.id.peliB)
        peliB.setOnClickListener {
            val data = Intent(this@FilmListActivity, FilmDataActivity::class.java)
            data.putExtra(EXTRA_FILM_TITLE, "B")
            startActivity(data)
        }

        val recycler = findViewById<Button>(R.id.Recycler)
        recycler.setOnClickListener {
            val data = Intent(this@FilmListActivity, FilmRecyclerListActivity::class.java)
            startActivity(data)
        }

        val ListaFragment = findViewById<Button>(R.id.Fragment)
        ListaFragment.setOnClickListener {
            val data = Intent(this@FilmListActivity, FilmListFragment::class.java)
            startActivity(data)
        }

        val acercaDe = findViewById<Button>(R.id.acercaDe)
        acercaDe.setOnClickListener {
            val data = Intent(this@FilmListActivity, AboutActivity::class.java)
            startActivity(data)
        }
    }

}