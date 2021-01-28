package com.phong.mvp_movie.screen

import com.phong.mvp_movie.data.model.Movie
import com.phong.mvp_movie.util.BasePresenter

interface MainContract {

    interface View {
        fun onGetMovieSuccess(movie: MutableList<Movie>)
        fun onError(exception: Exception?)
    }

    interface Presenter : BasePresenter<View> {
        fun getMovie()
    }
}
