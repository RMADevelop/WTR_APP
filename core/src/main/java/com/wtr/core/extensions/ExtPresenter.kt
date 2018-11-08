package com.wtr.core.extensions

import io.reactivex.disposables.CompositeDisposable
import io.reactivex.disposables.Disposable

fun Disposable.bind(compositeDisposable: CompositeDisposable) =
        compositeDisposable.add(this)