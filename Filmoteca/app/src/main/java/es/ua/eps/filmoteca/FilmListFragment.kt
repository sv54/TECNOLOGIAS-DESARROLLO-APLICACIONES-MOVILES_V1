package es.ua.eps.filmoteca

import android.content.Context
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ListView
import androidx.fragment.app.ListFragment

// TODO: Rename parameter arguments, choose names that match
// the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
private const val ARG_PARAM1 = "param1"
private const val ARG_PARAM2 = "param2"

/**
 * A simple [Fragment] subclass.
 * Use the [FilmListFragment.newInstance] factory method to
 * create an instance of this fragment.
 */
class FilmListFragment : ListFragment() {
    // TODO: Rename and change types of parameters
    private var param1: String? = null
    private var param2: String? = null
    var callback: OnItemSelectedListener? = null

    // Interfaz definida por nosotros que debe implementar
    // la actividad contenedora
    interface OnItemSelectedListener {
        fun onItemSelected(position: Int)
    }
    override fun onListItemClick(l: ListView, v: View, position: Int, id: Long) {
        callback?.onItemSelected(position)
    }
    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)

        val layoutResource = R.layout.item_pelicula

        val adapter = PeliculasArrayAdapter(requireContext(), layoutResource, FilmDataSource.films)
        listAdapter = adapter

    }

    override fun onAttach(context: Context) {
        super.onAttach(context)
        // Comprueba que la actividad implemente la interfaz definida
        // y guarda una referencia en la variable "callback"
        callback = try {
            context as OnItemSelectedListener
        } catch (e: ClassCastException) {
            throw ClassCastException(context.toString()
                    + " debe implementar OnItemSelectedListener")
        }
    }
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        arguments?.let {
            param1 = it.getString(ARG_PARAM1)
            param2 = it.getString(ARG_PARAM2)
        }
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_film_list, container, false)
    }

    companion object {
        /**
         * Use this factory method to create a new instance of
         * this fragment using the provided parameters.
         *
         * @param param1 Parameter 1.
         * @param param2 Parameter 2.
         * @return A new instance of fragment FilmListFragment.
         */
        // TODO: Rename and change types and number of parameters
        @JvmStatic
        fun newInstance(param1: String, param2: String) =
            FilmListFragment().apply {
                arguments = Bundle().apply {
                    putString(ARG_PARAM1, param1)
                    putString(ARG_PARAM2, param2)
                }
            }
    }
}