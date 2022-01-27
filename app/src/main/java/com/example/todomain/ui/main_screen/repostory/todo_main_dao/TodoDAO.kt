package com.example.todomain.ui.main_screen.repostory.todo_main_dao

import android.content.Context
import com.example.todomain.app.data.entity.Todo
import com.example.todomain.app.services.repository.todo_database_repo.TodoDataBase

class TodoDAO {
    fun getAllTodo(context: Context): List<Todo> {
        val todoDatabase = TodoDataBase.invoke(context)
        return todoDatabase.todoDao().getAllTodo()
    }
}