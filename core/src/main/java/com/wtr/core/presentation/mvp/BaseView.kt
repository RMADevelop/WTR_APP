package com.wtr.core.presentation.mvp

import com.arellomobile.mvp.MvpView
import com.wtr.core.presentation.state.ViewState

interface BaseView<VS : ViewState> : MvpView {
    fun render(state: VS)
}