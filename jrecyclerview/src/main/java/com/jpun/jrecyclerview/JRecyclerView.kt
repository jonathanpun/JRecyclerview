package com.jpun.jrecyclerview

import android.content.Context
import android.util.AttributeSet
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView

class JRecyclerView:RecyclerView{
    constructor(context: Context):super(context)
    constructor(context: Context,attributeSet: AttributeSet):super(context,attributeSet)
    private val adapter=JAdapter()
    init {
        layoutManager=LinearLayoutManager(context)
        setAdapter(adapter)
    }





    fun addCell(cell:JCell<*>){
        adapter.addCell(cell,0)
    }

}