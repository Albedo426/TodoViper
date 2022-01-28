package com.example.todomain.app.data.dto.todo_get_dto

data class Pagination(
    val page: Int,
    val pageCount: Int,
    val pageSize: Int,
    val total: Int
)