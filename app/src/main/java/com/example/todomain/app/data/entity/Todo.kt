package com.example.todomain.app.data.entity

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey
import com.example.todomain.app.data.dto.todo_add_dto.Data
import com.example.todomain.app.data.dto.todo_add_dto.TodoSender

@Entity(tableName = "todo")
data class Todo(

    @ColumnInfo(name = "text")
    val text: String
    ){
    @PrimaryKey(autoGenerate = true)
    @ColumnInfo(name = "todoId")
    var todoId: Int = 0
}
fun Todo.toTodoSender(): TodoSender {
    return TodoSender(Data(text)
    )
}
