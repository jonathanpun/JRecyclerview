package com.jpun.jrecyclerview

import android.graphics.Rect
import android.util.Log
import android.view.View
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView

class JSpacingDecorator():RecyclerView.ItemDecoration(){
    var startSpacing=0
    var endSpacing=0
    var horizontalSpacing=0
    var verticalSpacing=0


    override fun getItemOffsets(outRect: Rect, view: View, parent: RecyclerView, state: RecyclerView.State
    ) {
        outRect.set(0,0,0,0)
        if (parent !is JRecyclerView)
            throw Exception("Jrecyclerview only")
        val position=parent.getChildAdapterPosition(view)
        val count=parent.getCells().size
        val lm=parent.layoutManager
        when(lm){
            is GridLayoutManager->{
                val span=lm.spanCount
                //vertical spacing
                if(position <span){
                    outRect.top=startSpacing
                }else{
                    outRect.top=verticalSpacing

                }

                if(position>=count-count%span){
                    outRect.bottom=endSpacing
                }
                //horizontal spacing
                when {
                    position%span==0 -> outRect.right=horizontalSpacing/2
                    position%span==span-1 -> outRect.left=horizontalSpacing/2
                    else -> {
                        outRect.left=horizontalSpacing/2
                        outRect.right=horizontalSpacing/2
                    }
                }
            }
            is LinearLayoutManager->{
                if(lm.orientation==LinearLayoutManager.VERTICAL){
                    when (position) {
                        0 -> {
                            outRect.top=startSpacing
                            outRect.bottom=verticalSpacing
                        }
                        count-1 -> outRect.bottom=endSpacing
                        else -> {
                            outRect.bottom=verticalSpacing
                        }
                    }
                }else{
                    when (position) {
                        0 -> {
                            outRect.left=startSpacing
                            outRect.right=horizontalSpacing
                        }
                        count-1 -> outRect.right=endSpacing
                        else -> {
                            outRect.right=horizontalSpacing
                        }
                    }

                }

            }
            else->throw  Exception("unsupported layoutmanager")
        }

    }

}