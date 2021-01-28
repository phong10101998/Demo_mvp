package com.phong.mvp_movie.data.source.remote.fetchjson

import com.phong.mvp_movie.data.model.Movie
import com.phong.mvp_movie.data.model.MovieEntry
import org.json.JSONObject

class ParseJson {

    fun movieParseJson(jsonObject: JSONObject): Movie = jsonObject.run {
        Movie(
            getString(MovieEntry.TITLE),
            getInt(MovieEntry.VOTE_COUNT),
            getString(MovieEntry.POSTER)
        )
    }
}
