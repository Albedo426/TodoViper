package com.example.todomain.ui.main_screen

import android.content.Context
import androidx.lifecycle.MutableLiveData
import com.example.todomain.app.data.entity.Todo
import javax.inject.Singleton
@Singleton
interface MainContract {
    @Singleton

    interface View {
        fun observeLiveData()
        // var presenter: Presenter?
        //fun showMain(argument: List<Todo>)
    }
    @Singleton

    interface Presenter {
        var todoList: MutableLiveData<List<Todo>>
        fun goToAddTodoPage(context: Context)
        fun requestMain(context: Context)
    }
    @Singleton

    interface Interactor {
        var presenter: Presenter?
        fun fetchMain(context: Context,todolist:MutableLiveData<List<Todo>>)
    }
    @Singleton

    interface Router {
        companion object {
            fun configure(activity: MainActivity) {}
        }
         fun openTodoAddPage(context: Context)
    }
}