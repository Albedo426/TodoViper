package com.example.todomain.view.todoAdd

import android.app.Activity
import android.content.Context
import com.example.todomain.entity.Todo

interface TodoContract {

    interface View {
        val context: Context
        var presenter: Presenter?
    }

    interface Presenter {
        var view: View?
        var interector: Interactor?
        var router: Router?
        fun addRequest(data:Todo)
    }

    interface Interactor {
        var presenter: Presenter?
        fun addedTodo(data:Todo)
    }

    interface Router {
        companion object {
            fun configure(activity: TodoAddActivity) {}
        }
    }
}