package com.example.todomain.view.todoAdd

import android.content.Context
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import com.example.todomain.R
import com.example.todomain.entity.Todo
import com.example.todomain.router.TodoRouter
import com.example.todomain.view.main.MainActivity
import kotlinx.android.synthetic.main.activity_todo_add.*

class TodoAddActivity : AppCompatActivity(), TodoContract.View {

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
            presenter?.addRequest(Todo(editTextTodo.text.toString().trim()))
            MainActivity.launch(this)
        }
    }
}