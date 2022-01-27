package com.example.todomain.ui.todo_add_screen

import android.content.Context
import com.example.todomain.app.data.entity.Todo
import com.example.todomain.app.services.repository.todo_database_repo.TodoDataBase
import com.example.todomain.ui.todo_add_screen.repostory.todo_todo_add_dao.TodoDAO

class TodoInteractor : TodoContract.Interactor {
    override var presenter: TodoContract.Presenter? = null
    override var todoDAO: TodoDAO? =null
    override fun addedTodo(data: Todo,context: Context): Long {
        //added todo eklendi
        /*
        val todoDatabase = TodoDataBase.invoke(context)
        return todoDatabase.todoDao().insert(data)
         */
        todoDAO?.insert(data,context).let {
            return it!!
        }

    }
}