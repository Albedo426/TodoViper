package com.example.todomain.ui.main_screen.di

import com.example.todomain.app.services.repository.api.TodoApiServices
import com.example.todomain.ui.main_screen.*
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
class MyModule(){
    val activity=MainActivity()
    val view =activity
    @Singleton
    @Provides
    fun bindingMainInteractor():MainContract.Interactor{
        return MainInteractor(TodoApiServices())
    }
    @Singleton
    @Provides
    fun bindingMainRouter():MainContract.Router{
        return MainRouter(activity)
    }
    @Singleton
    @Provides
    fun bindingMainPresenter(): MainContract.Presenter{
        return  MainPresenter(bindingMainRouter(),bindingMainInteractor(),activity)
    }

    @Singleton
    @Provides
    fun bindingMainView(): MainContract.View {
        return MainActivity()
    }

}

