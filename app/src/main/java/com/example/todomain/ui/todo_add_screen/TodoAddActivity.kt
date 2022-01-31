package com.example.todomain.ui.todo_add_screen

import android.content.Context
import android.content.Intent
import android.os.Bundle
import com.example.todomain.R
import com.example.todomain.app.base.BaseActivity
import com.example.todomain.app.data.entity.Todo
import com.example.todomain.ui.main_screen.MainActivity
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.android.synthetic.main.activity_todo_add.*
import javax.inject.Inject

@AndroidEntryPoint
class TodoAddActivity : BaseActivity(), TodoContract.View {

    companion object {
        fun launch(context: Context) {
            val intent = Intent(context, TodoAddActivity::class.java)
            context.startActivity(intent)
        }
    }
    @Inject
    lateinit var presenter: TodoContract.Presenter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_todo_add)

        floatingActionButton.setOnClickListener {
            presenter.addRequest(Todo(editTextTodo.text.toString().trim()),this)
            MainActivity.launch(this)
        }
    }
}