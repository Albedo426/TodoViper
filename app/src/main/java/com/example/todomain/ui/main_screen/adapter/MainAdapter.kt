package com.example.todomain.ui.main_screen.adapter


import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.recyclerview.widget.RecyclerView
import com.example.todomain.R
import com.example.todomain.databinding.MainItemListBinding
import com.example.todomain.app.entity.Todo

class MainAdapter(val newsList: ArrayList<Todo>) : RecyclerView.Adapter<MainAdapter.ViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        //val view=LayoutInflater.from(parent.context).inflate(R.layout.item_country,parent,false)
        val infilater=LayoutInflater.from(parent.context)
        val view =DataBindingUtil.inflate<MainItemListBinding>(infilater,R.layout.main_item_list,parent,false)
        return ViewHolder(view)
    }

    override fun getItemCount(): Int {
        return newsList.count()
    }

    override fun onBindViewHolder(p0: ViewHolder, p1: Int) {
        p0.view.txt.text = newsList[p1].title
    }

    class ViewHolder(var view: MainItemListBinding):RecyclerView.ViewHolder(view.root) {

    }
}