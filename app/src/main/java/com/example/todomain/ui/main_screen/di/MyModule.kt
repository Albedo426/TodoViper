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

    @ActivityScoped
    @Provides
    fun bindingMainInteractor():MainContract.Interactor{
        return MainInteractor(TodoApiServices())
    }
    @ActivityScoped
    @Provides
    fun bindingMainRouter(mainActivity: MainActivity):MainContract.Router{
        return MainRouter(mainActivity)
    }
    @ActivityScoped
    @Provides
    fun bindingMainPresenter(mainActivity: MainActivity): MainContract.Presenter{
        return  MainPresenter(bindingMainRouter(mainActivity),bindingMainInteractor(),mainActivity)
    }

    @ActivityScoped
    @Provides
    fun bindingMainView(): MainContract.View {
        return MainActivity()
    }

}

