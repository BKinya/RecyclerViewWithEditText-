package com.beatrice.recyclerviewwithedittext

import android.text.Editable
import android.text.TextWatcher
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.recyclerview.widget.RecyclerView
import kotlinx.android.synthetic.main.last_view.view.*
import kotlinx.android.synthetic.main.my_view.view.*

const val VIEW_TYPE_FOOTER = 0
const val VIEW_TYPE_CELL = 1

class MyAdapter(private val myDataset: Array<String>) : RecyclerView.Adapter<MyAdapter.MyViewHolder>() {

    val nameAgeMap = HashMap<String, String>()
    val mytestVIewModel = MainActivityViewModel()

    class MyViewHolder( itemView: View) : RecyclerView.ViewHolder(itemView) {
        var myTextview = itemView.myName
        var mEditext = itemView.myAge
        var btnSubmit = itemView.btnSubmit

    }
    override fun onCreateViewHolder(parent: ViewGroup,
                                    viewType: Int): MyAdapter.MyViewHolder {

        val rootView: View = if (viewType == VIEW_TYPE_CELL){
            LayoutInflater.from(parent.context).inflate(R.layout.my_view, parent, false)
        }else {
            LayoutInflater.from(parent.context).inflate(R.layout.last_view, parent, false)

        }
        return MyViewHolder(rootView)
    }

    override fun onBindViewHolder(holder: MyViewHolder, position: Int) {
        if (position == myDataset.size){
            holder.btnSubmit.setOnClickListener {
                mytestVIewModel.testSaving(nameAgeMap)
            }

        }else{
            holder.myTextview.text = myDataset[position]
            holder.mEditext.addTextChangedListener(object : TextWatcher {

                override fun afterTextChanged(s: Editable) {}

                override fun beforeTextChanged(s: CharSequence, start: Int,
                                               count: Int, after: Int) {
                }

                override fun onTextChanged(s: CharSequence, start: Int,
                                           before: Int, count: Int) {
                    nameAgeMap[myDataset[position]] = s.toString()
                }
            })
        }
    }

    override fun getItemCount() = myDataset.size + 1 //+1 is to take care of the button layout at the end of the RecyclerView

    override fun getItemViewType(position: Int): Int {
      return  if (position == myDataset.size) VIEW_TYPE_FOOTER
        else VIEW_TYPE_CELL
    }


}