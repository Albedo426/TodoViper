package com.example.todomain.ui.main_screen

import android.content.Context
import com.example.todomain.app.services.repository.api.TodoApiServices
import com.example.todomain.ui.todo_add_screen.TodoAddActivity

class MainRouter(private val activity: MainActivity): MainContract.Router {

    companion object {
        fun configure(activity: MainActivity) {
            val view = activity
            val interactor = MainInteractor(TodoApiServices())//MainContract.interactor çağırılınca /7MainInteractor gelicek
            val router = MainRouter(activity)
            val presenter = MainPresenter(router,interactor)
            view.presenter = presenter
            presenter.view = view
            interactor.presenter = presenter
        }
    }
    override fun openTodoAddPage(context: Context) {
        TodoAddActivity.launch(context)
    }
}