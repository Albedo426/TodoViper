package com.example.todomain.interactor

import android.content.Context
import com.example.todomain.entity.Todo
import com.example.todomain.view.main.MainContract

class MainInteractor : MainContract.Interactor {

    override fun fetchMain(context: Context) {
        val service = ArrayList<Todo>()
        service.add(Todo("Text"))
        service.add(Todo("Text"))
        service.add(Todo("Text"))
        service.add(Todo("Text"))
        service.add(Todo("Text"))
        service.add(Todo("Text"))
        val entity  =  ArrayList<Todo>(service)
        presenter?.mainFetched(entity)
    }
    override var presenter: MainContract.Presenter? = null
}