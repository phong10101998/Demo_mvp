package com.phong.mvp_movie.screen

import com.phong.mvp_movie.data.model.Movie
import com.phong.mvp_movie.data.source.MovieRepository
import com.phong.mvp_movie.data.source.remote.OnFetchDataJsonListener

class MainPresenter internal constructor(private val repository: MovieRepository?) : MainContract.Presenter {

    private var view: MainContract.View? = null

    override fun getMovie() {
        repository?.getMovie(object : OnFetchDataJsonListener<MutableList<Movie>> {
            override fun onSuccess(data: MutableList<Movie>) {
                view?.onGetMovieSuccess(data)
            }

            override fun onError(exception: Exception?) {
                view?.onError(exception)
            }
        })
    }

    override fun onStart() {
        getMovie()
    }

    override fun setView(view: MainContract.View?) {
        this.view = view
    }
}
