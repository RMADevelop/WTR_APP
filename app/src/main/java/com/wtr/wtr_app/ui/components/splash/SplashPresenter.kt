package com.wtr.wtr_app.ui.components.splash

import com.arellomobile.mvp.InjectViewState
import com.wtr.core.data.connection.ConnectionProvider
import com.wtr.core.data.connection.ConnectionState
import com.wtr.core.presentation.mvp.BasePresenter
import com.wtr.core.utils.permissions.PermissionHandler
import com.wtr.wtr_app.data.geo.model.LocationState
import com.wtr.wtr_app.domain.interactor.splash.SplashInteractor
import ru.terrakok.cicerone.Router
import javax.inject.Inject

@InjectViewState
class SplashPresenter @Inject constructor(
        val router: Router,
        val permissionHandler: PermissionHandler,
        private val connectionProvider: ConnectionProvider,
        private val splashInteractor: SplashInteractor
) : BasePresenter<SplashView>() {

    lateinit var splashState: SplashState

    override fun onFirstViewAttach() {
        super.onFirstViewAttach()
        connectionProvider.observeConnection()
                .doOnNext { splashState.copy(connectionState = if (it) ConnectionState.Connect else ConnectionState.Disconnect) }
    splashInteractor.location()
    }
}

data class SplashState(
        val connectionState: ConnectionState = ConnectionState.Unknown,
        val locationState: LocationState = LocationState.Unknow
)