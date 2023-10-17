package es.ua.eps.filmoteca

import android.content.Intent
import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.TextView
import android.widget.Toast
import es.ua.eps.filmoteca.databinding.ActivityFilmDataBinding
import es.ua.eps.filmoteca.databinding.FragmentFilmDataBinding

// TODO: Rename parameter arguments, choose names that match
// the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
private const val ARG_PARAM1 = "param1"
private const val ARG_PARAM2 = "param2"

/**
 * A simple [Fragment] subclass.
 * Use the [FilmDataFragment.newInstance] factory method to
 * create an instance of this fragment.
 */
class FilmDataFragment : Fragment() {
    // TODO: Rename and change types of parameters
    private var pos: Int? = null
    private var film: Film? = null
    private lateinit var binding: FragmentFilmDataBinding
    private var position: Int = -1


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentFilmDataBinding.inflate(inflater, container, false)

        // Inflate the layout for this fragment

        binding.volverAPrincipal.setOnClickListener {
            val volverIntent = Intent(this.context, MainActivity::class.java)
            volverIntent.flags = Intent.FLAG_ACTIVITY_CLEAR_TOP
            startActivity(volverIntent)
        }

        return binding.root

    }

    fun setDetalleItem(position: Int) {

        pos = position
        film = FilmDataSource.films[position]

        val film = FilmDataSource.films[position.toInt()]
//        activity?.findViewById<TextView>()
        binding.TituloPelicula.setText(film.title)
        binding.anyoStr.setText(film.year.toString())
        binding.DirectorStr.text = film.director
        val genre = film.genre
        var genero = ""
        when (genre) {
            0 -> genero = "Acción"
            1 -> genero = "Comedia"
            2 -> genero = "Drama"
            3 -> genero = "Sci-Fi"
            4 -> genero = "Horror"
            else -> genero = "Error"
        }

        binding.genero.setText(genero)
        val format = film.format
        var formato = ""
        when (format) {
            0 -> formato = "DVD"
            1 -> formato = "Blu-ray"
            2 -> formato = "Digital"
            else -> formato = "Error"
        }
        binding.formato.setText(formato)

        //binding.imageView4.setImageBitmap(film.image)
        //imdb = film.imdbUrl.toString()
    }

    companion object {
        const val PARAM_POSICION = "PARAM_POSICION"

        /**
         * Use this factory method to create a new instance of
         * this fragment using the provided parameters.
         *
         * @param param1 Parameter 1.
         * @param param2 Parameter 2.
         * @return A new instance of fragment FilmDataFragment.
         */
        // TODO: Rename and change types and number of parameters
        @JvmStatic
        fun newInstance(param1: String, param2: String) =
            FilmDataFragment().apply {
                arguments = Bundle().apply {
                    putString(ARG_PARAM1, param1)
                    putString(ARG_PARAM2, param2)
                }
            }
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        // Check if arguments contain PARAM_POSICION and set the detail if it does
        arguments?.let {
            if (it.containsKey(PARAM_POSICION)) {
                val position = it.getInt(PARAM_POSICION)
                setDetalleItem(position)
            }
        }


    }
}