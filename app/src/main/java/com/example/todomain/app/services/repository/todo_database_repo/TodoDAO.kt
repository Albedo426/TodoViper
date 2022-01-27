package com.example.todomain.app.services.repository.todo_database_repo

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.Query
import com.example.todomain.app.data.entity.Todo
@Dao
interface TodoDAO {
    @Insert
    fun insert(todo: Todo):Long

    @Query("SELECT * FROM todo")
    fun getAllTodo(): List<Todo>
}
