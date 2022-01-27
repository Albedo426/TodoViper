package com.example.todomain.router

import android.app.Activity
import android.content.Context
import com.example.todomain.interactor.MainInteractor
import com.example.todomain.presenter.MainPresenter
import com.example.todomain.view.main.MainContract
import com.example.todomain.view.main.MainActivity
import com.example.todomain.view.todoAdd.TodoAddActivity

class MainRouter: MainContract.Router {

    companion object {
        fun configure(activity: MainActivity) {
            val view = activity
            val presenter = MainPresenter()
            val interactor = MainInteractor()
            val router = MainRouter()

            view.presenter = presenter
            presenter.view = view
            presenter.router = router
            presenter.interector = interactor
            interactor.presenter = presenter
        }
    }
    override fun openTodoAddPage(context: Context) {
        TodoAddActivity.launch(context)
    }
}