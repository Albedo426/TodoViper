package com.example.todomain.presenter

import android.util.Log
import com.example.todomain.entity.Todo
import com.example.todomain.view.main.MainContract
import com.example.todomain.view.todoAdd.TodoContract

class TodoPresenter :
    TodoContract.Presenter {
    override var view: TodoContract.View? = null
    override var interector: TodoContract.Interactor? = null
    override var router: TodoContract.Router? = null
    override fun addRequest(data: Todo) {
        interector?.addedTodo(data)
    }

}