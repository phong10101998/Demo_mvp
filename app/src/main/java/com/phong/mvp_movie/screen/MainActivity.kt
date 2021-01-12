package com.phong.mvp_movie.screen

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.Toast
import androidx.recyclerview.widget.GridLayoutManager
import com.phong.mvp_movie.R
import com.phong.mvp_movie.data.model.Movie
import com.phong.mvp_movie.data.source.MovieRepository
import com.phong.mvp_movie.screen.adapter.MainAdapter
import com.phong.mvp_movie.util.Constant
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity(), MainContract.View {

    private val adapter: MainAdapter by lazy { MainAdapter() }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        initView()
        initData()
    }

    private fun initView() {
        recyclerView.apply {
            setHasFixedSize(true)
            adapter = this@MainActivity.adapter
            layoutManager = GridLayoutManager(baseContext, 2)
        }
    }

    private fun initData() {
        MainPresenter(MovieRepository.INSTANCE).apply {
            setView(this@MainActivity)
            onStart()
        }
    }

    override fun onGetMovieSuccess(movie: MutableList<Movie>) {
        adapter.updateData(movie)
    }

    override fun onError(exception: Exception?) {
        Toast.makeText(this, exception?.message ?: Constant.TYPE_NULL, Toast.LENGTH_SHORT).show()
        Log.d(Constant.LOG_D, exception?.message ?: Constant.TYPE_NULL)
    }
}
