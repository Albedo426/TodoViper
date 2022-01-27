package com.example.todomain.ui.todo_add_screen

import com.example.todomain.app.entity.Todo

class TodoPresenter :
    TodoContract.Presenter {
    override var view: TodoContract.View? = null
    override var interector: TodoContract.Interactor? = null
    override var router: TodoContract.Router? = null
    override fun addRequest(data: Todo) {
        interector?.addedTodo(data)
    }

}