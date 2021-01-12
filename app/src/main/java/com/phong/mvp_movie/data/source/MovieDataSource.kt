package com.phong.mvp_movie.data.source

import com.phong.mvp_movie.data.model.Movie
import com.phong.mvp_movie.data.source.remote.OnFetchDataJsonListener

interface MovieDataSource {
    interface Local

    interface Remote {
        fun getMovie(listener: OnFetchDataJsonListener<MutableList<Movie>>)
    }
}
