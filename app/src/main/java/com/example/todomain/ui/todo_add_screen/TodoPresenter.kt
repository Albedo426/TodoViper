package com.example.todomain.ui.todo_add_screen

import android.content.Context
import com.example.todomain.app.data.entity.Todo

class TodoPresenter :
    TodoContract.Presenter {
    override var view: TodoContract.View? = null
    override var interector: TodoContract.Interactor? = null
    override var router: TodoContract.Router? = null
    override fun addRequest(data: Todo,context: Context): Int {
        var id=0
        interector?.addedTodo(data,context).let{
            id= it?.toInt()!!
            router?.openMainPage(context)
        }
        return id
    }

}