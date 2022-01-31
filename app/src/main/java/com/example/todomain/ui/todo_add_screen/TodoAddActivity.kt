package com.example.todomain.ui.todo_add_screen

import android.content.Context
import android.content.Intent
import android.os.Bundle
import com.example.todomain.R
import com.example.todomain.app.base.BaseActivity
import com.example.todomain.app.data.entity.Todo
import com.example.todomain.databinding.ActivityTodoAddBinding
import com.example.todomain.ui.main_screen.MainActivity

class TodoAddActivity : BaseActivity(), TodoContract.View {

    companion object {
        fun launch(context: Context) {
            val intent = Intent(context, TodoAddActivity::class.java)
            context.startActivity(intent)
        }
    }

    override var presenter: TodoContract.Presenter? = null
    override val context: Context = this
    private lateinit var binding: ActivityTodoAddBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        TodoRouter.configure(this)
        super.onCreate(savedInstanceState)
        binding = ActivityTodoAddBinding.inflate(layoutInflater)
        val view = binding.root
        setContentView(view)


        binding.floatingActionButton.setOnClickListener {
            presenter?.addRequest(Todo(binding.editTextTodo.text.toString().trim()),this)
            MainActivity.launch(this)
        }
    }
}