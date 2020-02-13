package com.jpun.sampleApp

import android.view.View
import com.jpun.jrecyclerview.JCell
import kotlinx.android.synthetic.main.movie_cell_layout.view.*

class MovieCell(val movie: Movie):JCell<MovieCell.MovieCellViewHolder>(){
    override fun getLayoutId(): Int {
        return R.layout.movie_cell_layout
    }

    override fun onCreateViewHolder(view: View): JViewHolder {
        return MovieCellViewHolder(view)
    }

    override fun onBindViewHolder(viewHolder: MovieCellViewHolder) {
        viewHolder.apply {
            name.text=movie.name
            rating.text=movie.rating.toString()
        }
    }


    class MovieCellViewHolder(view: View):JCell.JViewHolder(view){
        val name=view.movie_cell_layout_name
        val rating=view.movie_cell_layout_rating

    }

}