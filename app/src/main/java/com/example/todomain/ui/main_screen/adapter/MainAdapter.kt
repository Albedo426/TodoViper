package com.example.todomain.ui.main_screen.adapter


import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.recyclerview.widget.RecyclerView
import com.example.todomain.R
import com.example.todomain.databinding.MainItemListBinding
import com.example.todomain.app.data.entity.Todo
import com.example.todomain.ui.detail_activity.DetailActivity
import kotlinx.android.synthetic.main.activity_todo_add.view.*
import kotlinx.android.synthetic.main.activity_todo_add.view.textView
import kotlinx.android.synthetic.main.main_item_list.view.*

class MainAdapter(val newsList: List<Todo>) : RecyclerView.Adapter<MainAdapter.ViewHolder>(),TodoOnClick {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        //val view=LayoutInflater.from(parent.context).inflate(R.layout.item_country,parent,false)
        val itemBinding = MainItemListBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return ViewHolder(itemBinding)
    }
    override fun getItemCount(): Int {
        return newsList.count()
    }

    override fun onBindViewHolder(view: ViewHolder, p1: Int) {
        view.bind(newsList[p1])
        view.view.listener=this
    }

    class ViewHolder(var view: MainItemListBinding):RecyclerView.ViewHolder(view.root) {
        fun bind(todo: Todo) {
            view.myModel=todo
        }
    }
    override fun onTodoOnClick(v: View) {
        DetailActivity.launch(v.context,v.txt.text.toString())//nasıl??
    }
}