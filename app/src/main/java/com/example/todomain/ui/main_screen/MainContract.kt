package com.example.todomain.ui.main_screen

import android.content.Context
import com.example.todomain.app.data.entity.Todo
import javax.inject.Singleton

interface MainContract {

    interface View {
       // var context:Context
       // var presenter: Presenter?
        fun showMain(argument: List<Todo>)
    }

    interface Presenter {
        fun goToAddTodoPage(context: Context)
        fun mainFetched(argument: List<Todo>)
        fun requestMain(context: Context)
    }

    interface Interactor {
       // var presenter: Presenter?
        fun fetchMain(context: Context)
    }

    interface Router {
        companion object {
            fun configure(activity: MainActivity) {}
        }
         fun openTodoAddPage(context: Context)
    }
}