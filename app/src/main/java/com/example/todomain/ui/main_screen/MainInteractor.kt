package com.example.todomain.ui.main_screen

import android.content.Context
import android.util.Log
import androidx.lifecycle.MutableLiveData
import com.example.todomain.app.data.dto.todo_get_dto.TodoDto
import com.example.todomain.app.data.dto.todo_get_dto.toTodo
import com.example.todomain.app.data.entity.Todo
import com.example.todomain.app.services.repository.api.TodoApiServices
import com.example.todomain.app.services.repository.room_database.TodoDataBase
import dagger.hilt.android.AndroidEntryPoint
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.disposables.CompositeDisposable
import io.reactivex.observers.DisposableSingleObserver
import io.reactivex.schedulers.Schedulers
import javax.inject.Inject
import javax.inject.Singleton

@Singleton
class MainInteractor @Inject constructor(private val todoApiServices:TodoApiServices ): MainContract.Interactor {
    private val disposse= CompositeDisposable()
    private lateinit var todolist: MutableLiveData<List<Todo>>
    override fun fetchMain(context: Context,todolist: MutableLiveData<List<Todo>>) {
        Log.e("TAG", "fetchMain: ", )
        this.todolist=todolist;
        getDataFromAPI(context);
    }
    override  var presenter: MainContract.Presenter? = null

    private fun getDataFromSQLite(context: Context){//çekilecekse diye ekledim ama çekme yapmadım
        val todoDatabase = TodoDataBase.invoke(context)
        showCountryies(todoDatabase.todoDao().getAllTodo())
    }
    private fun showCountryies(list: List<Todo>){
        //presenter!!.mainFetched(list)
        this.todolist.value=list
    }
    private fun getDataFromAPI(context:Context){
        disposse.add(
            todoApiServices.getData()
                .subscribeOn(Schedulers.newThread())//new thread vreya io // arka planda çalışması için//io dediği arka plan
                .observeOn(AndroidSchedulers.mainThread())//main Threadde çalışıcak
                .subscribeWith(object: DisposableSingleObserver<TodoDto>(){
                    override fun onSuccess(t: TodoDto) {
                       // storeInSQLite(t)
                        val list=t.data.map { it.attributes.toTodo() }
                       // Toast.makeText(getApplication(), "Api", Toast.LENGTH_SHORT).show()
                        storeInSQLite(list,context)
                        Log.e("TAG", "onSuccess: "+list.size)
                    }
                    override fun onError(e: Throwable) {
                        //countryLooding.value=false
                        Log.e("TAG", "onSuccess: ", e)
                    }

                })
        )
    }
    private fun storeInSQLite(list: List<Todo>,context: Context){
        val dao=TodoDataBase.invoke(context)
        dao.todoDao().deleteAll()
        val storageListLong= dao.todoDao().insertAll(*list.toTypedArray())//toTypedArray dizideki elemanları tek tek döntürür 1,2,3,4...n şeklinde
        showCountryies(list)
    }
}