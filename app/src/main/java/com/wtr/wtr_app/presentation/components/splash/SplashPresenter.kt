package com.wtr.wtr_app.presentation.components.splash

import android.Manifest
import android.util.Log
import com.arellomobile.mvp.InjectViewState
import com.wtr.core.data.connection.ConnectionProvider
import com.wtr.core.data.connection.ConnectionState
import com.wtr.core.extensions.bind
import com.wtr.core.presentation.mvp.BasePresenter
import com.wtr.core.presentation.state.PrimaryState
import com.wtr.core.presentation.state.ViewState
import com.wtr.core.utils.permissions.PermissionHandler
import com.wtr.wtr_app.data.geo.model.LocationState
import com.wtr.wtr_app.domain.interactor.location.LocationInteractor
import ru.terrakok.cicerone.Router
import javax.inject.Inject

@InjectViewState
class SplashPresenter @Inject constructor(
        val router: Router,
        val permissionHandler: PermissionHandler,
          connectionProvider: ConnectionProvider,
        private val locationInteractor: LocationInteractor
) : BasePresenter<SplashState, SplashView<SplashState>>(connectionProvider) {

    private var splashState = SplashState()

    override fun processConnectionState(state: Boolean) {
        Log.d("sodfosdnoucn", "connection $state")
        if (state) {
            viewState.render(splashState.copy(primaryState = PrimaryState.Idle,
                    connectionState = ConnectionState.Connect))

        } else {
            viewState.render(splashState.copy(primaryState = PrimaryState.Error(null),
                    connectionState = ConnectionState.Disconnect))
        }
    }

    private fun findLocation() {
        locationInteractor.location()
                .doOnSubscribe {
                    viewState.render(splashState.copy(primaryState = PrimaryState.Loading,
                            locationState = LocationState.Progress)
                    )
                }
                .subscribe({
                    Log.d("pampasmpd", "succes $it ")
                    viewState.render(splashState.copy(
                            primaryState = PrimaryState.Data,
                            locationState = LocationState.Succes(
                                    it.latitude,
                                    it.longitude))
                    )
                }, {
                    it.printStackTrace()
                    viewState.render(splashState.copy(
                            primaryState = PrimaryState.Error(it.message),
                            locationState = LocationState.Failed(it))
                    )
                })
                .bind(compositeDisposable)
    }

    fun splashShowed() {
        permissionHandler.requestPermission(Manifest.permission.ACCESS_FINE_LOCATION)
                .subscribe({
                    when {
                        it.granted -> {
                            Log.d("asdasffdbcv", "$it")
                            findLocation()
                        }
                        it.shouldShowRequestPermissionRationale -> {
                        }
                        else -> {
                        }
                    }
                }, {
                    it.printStackTrace()
                })
    }
}

data class SplashState(
        override val primaryState: PrimaryState = PrimaryState.Idle,
        val connectionState: ConnectionState = ConnectionState.Connect,
        val locationState: LocationState = LocationState.Progress
) : ViewState