package es.ua.eps.filmoteca

    object FilmDataSource {
        val films: MutableList<Film> = mutableListOf<Film>()

        init {
            var f = Film()
            f.title = "Regreso al futuro"
            f.director = "Robert Zemeckis"
            f.imageResId = R.mipmap.ic_launcher
            f.comments = ""
            f.format = Film.Companion.FORMAT_DIGITAL
            f.genre = Film.Companion.GENRE_SCIFI
            f.imdbUrl = "http://www.imdb.com/title/tt0088763"
            f.year = 1985
            films.add(f)

            var f2 = Film()
            f2.title = "Regreso al futuro 2"
            f2.director = "Robert Zemeckis"
            f2.imageResId = R.mipmap.ic_launcher
            f2.comments = ""
            f2.format = Film.Companion.FORMAT_DIGITAL
            f2.genre = Film.Companion.GENRE_SCIFI
            f2.imdbUrl = "https://www.imdb.com/title/tt0096874/"
            f2.year = 1989
            films.add(f2)


            var f3 = Film()
            f3.title = "Regreso al futuro 3"
            f3.director = "Robert Zemeckis"
            f3.imageResId = R.mipmap.ic_launcher
            f3.comments = ""
            f3.format = Film.Companion.FORMAT_DIGITAL
            f3.genre = Film.Companion.GENRE_SCIFI
            f3.imdbUrl = "https://www.imdb.com/title/tt0099088/"
            f3.year = 1990
            films.add(f3)

            var f4 = Film()
            f4.title = "Cazafantasmas"
            f4.director = "Paul Feig"
            f4.imageResId = R.mipmap.ic_launcher
            f4.comments = ""
            f4.format = Film.Companion.FORMAT_DIGITAL
            f4.genre = Film.Companion.GENRE_SCIFI
            f4.imdbUrl = "https://www.imdb.com/title/tt1289401/"
            f4.year = 2016
            films.add(f4)

            var f5 = Film()
            f5.title = "Sanic"
            f5.director = "Jeff Fowler"
            f5.imageResId = R.drawable.a580b57fcd9996e24bc43c336
            f5.comments = ""
            f5.format = Film.Companion.FORMAT_DIGITAL
            f5.genre = Film.Companion.GENRE_SCIFI
            f5.imdbUrl = "https://www.imdb.com/title/tt3794354/"
            f5.year = 2020
            films.add(f5)

            // Añade tantas películas como quieras!
        }
    }