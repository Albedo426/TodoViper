package com.example.todomain.ui.main_screen

import android.content.Context
import com.example.todomain.ui.todo_add_screen.TodoAddActivity

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