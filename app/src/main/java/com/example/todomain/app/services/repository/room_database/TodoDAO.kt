package com.example.todomain.app.services.repository.room_database

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.Query
import com.example.todomain.app.data.entity.Todo
@Dao
interface TodoDAO {
    @Insert
    fun insert(student: Todo):Long

    @Insert
     fun insertAll(vararg contries:Todo):List<Long>

    @Query("delete  from todo ")
     fun deleteAll()

    @Query("SELECT * FROM todo")
    fun getAllTodo(): List<Todo>
}
