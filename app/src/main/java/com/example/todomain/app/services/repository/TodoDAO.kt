package com.example.todomain.app.services.repository

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.Query
import com.example.todomain.app.data.entity.Todo
@Dao
interface TodoDAO {
    @Insert
    fun insert(student: Todo):Long

    @Query("SELECT * FROM todo")
    fun getAllTodo(): List<Todo>
}
