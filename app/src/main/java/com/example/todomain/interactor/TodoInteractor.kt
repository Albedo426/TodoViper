package com.example.todomain.interactor

import android.content.Context
import android.util.Log
import com.example.todomain.entity.Todo
import com.example.todomain.view.main.MainContract
import com.example.todomain.view.todoAdd.TodoContract

class TodoInteractor : TodoContract.Interactor {
    override var presenter: TodoContract.Presenter? = null
    override fun addedTodo(data: Todo) {
        //added todo eklendi
        Log.e("mytodo", "addedTodo: "+data.title )
    }

}