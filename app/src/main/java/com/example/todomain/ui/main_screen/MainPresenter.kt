package com.example.todomain.ui.main_screen

import android.content.Context
import android.util.Log
import androidx.lifecycle.MutableLiveData
import com.example.todomain.app.data.entity.Todo
import dagger.hilt.android.AndroidEntryPoint
import javax.inject.Inject
import javax.inject.Singleton

@Singleton
class MainPresenter @Inject constructor(private val router: MainContract.Router, private val interector: MainContract.Interactor) :
    MainContract.Presenter {
    override var todoList= MutableLiveData<List<Todo>>()
    override fun requestMain(context: Context) {
        Log.e("TAG", "MainPresenter: ", )
        interector.presenter=this
        interector.fetchMain(context,todoList)
    }

    override fun goToAddTodoPage(context: Context){
         router.openTodoAddPage(context)
    }

}
