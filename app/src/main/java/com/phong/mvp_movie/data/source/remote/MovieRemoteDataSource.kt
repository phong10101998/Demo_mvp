package com.phong.mvp_movie.data.source.remote

import com.phong.mvp_movie.data.model.Movie
import com.phong.mvp_movie.data.source.MovieDataSource
import com.phong.mvp_movie.data.source.remote.fetchjson.GetJsonFromUrl
import com.phong.mvp_movie.util.Constant

class MovieRemoteDataSource : MovieDataSource.Remote {

    private var baseUrl = Constant.BASE_URL + Constant.BASE_API_KEY + Constant.BASE_PAGE

    private object Holder {
        val instance = MovieRemoteDataSource()
    }

    override fun getMovie(listener: OnFetchDataJsonListener<MutableList<Movie>>) {
        GetJsonFromUrl(listener, Constant.MOVIE_MODEL).execute(baseUrl)
    }

    companion object {
        val instance: MovieRemoteDataSource by lazy { Holder.instance }
    }
}
