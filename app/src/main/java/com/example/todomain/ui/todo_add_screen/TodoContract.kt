package com.example.todomain.ui.todo_add_screen

import android.content.Context
import com.example.todomain.app.data.entity.Todo
import javax.inject.Singleton

@Singleton
interface TodoContract {
    @Singleton
    interface View {
      //  val context: Context
       // var presenter: Presenter?
    }
    @Singleton
    interface Presenter {
        //var interector: Interactor?
        //var router: Router?
        fun addRequest(data:Todo,context: Context):Int
    }
    @Singleton
    interface Interactor {
       // var presenter: Presenter?
        fun addedTodo(data:Todo,context: Context):Long
    }
    @Singleton
    interface Router {

        fun openMainPage(context: Context)
    }
}