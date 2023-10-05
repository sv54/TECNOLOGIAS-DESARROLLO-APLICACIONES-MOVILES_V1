package es.ua.eps.filmoteca

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ArrayAdapter
import android.widget.ImageView
import android.widget.TextView

class PeliculasArrayAdapter(context: Context?, resource: Int,
                            objects: List<Film>?): ArrayAdapter<Film>(context!!, resource, objects!!) {

    override fun getView(
        position: Int, convertView: View?,
        parent: ViewGroup
    ): View {
        var view: View = convertView ?: LayoutInflater.from(this.context)
            .inflate(R.layout.item_pelicula, parent, false)

        val tvNombre = view.findViewById(R.id.nombre) as TextView
        val tvDesc = view.findViewById(R.id.descripcion) as TextView
        val ivIcono = view.findViewById(R.id.icono) as ImageView

        getItem(position)?.let {
            tvNombre.text = it.title
            tvDesc.text = it.director
            ivIcono.setImageResource(it.imageResId)
        }

        return view
    }
}