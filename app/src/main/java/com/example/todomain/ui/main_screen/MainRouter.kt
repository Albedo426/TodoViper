package com.example.todomain.ui.main_screen

import android.content.Context
import androidx.room.Dao
import com.example.todomain.ui.main_screen.repostory.todo_main_dao.TodoDAO
import com.example.todomain.ui.todo_add_screen.TodoAddActivity
//yönlendirme işlemi yapılır
//ben burda bağlama işlemlerini de yaptım normalde app/di nin altında başlangıcı yapılmalı
//sonrasında bu klasörde di diye bir klasör açılıp inject işlemleri yapılır
class MainRouter: MainContract.Router {

    companion object {
        fun configure(activity: MainActivity) {
            val view = activity
            val presenter = MainPresenter()
            val interactor = MainInteractor()
            val router = MainRouter()
            val Dao = TodoDAO()
            view.presenter = presenter
            presenter.view = view
            presenter.router = router
            presenter.interector = interactor
            interactor.presenter = presenter
            interactor.todoDAO = Dao
        }
    }
    override fun openTodoAddPage(context: Context) {
        TodoAddActivity.launch(context)
    }
}