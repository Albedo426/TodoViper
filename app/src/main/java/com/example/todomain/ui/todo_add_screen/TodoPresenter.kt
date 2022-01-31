package com.example.todomain.ui.todo_add_screen

import android.content.Context
import com.example.todomain.app.data.entity.Todo
import javax.inject.Inject
import javax.inject.Singleton

@Singleton
class TodoPresenter @Inject constructor(private val interector: TodoContract.Interactor,private val router: TodoContract.Router) :
    TodoContract.Presenter {
    override fun addRequest(data: Todo,context: Context): Int {
        var id=0
        interector.addedTodo(data,context).let{
            id= it.toInt()
            router.openMainPage(context)
        }
        return id
    }

}