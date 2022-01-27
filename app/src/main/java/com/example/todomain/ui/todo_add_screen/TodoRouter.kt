package com.example.todomain.ui.todo_add_screen

import android.content.Context
import com.example.todomain.ui.todo_add_screen.repostory.todo_todo_add_dao.TodoDAO

class TodoRouter : TodoContract.Router {

    companion object {
        fun configure(activity: TodoAddActivity) {
            val view = activity
            val presenter = TodoPresenter()
            val interactor = TodoInteractor()
            val router = TodoRouter()
            val dao = TodoDAO()
            view.presenter = presenter
            presenter.view = view
            presenter.router = router
            presenter.interector = interactor
            interactor.presenter = presenter
            interactor.todoDAO = dao
        }
    }
    override fun openMainPage(context: Context) {
        TodoAddActivity.launch(context)
    }

}