package com.example.todomain.ui.todo_add_screen

import android.content.Context
import com.example.todomain.app.data.entity.Todo
import com.example.todomain.app.services.repository.TodoDataBase

class TodoInteractor : TodoContract.Interactor {
    override var presenter: TodoContract.Presenter? = null
    override fun addedTodo(data: Todo,context: Context): Long {
        //added todo eklendi
        val todoDatabase = TodoDataBase.invoke(context)
        return todoDatabase.todoDao().insert(data)
    }
}