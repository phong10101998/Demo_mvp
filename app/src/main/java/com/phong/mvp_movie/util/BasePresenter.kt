package com.phong.mvp_movie.util

interface BasePresenter<T> {
    fun onStart()
    fun onStop()
    fun setView(view: T?)
}
