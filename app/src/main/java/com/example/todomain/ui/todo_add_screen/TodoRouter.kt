package com.example.todomain.ui.todo_add_screen

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