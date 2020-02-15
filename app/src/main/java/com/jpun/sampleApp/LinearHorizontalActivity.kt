package com.jpun.sampleApp

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import com.jpun.jrecyclerview.JCell
import com.jpun.jrecyclerview.JCellClickListener
import com.jpun.jrecyclerview.JCellLongClickListener
import kotlinx.android.synthetic.main.activity_grid.*
import kotlinx.android.synthetic.main.activity_linear_horizontal.*

class LinearHorizontalActivity : AppCompatActivity(), JCellClickListener, JCellLongClickListener {
    override fun onCellLongClick(cell: JCell<*>) {
        when(cell){
            is MovieCell->{
                Toast.makeText(this,"movie cell name ${cell.movie.name} long click", Toast.LENGTH_SHORT).show()
            }
            is AnimalCell->{
                Toast.makeText(this,"movie cell name ${cell.animal.name} long click", Toast.LENGTH_SHORT).show()
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
        setContentView(R.layout.activity_linear_horizontal)
        val recyclerView=activity_linear_horizontal_recyclerview
        (1..20).map { Animal("Animal $it") }.forEach {
            recyclerView.addCell(AnimalCell(it).apply {
                setCellClickListener(this@LinearHorizontalActivity)
            })


        }
        (1..20).map { Movie("Animal $it",it.toFloat()) }.forEach {
            recyclerView.addCell(MovieCell(it).apply {
                setCellLongClickListener(this@LinearHorizontalActivity)
            })
        }
    }
}
