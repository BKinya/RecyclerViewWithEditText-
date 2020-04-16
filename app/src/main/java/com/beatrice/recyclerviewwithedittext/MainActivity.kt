package com.beatrice.recyclerviewwithedittext

import android.os.Bundle
import android.util.Log
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import kotlinx.android.synthetic.main.activity_main.*
import kotlinx.android.synthetic.main.last_view.view.*

class MainActivity : AppCompatActivity() {

    private lateinit var viewAdapter: RecyclerView.Adapter<*>
    private lateinit var viewManager: RecyclerView.LayoutManager

    private val myDataSet = arrayOf("Taylor", "Betty", "Nick", "Tom", "Harrison", "Alice", "David")

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)


        viewManager = LinearLayoutManager(this)
        viewAdapter = MyAdapter(myDataSet)

        recyclerView.apply {
            layoutManager = viewManager
            adapter = viewAdapter
            setItemViewCacheSize(myDataSet.size+1)
        }

    }


}
