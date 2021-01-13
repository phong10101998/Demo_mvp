package com.phong.mvp_movie.data.source.local

import com.phong.mvp_movie.data.source.MovieDataSource

class MovieLocalDataSource : MovieDataSource.Local {

    private object Holder {
        val instance = MovieLocalDataSource()
    }

    companion object {
        val instance: MovieLocalDataSource by lazy { Holder.instance }
    }
}
