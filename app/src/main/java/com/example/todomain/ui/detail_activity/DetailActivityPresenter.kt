package com.example.todomain.ui.detail_activity

import android.os.Bundle
import androidx.fragment.app.FragmentTransaction
import com.example.todomain.ui.detail_activity.detail_fragment.DetailFragment

class DetailActivityPresenter() :
    DetailActivityContract.Presenter {
    override var router: DetailActivityContract.Router? = null
    override fun openDetail(fragment: FragmentTransaction,text:String) {
        val bundle = Bundle()
        bundle.putString("text",text)

        val myFragment= DetailFragment();
        myFragment.arguments=bundle

        router?.openTodoAddPage(fragment,myFragment)
    }


}
