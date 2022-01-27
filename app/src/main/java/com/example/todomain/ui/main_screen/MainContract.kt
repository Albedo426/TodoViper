package com.example.todomain.ui.main_screen

import android.content.Context
import com.example.todomain.app.entity.Todo

interface MainContract {

    interface View {
        val contxt: Context
        var presenter: Presenter?
        fun showMain(argument: ArrayList<Todo>)
    }
    interface Presenter {
        fun goToAddTodoPage();
        fun mainFetched(argument: ArrayList<Todo>)
        var view: View?
        var interector: Interactor?
        var router: Router?
        fun requestMain()
    }
    interface Interactor {
        var presenter: Presenter?
        fun fetchMain(context: Context)
    }
    interface Router {
        companion object {
            fun configure(activity: MainActivity) {}
        }
         fun openTodoAddPage(context: Context)
    }
}