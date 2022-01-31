package com.example.todomain.ui.main_screen

import android.content.Context
import android.content.Intent
import android.os.Bundle
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.todomain.ui.main_screen.adapter.MainAdapter
import com.example.todomain.R
import com.example.todomain.app.base.BaseActivity
import com.example.todomain.app.data.entity.Todo
import com.example.todomain.databinding.ActivityMainBinding

class MainActivity() : BaseActivity(), MainContract.View {
    private lateinit var binding: ActivityMainBinding
    companion object {
        fun launch(context: Context) {
            val intent = Intent(context, MainActivity::class.java)
            context.startActivity(intent)
        }
    }
    override var presenter: MainContract.Presenter? = null
    override var context: Context =this
    override fun onCreate(savedInstanceState: Bundle?) {
        MainRouter.configure(this)
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        val view = binding.root
        setContentView(view)

        binding.recyclerView.layoutManager = LinearLayoutManager(this)
        presenter?.requestMain()

        binding.floatingActionButton2.setOnClickListener {
         presenter?.goToAddTodoPage()
        }

    }
    override fun showMain(argument: List<Todo>) {
        binding.recyclerView.adapter = MainAdapter(argument)
    }
}
