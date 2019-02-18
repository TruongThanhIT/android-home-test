package com.thanht.hometest.ui

import com.thanht.hometest.models.KeyWordModel

interface KeyWordView {

    fun showLoading()

    fun hideLoading()

    fun render(keywords: List<KeyWordModel>)

    fun showError()

}