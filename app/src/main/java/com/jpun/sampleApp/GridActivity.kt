package com.jpun.sampleApp

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import com.jpun.jrecyclerview.JCell
import com.jpun.jrecyclerview.JCellClickListener
import com.jpun.jrecyclerview.JCellLongClickListener
import kotlinx.android.synthetic.main.activity_grid.*
import kotlinx.android.synthetic.main.activity_main.*

class GridActivity : AppCompatActivity(), JCellClickListener, JCellLongClickListener {
    override fun onCellLongClick(cell: JCell<*>) {
        when(cell){
            is MovieCell->{
                Toast.makeText(this,"movie cell name ${cell.movie.name} long click",Toast.LENGTH_SHORT).show()
            }
            is AnimalCell->{
                Toast.makeText(this,"movie cell name ${cell.animal.name} long click",Toast.LENGTH_SHORT).show()
            }
        }
    }

    override fun onCellClick(cell: JCell<*>) {
        when(cell){
            is MovieCell->{
                Toast.makeText(this,"movie cell name ${cell.movie.name} click", Toast.LENGTH_SHORT).show()
            }
            is AnimalCell->{
                Toast.makeText(this,"movie cell name ${cell.animal.name} click", Toast.LENGTH_SHORT).show()

            }
        }
    }
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_grid)
        val recyclerView=activity_grid_recyclerview
        (1..101).map { GridCell() }.forEach {
            recyclerView.addCell(it)

        }
    }
}
