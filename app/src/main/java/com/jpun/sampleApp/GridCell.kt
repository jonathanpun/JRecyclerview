package com.jpun.sampleApp

import android.view.View
import com.jpun.jrecyclerview.JCell
import kotlinx.android.synthetic.main.grid_cell_layout.view.*

class GridCell:JCell<GridCell.GridCelllViewHolder>(){
    override fun getLayoutId(): Int {
        return R.layout.grid_cell_layout
    }

    override fun onCreateViewHolder(view: View): JViewHolder {
        return GridCelllViewHolder(view)
    }

    override fun onBindViewHolder(viewHolder: GridCelllViewHolder) {
        viewHolder.text.text = viewHolder.adapterPosition.toString()
    }


    class GridCelllViewHolder(view: View):JViewHolder(view){
        val text= view.grid_cell_text
    }
}