package com.example.todomain.ui.todo_add_screen

import android.content.Context
import com.example.todomain.app.data.entity.Todo

interface TodoContract {

    interface View {
        val context: Context
        var presenter: Presenter?
    }

    interface Presenter {
        var view: View?
        var interector: Interactor?
        var router: Router?
        fun addRequest(data:Todo,context: Context):Int
    }

    interface Interactor {
        var presenter: Presenter?
        fun addedTodo(data:Todo,context: Context):Long
    }

    interface Router {
        companion object {
            fun configure(activity: TodoAddActivity) {}
        }
        fun openMainPage(context: Context)
    }
}