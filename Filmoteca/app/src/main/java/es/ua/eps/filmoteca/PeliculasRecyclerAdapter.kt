package es.ua.eps.filmoteca

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView

class PeliculasRecyclerAdapter(val peliculas: List<Film>):
    RecyclerView.Adapter<PeliculasRecyclerAdapter.ViewHolder?>() {

    private var listener: (pelicula: Film, position: Int) -> Unit = { film: Film, i: Int -> }

    fun setOnItemClickListener(listener: (pelicula: Film, position: Int) -> Unit) {
        this.listener = listener // Guardamos una referencia al listener
    }
    override fun onCreateViewHolder(parent: ViewGroup,
                                    viewType: Int): ViewHolder {
        val v: View = LayoutInflater.from(parent.context)
            .inflate(R.layout.item_pelicula, parent, false)
        val holder = ViewHolder(v)

        v.setOnClickListener {
            val position: Int = holder.adapterPosition
            listener(peliculas[position], position)
        }

        return holder
    }

    override fun getItemCount(): Int {
        return FilmDataSource.films.size
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.bind(FilmDataSource.films[position])
    }

    class ViewHolder(v: View) : RecyclerView.ViewHolder(v) {
        var nombre: TextView
        var descripcion: TextView
        var icono: ImageView

        fun bind(l: Film) {
            nombre.text = l.title
            descripcion.text = l.director
            icono.setImageResource(l.imageResId)
        }

        init {
            nombre = v.findViewById(R.id.nombre)
            descripcion = v.findViewById(R.id.descripcion)
            icono = v.findViewById(R.id.icono)
        }
    }
}