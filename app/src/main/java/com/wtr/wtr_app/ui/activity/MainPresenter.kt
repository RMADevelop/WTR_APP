package com.wtr.wtr_app.ui.activity

import com.wtr.core.presentation.mvp.BasePresenter
import com.wtr.wtr_app.app.Screens
import ru.terrakok.cicerone.Router
import javax.inject.Inject

class MainPresenter @Inject constructor(
        private val router: Router
) : BasePresenter<MainView>() {

    override fun onFirstViewAttach() {
        super.onFirstViewAttach()
        router.newRootScreen(Screens.SPLASH_SCREEN_KEY)
    }
}