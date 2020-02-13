package com.jpun.jrecyclerview

import android.view.View
import androidx.recyclerview.widget.RecyclerView

abstract class JCell<VH: JCell.JViewHolder>{
    private var JCellClickListener:JCellClickListener? = null
    private var JCellLongClickListener:JCellLongClickListener? =null
    private val  viewClickListener:View.OnClickListener by lazy {
        View.OnClickListener {
            JCellClickListener?.onCellClick(this)
            JCellClickListener!=null
        }
    }
    private val viewLongClickListener:View.OnLongClickListener by lazy {
        View.OnLongClickListener {
            JCellLongClickListener?.onCellLongClick(this)
            JCellLongClickListener!=null
        }
    }
    
    
    fun getViewType()=javaClass.canonicalName!!.hashCode()
    abstract fun getLayoutId():Int
    abstract fun onCreateViewHolder(view: View):JViewHolder
    fun bindCell(viewHolder:JViewHolder){
        viewHolder.itemView.setOnLongClickListener(viewLongClickListener)
        viewHolder.itemView.setOnClickListener(viewClickListener)
        onBindViewHolder(viewHolder as VH)
    }
    fun unbindCell(viewHolder: JViewHolder){
        clearViewHolder(viewHolder as VH)
        viewHolder.itemView.setOnLongClickListener(null)
        viewHolder.itemView.setOnClickListener(null)
    }
    fun setCellClickListener(listener:JCellClickListener?){
        this.JCellClickListener=listener
    }
    fun setCellLongClickListener(listener: JCellLongClickListener?){
        this.JCellLongClickListener=listener
    }

    /**
     *you should update the view here
     */
    abstract fun onBindViewHolder(viewHolder:VH)

    /**
     * this is called when the view is recycled, you can reset view/release resource etc
     */
    open fun clearViewHolder(viewHolder: JViewHolder){}

    open class JViewHolder(view:View): RecyclerView.ViewHolder(view){


    }
}