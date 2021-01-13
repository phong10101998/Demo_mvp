package com.phong.mvp_movie.data.source.remote.fetchjson

import com.phong.mvp_movie.data.model.MovieEntry
import com.phong.mvp_movie.util.Constant
import org.json.JSONObject
import java.io.BufferedReader
import java.io.InputStreamReader
import java.net.HttpURLConnection
import java.net.URL

class ParesDataWithJson {

    fun getJsonFromUrl(urlString: String?): String {
        val url = URL(urlString)//khai báo đường dẫn
        val httpURLConnection = url.openConnection() as HttpURLConnection //mở kết nối đến đường dẫn url
        httpURLConnection.apply {
            connectTimeout = TIME_OUT // thời gian kết nối tới api
            readTimeout = TIME_OUT // thời gian đọc json
            requestMethod = METHOD_GET // phương thức sủ dụng (GET, POST, PUSH, DELETE)
            doOutput = true
            connect()
        }
        val bufferedReader = BufferedReader(InputStreamReader(url.openStream())) //Đọc dữ liệu
        val stringBuilder = StringBuilder() //chứa dữ liệu đọc được
        var line: String?
        while (bufferedReader.readLine().also { line = it } != null) {
            stringBuilder.append(line)
        } // đọc từng dòng, đọc hết xuống dòng đọc tiếp
        bufferedReader.close()
        httpURLConnection.disconnect()
        return stringBuilder.toString() //trả về kết quả
    }

    fun parseJsonToDaTa(jsonObject: JSONObject?, keyEntity: String): Any {
        val data = mutableListOf<Any>()
        try {
            val jsonArray = jsonObject?.getJSONArray(MovieEntry.RESULT)
            for (i in 0 until (jsonArray?.length() ?: 0)) {
                val jsonObjects = jsonArray?.getJSONObject(i)
                val item = parseJsonToObject(jsonObjects, keyEntity)
                item?.let { data.add(item) }
            }
        } catch (e: Exception) {
            e.printStackTrace()
        }
        return data
    }

    private fun parseJsonToObject(jsonObject: JSONObject?, keyEntity: String): Any? {
        try {
            jsonObject?.let {
                when (keyEntity) {
                    Constant.MOVIE_MODEL -> return ParseJson().movieParseJson(it)
                    else -> null
                }
            }
        } catch (e: Exception) {
            e.printStackTrace()
        }
        return null
    }

    companion object {
        private const val TIME_OUT = 20000
        private const val METHOD_GET = "GET"
    }
}
