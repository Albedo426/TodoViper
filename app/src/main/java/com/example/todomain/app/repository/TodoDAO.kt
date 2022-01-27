package com.example.todomain.app.repository

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.Query
import com.example.todomain.app.entity.Todo
@Dao

interface TodoDAO {
    @Insert
    fun insert(student: Todo)

    @Query("SELECT * FROM todo")
    fun getAllTodo(): List<Todo>
}
