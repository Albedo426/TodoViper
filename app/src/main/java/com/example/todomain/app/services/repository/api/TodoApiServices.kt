package com.example.todomain.app.services.repository.api

import com.example.todomain.app.data.dto.todo_get_dto.Data
import com.example.todomain.app.data.dto.todo_get_dto.TodoDto
import com.example.todomain.app.data.entity.Todo
import com.example.todomain.app.data.entity.toTodoSender
import io.reactivex.Single
import retrofit2.Retrofit
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory
import retrofit2.converter.gson.GsonConverterFactory

class TodoApiServices {
    private val BASE_URL="http://192.168.1.35:1337/api/"
    private val api= Retrofit.Builder()
        .baseUrl(BASE_URL)
        .addConverterFactory(GsonConverterFactory.create())
        .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
        .build()
        .create(TodoApi::class.java)

    fun getData(): Single<TodoDto> {
        return api.getData()
    }
    fun insertData(data: Todo): Single<Data> {
        return api.insertData(data.toTodoSender())
    }
}