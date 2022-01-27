package com.example.todomain.ui.todo_add_screen

import android.content.Context
import android.content.Intent
import android.os.Bundle
import com.example.todomain.R
import com.example.todomain.app.base.BaseActivity
import com.example.todomain.app.data.entity.Todo
import com.example.todomain.ui.main_screen.MainActivity
import kotlinx.android.synthetic.main.activity_todo_add.*

class TodoAddActivity : BaseActivity(), TodoContract.View {

    companion object {
        fun launch(context: Context) {
            val intent = Intent(context, TodoAddActivity::class.java)
            context.startActivity(intent)
        }
    }

    override var presenter: TodoContract.Presenter? = null
    override val context: Context = this

    override fun onCreate(savedInstanceState: Bundle?) {
        TodoRouter.configure(this)
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_todo_add)

        floatingActionButton.setOnClickListener {
            presenter?.addRequest(Todo(editTextTodo.text.toString().trim()),this)
            MainActivity.launch(this)
        }
    }
}