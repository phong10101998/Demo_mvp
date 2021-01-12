package com.phong.mvp_movie.data.source

import com.phong.mvp_movie.data.model.Movie
import com.phong.mvp_movie.data.source.remote.OnFetchDataSonListener

interface MovieDataSource {
    interface Local

    interface Remote {
        fun getMovie(listener: OnFetchDataSonListener<MutableList<Movie>>)
    }
}
