package com.example.todomain.ui.main_screen

import android.content.Context
import com.example.todomain.app.services.repository.api.TodoApiServices
import com.example.todomain.ui.todo_add_screen.TodoAddActivity
import javax.inject.Singleton

@Singleton
class MainRouter(private val activity: MainActivity): MainContract.Router {
    override fun openTodoAddPage(context: Context) {
        TodoAddActivity.launch(context)
    }
}