package com.example.todomain.app.data.entity

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "todo")
data class Todo(

    @ColumnInfo(name = "text")
    val text: String
    ){
    @PrimaryKey(autoGenerate = true)
    @ColumnInfo(name = "todoId")
    var todoId: Int = 0
}