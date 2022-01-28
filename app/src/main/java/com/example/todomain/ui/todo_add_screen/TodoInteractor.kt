package com.example.todomain.ui.todo_add_screen

import android.content.Context
import com.example.todomain.app.data.dto.todo_get_dto.Data
import com.example.todomain.app.data.entity.Todo
import com.example.todomain.app.services.repository.api.TodoApiServices
import com.example.todomain.app.services.repository.room_database.TodoDataBase
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.disposables.CompositeDisposable
import io.reactivex.observers.DisposableSingleObserver
import io.reactivex.schedulers.Schedulers

class TodoInteractor : TodoContract.Interactor {
    override var presenter: TodoContract.Presenter? = null

    private val todoApiServices=TodoApiServices()
    private val disposse= CompositeDisposable()
    override fun addedTodo(data: Todo,context: Context): Long {
        //added todo eklendi
        fullInsert(data,context)
        return 0
    }

    private fun fullInsert(data: Todo,context: Context){
        insertDataFromStorage(data,context)
        insertDataFromAPI(data)
    }
    private fun insertDataFromStorage(data: Todo,context: Context){
        val todoDatabase = TodoDataBase.invoke(context)
         todoDatabase.todoDao().insert(data)
    }
    private fun insertDataFromAPI(data: Todo){
        disposse.add(
            todoApiServices.insertData(data)
                .subscribeOn(Schedulers.newThread())//new thread vreya io // arka planda çalışması için//io dediği arka plan
                .observeOn(AndroidSchedulers.mainThread())//main Threadde çalışıcak
                .subscribeWith(object: DisposableSingleObserver<Data>(){
                    override fun onSuccess(t: Data) {
                        //storeInSQLite(t)
                       // Toast.makeText(getApplication(), "Api", Toast.LENGTH_SHORT).show()
                    }
                    override fun onError(e: Throwable) {
                        //countryLooding.value=false
                        //countryError.value=true
                        e.printStackTrace()
                    }

                })
        )
    }
}