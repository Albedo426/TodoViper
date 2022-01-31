package com.example.todomain.ui.todo_add_screen.di

import com.example.todomain.app.services.repository.api.TodoApiServices
import com.example.todomain.ui.todo_add_screen.*
import com.google.gson.Gson
import dagger.Binds
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.components.ActivityComponent
import dagger.hilt.android.scopes.ActivityScoped
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@InstallIn(SingletonComponent::class)
@Module
class todoAddModule(){
    private val activity=TodoAddActivity()
    val view =activity
    @Singleton
    @Provides
    fun bindingMainInteractor(): TodoContract.Interactor{
        return TodoInteractor(TodoApiServices())
    }
    @Singleton
    @Provides
    fun bindingMainRouter():TodoContract.Router{
        return TodoRouter(activity)
    }
    @Singleton
    @Provides
    fun bindingMainPresenter(): TodoContract.Presenter{
        return  TodoPresenter(bindingMainInteractor(),bindingMainRouter())
    }

    @Singleton
    @Provides
    fun bindingMainView(): TodoContract.View {
        return activity
    }

}

