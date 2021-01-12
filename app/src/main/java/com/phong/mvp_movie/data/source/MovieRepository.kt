package com.phong.mvp_movie.data.source

import com.phong.mvp_movie.data.source.local.MovieLocalDataSource
import com.phong.mvp_movie.data.source.remote.MovieRemoteDataSource
import com.phong.mvp_movie.data.source.remote.OnFetchDataSonListener

class MovieRepository private constructor(
    private val remote: MovieDataSource.Remote,
    private val local: MovieDataSource.Local
) {
    private object Holder {
        val INSTANCE = MovieRepository(
            remote = MovieRemoteDataSource.instance,
            local = MovieLocalDataSource.instance
        )
    }

    fun getMovie(listener: OnFetchDataSonListener<MutableList<com.phong.mvp_movie.data.model.Movie>>) {
        remote.getMovie(listener)
    }

    companion object {
        val INSTANCE: MovieRepository by lazy { Holder.INSTANCE }
    }
}