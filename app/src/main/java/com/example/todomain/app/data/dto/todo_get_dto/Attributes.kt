package com.example.todomain.app.data.dto.todo_get_dto

import com.example.todomain.app.data.entity.Todo

data class Attributes(
    val createdAt: String,
    val publishedAt: String,
    val text: String,
    val updatedAt: String)


fun Attributes.toTodo(): Todo {
    return Todo(
        text = text
    )
}