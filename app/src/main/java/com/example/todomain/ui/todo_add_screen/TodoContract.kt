package com.example.todomain.ui.todo_add_screen

import android.content.Context
import com.example.todomain.app.entity.Todo

interface TodoContract {

    interface View {
        val context: Context
        var presenter: Presenter?
    }

    interface Presenter {
        var view: View?
        var interector: Interactor?
        var router: Router?
        fun addRequest(data:Todo,context: Context)
    }

    interface Interactor {
        var presenter: Presenter?
        fun addedTodo(data:Todo,context: Context)
    }

    interface Router {
        companion object {
            fun configure(activity: TodoAddActivity) {}
        }
    }
}