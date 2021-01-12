package com.phong.mvp_movie.util

import android.graphics.Bitmap
import android.graphics.BitmapFactory
import android.os.AsyncTask
import android.widget.ImageView
import java.net.HttpURLConnection
import java.net.URL

class BitmapLoad(private val imageView: ImageView) : AsyncTask<String?, Unit, Bitmap?>() {

    override fun doInBackground(vararg params: String?): Bitmap? = try {
        val url = URL(params[0].toString())
        val httpURLConnection = url.openConnection() as HttpURLConnection
        httpURLConnection.apply {
            connectTimeout = TIME_OUT
            readTimeout = TIME_OUT
            requestMethod = METHOD_GET
            doOutput = true
            connect()
        }
        BitmapFactory.decodeStream(url.openStream())

    } catch (e: Exception) {
        e.printStackTrace()
        null
    }

    override fun onPostExecute(result: Bitmap?) {
        result?.let { imageView.setImageBitmap(it) }
        super.onPostExecute(result)
    }

    companion object {
        const val TIME_OUT = 20000
        const val METHOD_GET = "GET"
    }
}
