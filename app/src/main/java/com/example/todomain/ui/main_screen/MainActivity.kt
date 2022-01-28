package com.example.todomain.ui.main_screen

import android.content.Context
import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.todomain.ui.main_screen.adapter.MainAdapter
import com.example.todomain.R
import com.example.todomain.app.base.BaseActivity
import com.example.todomain.app.data.entity.Todo
import kotlinx.android.synthetic.main.activity_main.*
import javax.inject.Inject
class MainActivity() : AppCompatActivity(), MainContract.View {

    companion object {
        fun launch(context: Context) {
            val intent = Intent(context, MainActivity::class.java)
            context.startActivity(intent)
        }
    }
    var presenter: MainContract.Presenter? = null
    override var context: Context =this

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
    override fun showMain(argument: List<Todo>) {
        recyclerView?.adapter = MainAdapter(argument)
    }
}
