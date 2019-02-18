package com.thanht.hometest.ui

import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.support.v7.widget.LinearLayoutManager
import android.view.View
import com.thanht.hometest.R
import com.thanht.hometest.models.KeyWordModel
import com.thanht.hometest.presenters.KeyWordPresenter
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity(), KeyWordView {

    private var keywordList: ArrayList<KeyWordModel> = ArrayList()
    private val presenter: KeyWordPresenter = KeyWordPresenter()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        rvKeyword.layoutManager = LinearLayoutManager(this, LinearLayoutManager.HORIZONTAL, false)
        rvKeyword.adapter = KeyWordAdapter(keywordList = keywordList, context = this)

        presenter.onAttachView(this)
        addEvents()
        loadData()
    }

    private fun loadData() {
        presenter.getKeyWords()
    }

    private fun addEvents() {
        tvError.setOnClickListener { loadData() }
    }

    override fun showLoading() {
        rvKeyword?.visibility = View.GONE
        pbLoading?.visibility = View.VISIBLE
        tvError?.visibility = View.GONE
    }

    override fun hideLoading() {
        rvKeyword?.visibility = View.VISIBLE
        pbLoading?.visibility = View.GONE
    }

    override fun render(keywords: List<KeyWordModel>) {
        keywordList.clear()
        keywordList.addAll(keywords)
        rvKeyword.adapter?.notifyDataSetChanged()
    }

    override fun showError() {
        pbLoading?.visibility = View.GONE
        rvKeyword?.visibility = View.GONE
        tvError?.visibility = View.VISIBLE
    }

    override fun onDestroy() {
        presenter.onDetachView()
        super.onDestroy()
    }

}
