package com.phong.mvp_movie.data.model

data class Movie(
    val title: String = "",
    val voteCount: Int = 0,
    val posterUrl: String = ""
)

object MovieEntry {
    const val RESULT = "results"
    const val TITLE = "title"
    const val VOTE_COUNT = "vote_count"
    const val POSTER = "poster_path"
}
