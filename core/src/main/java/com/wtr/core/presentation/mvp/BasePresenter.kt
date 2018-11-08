package com.wtr.core.presentation.mvp

import com.arellomobile.mvp.MvpPresenter
import io.reactivex.disposables.CompositeDisposable

class BasePresenter<V : BaseView> : MvpPresenter<V>() {

    val compositeDisposable = CompositeDisposable()

    override fun onDestroy() {
        super.onDestroy()
        compositeDisposable.dispose()
    }
}