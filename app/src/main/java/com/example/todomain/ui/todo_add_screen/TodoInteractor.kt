package com.example.todomain.ui.todo_add_screen

import android.util.Log
import com.example.todomain.app.entity.Todo

class TodoInteractor : TodoContract.Interactor {
    override var presenter: TodoContract.Presenter? = null
    override fun addedTodo(data: Todo) {
        //added todo eklendi
        Log.e("mytodo", "addedTodo: "+data.title )
    }

}