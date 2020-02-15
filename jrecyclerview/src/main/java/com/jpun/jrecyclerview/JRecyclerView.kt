package com.jpun.jrecyclerview

import android.content.Context
import android.util.AttributeSet
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView

class JRecyclerView:RecyclerView,JRecyclerViewAction{
    private val adapter=JAdapter()
    private val spacingDecorator=JSpacingDecorator()
    init {
        layoutManager=LinearLayoutManager(context)
        setAdapter(adapter)
    }
    constructor(context: Context):super(context)
    constructor(context: Context,attributeSet: AttributeSet):super(context,attributeSet){
        context.theme.obtainStyledAttributes(attributeSet,R.styleable.JRecyclerView,0,0).apply {
            when(getInteger(R.styleable.JRecyclerView_layoutMode,0)){
                0->setLinearHorizontalLayoutManager()
                1->setLinearVerticalLayoutManager()
                2->setGridLayoutManager(getInteger(R.styleable.JRecyclerView_spanCount,2))
            }
            val startSpacing=getDimensionPixelOffset(R.styleable.JRecyclerView_startSpacing,0)
            val endSpacing=getDimensionPixelOffset(R.styleable.JRecyclerView_endSpacing,0)
            val horizontalSpacing=getDimensionPixelOffset(R.styleable.JRecyclerView_horizontalSpacing,0)
            val verticlaSpacing=getDimensionPixelOffset(R.styleable.JRecyclerView_verticalSpacing,0)
            setSpacingDecorator(startSpacing,endSpacing,horizontalSpacing,verticlaSpacing)
        }.recycle()
    }

    private fun setLinearHorizontalLayoutManager(){
        layoutManager=LinearLayoutManager(context).apply {
            orientation=LinearLayoutManager.HORIZONTAL
        }
    }
    private fun setLinearVerticalLayoutManager(){
        layoutManager=LinearLayoutManager(context).apply {
            orientation=LinearLayoutManager.VERTICAL
        }
    }
    private fun setGridLayoutManager(spanCount:Int){
        layoutManager=GridLayoutManager(context,spanCount)
    }
    private fun setSpacingDecorator(startSpacing:Int, endSpacing:Int, horizontalSpacing:Int,verticalSpacing:Int){
        addItemDecoration(spacingDecorator.apply {
            this.startSpacing=startSpacing
            this.endSpacing=endSpacing
            this.horizontalSpacing=horizontalSpacing
            this.verticalSpacing=verticalSpacing
        })

    }

    fun getCells()=adapter.getCells()


    override fun addCell(cell:JCell<*>){
        adapter.addCell(cell)
    }
    override fun addCell(cell: JCell<*>, toPosition: Int) {
        adapter.addCell(cell,0)
    }

    override fun removeCell(position: Int) {
        adapter.removeCell(position)
    }

    override fun removeCell(cell: JCell<*>) {
        adapter.removeCell(cell)
    }

    override fun moveCell(fromPosition: Int, toPosition: Int) {
        adapter.moveCell(fromPosition,toPosition)
    }


}