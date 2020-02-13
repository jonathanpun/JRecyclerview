package com.jpun.jrecyclerview

import android.view.View
import androidx.recyclerview.widget.RecyclerView

abstract class JCell<VH: JCell.JViewHolder>{

    fun getViewType()=javaClass.canonicalName!!.hashCode()
    abstract fun getLayoutId():Int
    abstract fun onCreateViewHolder(view: View):JViewHolder
    fun bindCell(viewHolder:JViewHolder){
        onBindViewHolder(viewHolder as VH)
    }
    abstract fun onBindViewHolder(viewHolder:VH)

    open class JViewHolder(view:View): RecyclerView.ViewHolder(view){


    }
}