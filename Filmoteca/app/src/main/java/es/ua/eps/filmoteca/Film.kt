package es.ua.eps.filmoteca

class Film {

    var imageResId = 0 // Propiedades de la clase
    var title: String? = "Sin titulo"
    var director: String? = null
    var year = 0
    var genre = 0
    var format = 0
    var imdbUrl: String? = null
    var comments: String? = null

    override fun toString(): String {
        return title?:"<Sin titulo>" // Al convertir a cadena mostramos su título
    }

    companion object {
        const val FORMAT_DVD = 0 // Formatos
        const val FORMAT_BLURAY = 1
        const val FORMAT_DIGITAL = 2
        const val GENRE_ACTION = 0 // Géneros
        const val GENRE_COMEDY = 1
        const val GENRE_DRAMA = 2
        const val GENRE_SCIFI = 3
        const val GENRE_HORROR = 4
    }

    public fun obtenerFormatoNombre(formato: Int): String {
        return when (formato) {
            FORMAT_DVD -> "DVD"
            FORMAT_BLURAY -> "Blu-ray"
            FORMAT_DIGITAL -> "Digital"
            else -> "Desconocido"
        }
    }

    public fun obtenerGeneroNombre(genero: Int): String {
        if (genero == 1) {
            return "Acción"
        } else if (genero == 2) {
            return "Comedia"
        } else if (genero == 3) {
            return "Drama"
        } else if (genero == 4) {
            return "Ciencia Ficción"
        } else if (genero == 5) {
            return "Terror"
        } else {
            return "Desconocido"
        }
    }
}