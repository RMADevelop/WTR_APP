package com.wtr.wtr_app.ui.components.splash

import com.arellomobile.mvp.InjectViewState
import com.wtr.core.presentation.mvp.BasePresenter
import ru.terrakok.cicerone.Router

@InjectViewState
class SplashPresenter(
        val router: Router
) : BasePresenter<SplashView>() {

}