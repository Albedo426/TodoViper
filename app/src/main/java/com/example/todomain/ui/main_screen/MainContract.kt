package com.example.todomain.ui.main_screen

import android.content.Context
import com.example.todomain.app.data.entity.Todo
import javax.inject.Singleton
@Singleton
interface MainContract {
    @Singleton

    interface View {
       // var context:Context
       // var presenter: Presenter?
        fun showMain(argument: List<Todo>)
    }
    @Singleton

    interface Presenter {
        fun goToAddTodoPage(context: Context)
        fun mainFetched(argument: List<Todo>)
        fun requestMain(context: Context)
    }
    @Singleton

    interface Interactor {
        var presenter: Presenter?
        fun fetchMain(context: Context)
    }
    @Singleton

    interface Router {
        companion object {
            fun configure(activity: MainActivity) {}
        }
         fun openTodoAddPage(context: Context)
    }
}