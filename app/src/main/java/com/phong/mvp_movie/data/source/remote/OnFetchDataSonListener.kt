package com.phong.mvp_movie.data.source.remote

interface OnFetchDataSonListener<T> {
    fun onSuccess(data: T)
    fun onError(exception: Exception?)
}
