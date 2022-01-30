package com.example.todomain.ui.main_screen

import android.content.Context
import android.util.Log
import com.example.todomain.app.data.entity.Todo
import dagger.hilt.android.AndroidEntryPoint
import javax.inject.Inject
import javax.inject.Singleton

@Singleton
class MainPresenter @Inject constructor(private val router: MainContract.Router, private val interector: MainContract.Interactor, private val view: MainContract.View) :
    MainContract.Presenter {

    override fun requestMain(context: Context) {
        Log.e("TAG", "MainPresenter: ", )
        interector.presenter=this
        interector.fetchMain(context)
    }
    override fun mainFetched(argument:  List<Todo>) {//sor nasıl olucak enttitiynnin burda olmaması gerekiyor dto mu yapıcam
        view.showMain(argument)
    }

    override fun goToAddTodoPage(context: Context){
         router.openTodoAddPage(context)
    }
}
