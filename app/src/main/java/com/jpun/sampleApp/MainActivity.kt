package com.jpun.sampleApp

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.jpun.jrecyclerview.JRecyclerView
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {
    private lateinit var recyclerView:JRecyclerView
    private val dog = Animal("Hero")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        recyclerView=activity_main_recyclerview
        recyclerView.addCell(AnimalCell(dog))



    }
}
