package com.jpun.sampleApp

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import com.jpun.jrecyclerview.JCellClickListener
import com.jpun.jrecyclerview.JCellLongClickListener
import com.jpun.jrecyclerview.JCell
import com.jpun.jrecyclerview.JRecyclerView
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity(),JCellClickListener,JCellLongClickListener {
    override fun onCellClick(cell: JCell<*>) {
        when(cell){
            is MovieCell->{
                Toast.makeText(this,"movie cell name ${cell.movie.name} click",Toast.LENGTH_SHORT).show()
            }
            is AnimalCell->{
                Toast.makeText(this,"movie cell name ${cell.animal.name} click",Toast.LENGTH_SHORT).show()

            }
        }
    }

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

    private lateinit var recyclerView:JRecyclerView
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        recyclerView=activity_main_recyclerview
        (1..10).map { Animal("Animal $it") }.forEach {
            recyclerView.addCell(AnimalCell(it).apply {
                setCellClickListener(this@MainActivity)
            })


        }
        (1..10).map { Movie("Animal $it",it.toFloat()) }.forEach {
            recyclerView.addCell(MovieCell(it).apply {
                setCellLongClickListener(this@MainActivity)
            })
        }
        recyclerView.removeCell(0)
        recyclerView.moveCell(0,1)

    }
}
