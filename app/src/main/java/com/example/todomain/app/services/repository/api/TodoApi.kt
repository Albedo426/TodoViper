package com.example.todomain.app.services.repository.api

import com.example.todomain.app.data.dto.todo_add_dto.TodoSender
import com.example.todomain.app.data.dto.todo_get_dto.Data
import com.example.todomain.app.data.dto.todo_get_dto.TodoDto
import io.reactivex.Single
import retrofit2.http.Body
import retrofit2.http.GET
import retrofit2.http.POST

interface TodoApi {
    @GET("todos")
    fun getData(): Single<TodoDto>//liste içinde countryler fgeliyor
    //veriyi füncelliyip devamlı almak için observable
    //bir defa almak için  single

    @POST("todos")
    fun insertData(@Body data: TodoSender): Single<Data>//liste içinde countryler fgeliyor
    //veriyi füncelliyip devamlı almak için observable
    //bir defa almak için  single

}