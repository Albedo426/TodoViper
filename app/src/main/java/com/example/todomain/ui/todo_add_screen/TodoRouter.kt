package com.example.todomain.ui.todo_add_screen

import android.content.Context
import com.example.todomain.ui.main_screen.MainActivity
import javax.inject.Singleton

@Singleton
class TodoRouter(private val activity: TodoAddActivity) : TodoContract.Router {

    override fun openMainPage(context: Context) {
        MainActivity.launch(context)
    }

}