package com.example.todomain.ui.main_screen

import com.example.todomain.app.data.entity.Todo
import javax.inject.Inject

class MainPresenter(private val router: MainContract.Router, private val interector: MainInteractor) :
    MainContract.Presenter {
    var view: MainContract.View? = null
    override fun requestMain() {
        val view = view ?: return
        interector.fetchMain(view.context)
    }
    override fun mainFetched(argument:  List<Todo>) {//sor nasıl olucak enttitiynnin burda olmaması gerekiyor dto mu yapıcam
        view?.showMain(argument)
    }

    override fun goToAddTodoPage(){
        view?.context?.let { router.openTodoAddPage(it) }
    }
}
