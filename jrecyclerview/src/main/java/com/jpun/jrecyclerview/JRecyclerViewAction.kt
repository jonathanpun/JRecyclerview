package com.jpun.jrecyclerview

interface JRecyclerViewAction {
    fun addCell(cell:JCell<*>,toPosition:Int)
    fun addCell(cell:JCell<*>)
    fun removeCell(position:Int)
    fun removeCell(cell:JCell<*>)
    fun moveCell(fromPosition:Int, toPosition: Int)

}