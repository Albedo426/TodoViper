package com.example.todomain.ui.detail_activity

import androidx.fragment.app.FragmentTransaction
import com.example.todomain.ui.detail_activity.detail_fragment.DetailFragment
import com.example.todomain.ui.main_screen.MainActivity

interface DetailActivityContract {

    interface View {
       // var context:Context
        var presenter: Presenter?
        fun showData()
    }
    interface Presenter {
        var router: Router?
        fun openDetail(fragment: FragmentTransaction, text:String);
    }
    interface Interactor {
      //  var presenter: Presenter?
    }
    interface Router {
        companion object {
            fun configure(activity: MainActivity) {}
        }
         fun openTodoAddPage(fragment: FragmentTransaction,myFragment: DetailFragment)
    }
}