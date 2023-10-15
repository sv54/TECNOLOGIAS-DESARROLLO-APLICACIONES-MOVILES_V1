package es.ua.eps.filmoteca

import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
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

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_film_data, container, false)
    }

    fun setDetalleItem(position: Int) {
        Log.i("Tag", "This is an information message")
        pos = position
        film = FilmDataSource.films[position]
        binding = FragmentFilmDataBinding.inflate(layoutInflater)

        val film = FilmDataSource.films[position.toInt()]
        binding.titulo.setText(film.title)
        binding.anyo.setText(film.year.toString())
        binding.director.setText(film.director)
        val genre = film.genre
        var genero = ""
        when(genre){
            0->genero="Acción"
            1->genero="Comedia"
            2->genero="Drama"
            3->genero="Sci-Fi"
            4->genero="Horror"
            else->genero="Error"
        }

        binding.genero.setText(genero)
        val format = film.format
        var formato =""
        when(format){
            0->formato="DVD"
            1->formato="Blu-ray"
            2->formato="Digital"
            else->formato="Error"
        }
        binding.formato.setText(formato)

        //binding.imageView4.setImageBitmap(film.image)
        //imdb = film.imdbUrl.toString()
    }

    companion object {
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
}