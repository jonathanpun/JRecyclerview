package com.jpun.sampleApp

import android.view.View
import com.jpun.jrecyclerview.JCell
import kotlinx.android.synthetic.main.animal_cell_layout.view.*

class AnimalCell(val animal:Animal) :JCell<AnimalCell.AnimalViewHolder>(){
    override fun getLayoutId(): Int {
        return R.layout.animal_cell_layout
    }

    override fun onCreateViewHolder(view: View): JViewHolder {
        return AnimalViewHolder(view)
    }


    override fun onBindViewHolder(viewHolder: AnimalViewHolder) {
        viewHolder.nameView.text=animal.name
    }
    class AnimalViewHolder(view: View) :JViewHolder(view){
        val nameView=view.animal_cell_layout_name

    }

}