package com.example.todomain.ui.main_screen

import android.content.Context
import com.example.todomain.app.data.entity.Todo
import com.example.todomain.app.services.repository.TodoDataBase

class MainInteractor : MainContract.Interactor {

    override fun fetchMain(context: Context) {
        val todoDatabase = TodoDataBase.invoke(context)
        val todos: ArrayList<Todo> =
           todoDatabase.todoDao().getAllTodo() as ArrayList<Todo>
        presenter?.mainFetched(todos)
    }
    override var presenter: MainContract.Presenter? = null
}