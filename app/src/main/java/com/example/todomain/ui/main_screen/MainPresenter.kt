package com.example.todomain.ui.main_screen

import android.content.Context
import com.example.todomain.app.entity.Todo

class MainPresenter() :
    MainContract.Presenter {
    override var view: MainContract.View? = null
    override var interector: MainContract.Interactor? = null
    override var router: MainContract.Router? = null


    override fun requestMain() {
        val view = view ?: return
        interector?.fetchMain(view.context)
    }
    override fun mainFetched(argument:  ArrayList<Todo>) {//sor nasıl olucak enttitiynnin burda olmaması gerekiyor dto mu yapıcam
        view?.showMain(argument)
    }

    override fun goToAddTodoPage(){
        view?.context?.let { router?.openTodoAddPage(it) }
    }
}
