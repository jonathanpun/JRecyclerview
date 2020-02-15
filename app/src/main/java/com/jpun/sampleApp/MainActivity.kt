package com.jpun.sampleApp

import android.content.Intent
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
        activity_main_linear_horizontal.setOnClickListener {
            startActivity(Intent(this,LinearHorizontalActivity::class.java))
        }
        activity_main_linear_vertical.setOnClickListener {
            startActivity(Intent(this,LinearVerticalActivity::class.java))
        }
        activity_main_grid.setOnClickListener {
            startActivity(Intent(this,GridActivity::class.java))
        }

    }
}
