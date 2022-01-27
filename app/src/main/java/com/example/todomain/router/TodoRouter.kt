package com.example.todomain.router

import android.content.Context
import com.example.todomain.interactor.TodoInteractor
import com.example.todomain.presenter.TodoPresenter
import com.example.todomain.view.todoAdd.TodoAddActivity
import com.example.todomain.view.todoAdd.TodoContract

class TodoRouter : TodoContract.Router {

    companion object {
        fun configure(activity: TodoAddActivity) {
            val view = activity
            val presenter = TodoPresenter()
            val interactor = TodoInteractor()
            val router = TodoRouter()

            view.presenter = presenter
            presenter.view = view
            presenter.router = router
            presenter.interector = interactor
            interactor.presenter = presenter
        }
    }

}