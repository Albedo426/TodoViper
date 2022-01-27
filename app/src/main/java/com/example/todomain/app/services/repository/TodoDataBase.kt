package com.example.todomain.app.services.repository

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import com.example.todomain.app.data.entity.Todo

@Database(entities = [Todo::class], version = 1)
abstract class TodoDataBase : RoomDatabase(){

    abstract fun todoDao(): TodoDAO

    companion object {
        private var instance: TodoDataBase? = null
        private val lock =Any()
        operator fun invoke(context:Context) = instance ?: synchronized(lock){
            instance?:makeDataBase(context).also {
                instance=it
            }
            //also bunu yaqp sonra da bunu yap demek eğer olmadıysa hiç yapmaz  olursa yapar gibi çalışır
        }
        //synchronized threadlardan sadece biri erişir  işlemi bitinde diğerine geçicek

        private fun makeDataBase(context: Context)= Room.databaseBuilder(
            context,
            TodoDataBase::class.java,
            "todo.db").allowMainThreadQueries().build()
        //databaseyi oluşturan şey bu
    }
}