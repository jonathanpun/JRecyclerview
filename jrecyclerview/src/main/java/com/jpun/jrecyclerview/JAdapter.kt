package com.jpun.jrecyclerview

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView

class JAdapter():RecyclerView.Adapter<JCell.JViewHolder>(){

    private val cellList= mutableListOf<JCell<*>>()
    private val typeMap= mutableMapOf<Int,JCell<*>>()

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): JCell.JViewHolder {
        val cell=typeMap.get(viewType)!!// typeMap[viewType] should return non-null
        val view =LayoutInflater.from(parent.context).inflate(cell.getLayoutId(),parent,false)
        return cell.onCreateViewHolder(view)

    }

    override fun getItemCount(): Int {
        return cellList.size
    }

    override fun onBindViewHolder(holder: JCell.JViewHolder, position: Int) {
        cellList[position].bindCell(holder)

    }

    override fun getItemViewType(position: Int): Int {
        return  cellList[position].javaClass.canonicalName!!.hashCode()
    }

    private fun checkAndPutCellType(cell: JCell<*>){
        if(!typeMap.containsKey(cell.getViewType()))
            typeMap[cell.getViewType()] = cell
    }



    fun addCell(cell:JCell<*>,toPosition:Int){
        checkAndPutCellType(cell)
        cellList.add(toPosition, cell as JCell<JCell.JViewHolder>)
        notifyItemInserted(toPosition)
    }


}