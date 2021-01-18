package com.phong.mvp_movie.screen

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.phong.mvp_movie.R
import com.phong.mvp_movie.data.model.Movie
import com.phong.mvp_movie.util.Constant
import com.squareup.picasso.Picasso
import kotlinx.android.synthetic.main.fragment_detail_movie.*

class DetailMovieFragment : Fragment() {
    companion object {
        fun instance(movie: Movie) = DetailMovieFragment().apply {
            arguments = Bundle().apply {
                putString("title", movie.title)
                putInt("count", movie.voteCount)
                putString("poster", movie.posterUrl)
            }
        }
    }

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?,
                              savedInstanceState: Bundle?): View? {
        return inflater.inflate(R.layout.fragment_detail_movie, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        getData()
    }

    private fun getData() {
        textTitleDetail.text = arguments?.getString("title") ?: ""
        textVoteCountDetail.text = arguments?.getInt("count").toString()
        Picasso.get().load(Constant.IMAGE_URL + arguments?.getString("poster").toString()).into(imgPosterDetail)
    }
}