package com.example.todomain.ui.main_screen

import android.content.Context
import android.content.Intent
import android.os.Bundle
import android.util.Log
import androidx.appcompat.app.AppCompatActivity
import androidx.databinding.DataBindingUtil
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.todomain.ui.main_screen.adapter.MainAdapter
import com.example.todomain.R
import com.example.todomain.app.base.BaseActivity
import com.example.todomain.app.data.entity.Todo
import com.example.todomain.databinding.ActivityMainBinding
import dagger.hilt.android.AndroidEntryPoint
import javax.inject.Inject

@AndroidEntryPoint
class MainActivity() : AppCompatActivity(), MainContract.View {
    //var binding :ActivityMainBinding?=null
    var binding :ActivityMainBinding?=null
    companion object {
        fun launch(context: Context) {
            val intent = Intent(context, MainActivity::class.java)
            context.startActivity(intent)
        }
    }
    @Inject
    lateinit var  presenter: MainContract.Presenter

    override fun onCreate(savedInstanceState: Bundle?) {
       // MainRouter.configure(this)
        super.onCreate(savedInstanceState)
        Log.e("TAG", "onCreate: ", )
       // setContentView(R.layout.activity_main)
        binding = ActivityMainBinding.inflate(layoutInflater)
        val view = binding?.root
        setContentView(view)
        // DataBindingUtil.setContentView(this,R.layout.activity_main)

        binding?.recyclerView?.layoutManager = LinearLayoutManager(this)
        presenter.requestMain(this)
        binding?.floatingActionButton2?.setOnClickListener {
            presenter.goToAddTodoPage(this)
        }
    }
    override fun showMain(argument: List<Todo>) {
        Log.e("TAG", "showMain: "+argument.size)
        val l =MainAdapter(argument)
        binding?.recyclerView?.adapter = MainAdapter(argument)
    }
}
