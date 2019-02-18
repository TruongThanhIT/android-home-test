package com.thanht.hometest.presenters

import com.thanht.hometest.data.repositories.KeyWordRepositoryImpl
import com.thanht.hometest.ui.KeyWordView
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.disposables.CompositeDisposable
import io.reactivex.schedulers.Schedulers

class KeyWordPresenter {

    private val repository: KeyWordRepositoryImpl = KeyWordRepositoryImpl()
    private var view: KeyWordView? = null
    private val disposables: CompositeDisposable = CompositeDisposable()

    fun onAttachView(keyWordView: KeyWordView) {
        view = keyWordView
    }

    fun getKeyWords() {
        view?.apply {
            showLoading()
            disposables.add(
                repository.getKeyWords()
                    .subscribeOn(Schedulers.io())
                    .observeOn(AndroidSchedulers.mainThread())
                    .subscribe(
                        {
                            hideLoading()
                            render(it)
                        },
                        {
                            showError()
                        }
                    )
            )
        }
    }

    fun onDetachView() {
        if (!disposables.isDisposed) {
            disposables.dispose()
        }
        view = null
    }

}