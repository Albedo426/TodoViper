package com.example.todomain.ui.main_screen

import android.content.Context
import com.example.todomain.app.data.entity.Todo
import com.example.todomain.app.services.repository.todo_database_repo.TodoDataBase
import com.example.todomain.ui.main_screen.repostory.todo_main_dao.TodoDAO

//Interactor repodan veya servisten veri isteyen kısımdır burda da veri çekilebilir bir class aracılığı ile
//entitiyler burda kullanılır
class MainInteractor() : MainContract.Interactor {
    override var todoDAO: TodoDAO? =null
    override fun fetchMain(context: Context) {
        /*
        val todoDatabase = TodoDataBase.invoke(context)
        return todoDatabase.todoDao().getAllTodo()
        */
        presenter?.mainFetched(todoDAO?.getAllTodo(context) as ArrayList<Todo>)
    }
    override var presenter: MainContract.Presenter? = null
}