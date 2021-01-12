package com.phong.mvp_movie.data.source.local

import com.phong.mvp_movie.data.source.MovieDataSource

class MovieLocalDataSource : MovieDataSource.Local {

    private object Holder {
        val INSTANCE = MovieLocalDataSource()
    }

    companion object {
        val instance: MovieLocalDataSource by lazy { Holder.INSTANCE }
    }
}
