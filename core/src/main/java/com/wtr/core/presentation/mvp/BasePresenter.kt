package com.wtr.core.presentation.mvp

import com.arellomobile.mvp.MvpPresenter
import com.wtr.core.data.connection.ConnectionProvider
import com.wtr.core.extensions.bind
import com.wtr.core.presentation.state.ViewState
import io.reactivex.disposables.CompositeDisposable

abstract class BasePresenter<VS : ViewState, V : BaseView<VS>>(
        val connectionProvider: ConnectionProvider
) : MvpPresenter<V>() {

    val compositeDisposable = CompositeDisposable()

    override fun onDestroy() {
        super.onDestroy()
        compositeDisposable.dispose()
    }

    protected fun observeConnection() {
        connectionProvider.observeConnection()
                .distinctUntilChanged()
                .doOnNext { processConnectionState(it) }
                .subscribe()
                .bind(compositeDisposable)
    }

    abstract fun processConnectionState(state: Boolean)
}