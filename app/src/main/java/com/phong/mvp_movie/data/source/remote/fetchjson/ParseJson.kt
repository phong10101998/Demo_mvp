package com.phong.mvp_movie.data.source.remote.fetchjson

import com.phong.mvp_movie.data.model.Movie
import com.phong.mvp_movie.data.model.MovieEntry
import org.json.JSONObject

class ParseJson {

    fun movieParseJson(jsonObject: JSONObject): Movie {
        val title = jsonObject.getString(MovieEntry.TITLE)
        val voteCount = jsonObject.getInt(MovieEntry.VOTE_COUNT)
        val poster = jsonObject.getString(MovieEntry.POSTER)
        return Movie(title, voteCount, poster)
    }
}
