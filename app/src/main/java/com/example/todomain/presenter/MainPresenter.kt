package com.example.todomain.presenter

import com.example.todomain.entity.Todo
import com.example.todomain.view.main.MainContract

class MainPresenter :
    MainContract.Presenter {
    override var view: MainContract.View? = null
    override var interector: MainContract.Interactor? = null
    override var router: MainContract.Router? = null

    override fun requestMain() {
        val view = view ?: return
        interector?.fetchMain(view.contxt)
    }
    override fun mainFetched(argument:  ArrayList<Todo>) {//sor nasıl olucak enttitiynnin burda olmaması gerekiyor dto mu yapıcam
        view?.showMain(argument)
    }

    override fun goToAddTodoPage(){
        view?.contxt?.let { router?.openTodoAddPage(it) }
    }
}
