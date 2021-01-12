package com.phong.mvp_movie.util

import com.phong.mvp_movie.BuildConfig

object Constant {
    const val MOVIE_MODEL = "MOVIE_MODEL"
    const val BASE_URL = "https://api.themoviedb.org/3/movie/upcoming?api_key="
    const val BASE_PAGE = "&language=en-US&page=1"
    const val BASE_API_KEY = BuildConfig.API_KEY
    const val IMAGE_URL = "https://image.tmdb.org/t/p/w500"
    const val TYPE_NULL = "Connected failed! Check Logcat"
    const val LOG_D = "TYPE_LOG"
}
