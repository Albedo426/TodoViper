package com.example.todomain.ui.detail_activity

import android.content.Context
import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.example.todomain.databinding.ActivityDetailBinding

class DetailActivity : AppCompatActivity(),DetailActivityContract.View  {
    private lateinit var binding: ActivityDetailBinding
    override var presenter: DetailActivityContract.Presenter? = null
    override fun showData() {
        val fragment = supportFragmentManager.beginTransaction()
        intent.getStringExtra("text")?.let { presenter?.openDetail(fragment, it) }
    }

    companion object {
        fun launch(context: Context,todo: String) {
            val intent = Intent(context, DetailActivity::class.java)
            intent.putExtra("text",todo)
            context.startActivity(intent)
        }
    }
    override fun onCreate(savedInstanceState: Bundle?) {
        DetailActivityRouter.configure(this)
        super.onCreate(savedInstanceState)
        binding = ActivityDetailBinding.inflate(layoutInflater)
        val view = binding.root
        setContentView(view)
        showData()
    }

}