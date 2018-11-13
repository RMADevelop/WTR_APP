package com.wtr.wtr_app.ui.activity

import com.wtr.core.presentation.mvp.BasePresenter
import ru.terrakok.cicerone.Router
import javax.inject.Inject

class MainPresenter @Inject constructor(
        val router: Router
) : BasePresenter<MainView>() {
}