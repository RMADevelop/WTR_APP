package com.wtr.wtr_app.presentation.activity

import com.arellomobile.mvp.InjectViewState
import com.wtr.core.data.connection.ConnectionProvider
import com.wtr.core.presentation.mvp.BasePresenter
import com.wtr.core.presentation.state.PrimaryState
import com.wtr.core.presentation.state.ViewState
import com.wtr.wtr_app.app.Screens
import ru.terrakok.cicerone.Router
import javax.inject.Inject

@InjectViewState
class MainPresenter @Inject constructor(
        private val router: Router,
        connecioProvider: ConnectionProvider
) : BasePresenter<MainState, MainView<MainState>>(connecioProvider) {
    override fun processConnectionState(state: Boolean) {
    }

    override fun onFirstViewAttach() {
        super.onFirstViewAttach()
        router.navigateTo(Screens.SPLASH_SCREEN_KEY)
    }
}

data class MainState(
        override val primaryState: PrimaryState = PrimaryState.Data
) : ViewState