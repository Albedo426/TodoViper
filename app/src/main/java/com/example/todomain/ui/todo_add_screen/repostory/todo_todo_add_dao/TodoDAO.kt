package com.example.todomain.ui.todo_add_screen.repostory.todo_todo_add_dao

import android.content.Context
import androidx.room.Insert
import androidx.room.Query
import com.example.todomain.app.data.entity.Todo
import com.example.todomain.app.services.repository.todo_database_repo.TodoDataBase

class TodoDAO {
    fun insert(data: Todo,context: Context): Long {
        val todoDatabase = TodoDataBase.invoke(context)
        return todoDatabase.todoDao().insert(data)
    }


}