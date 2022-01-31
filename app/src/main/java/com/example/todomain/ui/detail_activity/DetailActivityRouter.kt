package com.example.todomain.ui.detail_activity

import androidx.fragment.app.FragmentTransaction
import com.example.todomain.R
import com.example.todomain.ui.detail_activity.detail_fragment.DetailFragment

class DetailActivityRouter: DetailActivityContract.Router {

    companion object {
        fun configure(activity: DetailActivity) {
            val view = activity
            val presenter = DetailActivityPresenter()
            val router = DetailActivityRouter()
            view.presenter = presenter
            presenter.router = router
        }
    }
    override fun openTodoAddPage(fragment: FragmentTransaction,myFragment:DetailFragment) {
        fragment.replace(R.id.fragmentContainerView,myFragment)
        fragment.commit()
    }
}