package com.jpun.jrecyclerview

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import java.util.*

class JAdapter():RecyclerView.Adapter<JCell.JViewHolder>(),JRecyclerViewAction{

    private val cellList= mutableListOf<JCell<*>>()
    //todo the typeMap currently may reference the a cell that is not in the list
    private val typeMap= mutableMapOf<Int,JCell<*>>()
    private val typeCounter= mutableMapOf<Int,Int>()

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

    override fun onViewRecycled(holder: JCell.JViewHolder) {
        val position=holder.adapterPosition
        cellList[position].unbindCell(holder)
    }


    override fun getItemViewType(position: Int): Int {
        return  cellList[position].javaClass.canonicalName!!.hashCode()
    }

    private fun putCellType(cell: JCell<*>){
        val typeId=cell.getViewType()
        if(typeCounter.containsKey(typeId)){
            typeCounter[typeId] = typeCounter[typeId]!!+1
        }else{
            typeCounter[typeId]=1
        }
        typeMap[typeId]=cell

    }
    private fun removeCellType(cell: JCell<*>){
        val typeId=cell.getViewType()
        val count=typeCounter[typeId]!!
        if (count<=1)
            throw Exception("counter lower than 1")
        typeCounter[typeId]=count-1
        if (count==1){//no cell left with that type
            typeMap.remove(typeId)//remove the type
        }
    }



    override fun addCell(cell:JCell<*>, toPosition:Int){
        putCellType(cell)
        cellList.add(toPosition, cell as JCell<JCell.JViewHolder>)
        notifyItemInserted(toPosition)
    }
    override fun addCell(cell: JCell<*>) {
       addCell(cell,cellList.lastIndex+1)
    }

    override fun removeCell(position: Int) {
        val cell=cellList[position]
        removeCellType(cell)
        cellList.removeAt(position)
        notifyItemRemoved(position)
    }

    override fun removeCell(cell: JCell<*>) {
        val position=cellList.indexOf(cell)
        if (position==-1)
            throw Exception("cell to be removed not found in cellList")
        removeCell(position)
    }

    override fun moveCell(fromPosition: Int, toPosition: Int) {
        Collections.swap(cellList,fromPosition,toPosition)
        notifyItemMoved(fromPosition,toPosition)
    }
    fun getCells()=cellList.toList()



}