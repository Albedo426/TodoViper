package com.example.todomain.view.main

import android.content.Context
import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.todomain.adapter.MainAdapter
import com.example.todomain.R
import com.example.todomain.entity.Todo
import com.example.todomain.router.MainRouter
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity(), MainContract.View {

    companion object {
        fun launch(context: Context) {
            val intent = Intent(context, MainActivity::class.java)
            context.startActivity(intent)
        }
    }

    override var presenter: MainContract.Presenter? = null
    override val contxt: Context = this

    override fun onCreate(savedInstanceState: Bundle?) {
        MainRouter.configure(this)
        super.onCreate(savedInstanceState)

        setContentView(R.layout.activity_main)
        recyclerView?.layoutManager = LinearLayoutManager(this)
        presenter?.requestMain()

        floatingActionButton2.setOnClickListener {
         presenter?.goToAddTodoPage()
        }

    }
    override fun showMain(argument: ArrayList<Todo>) {
        recyclerView?.adapter = MainAdapter(argument)
    }
}
