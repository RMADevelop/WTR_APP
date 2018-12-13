package com.wtr.wtr_app.ui.components.weather

import com.wtr.core.data.connection.ConnectionProvider
import com.wtr.core.data.connection.ConnectionState
import com.wtr.core.data.entity.Location
import com.wtr.core.presentation.mvp.BasePresenter
import com.wtr.core.presentation.state.PrimaryState
import com.wtr.core.presentation.state.ViewState
import com.wtr.wtr_app.domain.interactor.location.LocationInteractor
import com.wtr.wtr_app.domain.interactor.weather.WeatherInteractor
import javax.inject.Inject

class WeatherPresenter @Inject constructor(
        val weatherInteractor: WeatherInteractor,
        val locationInteractor: LocationInteractor,
        connectionProvider: ConnectionProvider
) : BasePresenter<WeatherViewState, WeatherView>(connectionProvider) {

    private var weatherState = WeatherViewState()

    override fun processConnectionState(state: Boolean) {
    }

    fun processStart(location: Location?) {
        location?.let { loadWeather(it) } ?: openBottom()
    }

    private fun loadWeather(location: Location) {

    }

    private fun openBottom() {
        viewState.render(
                weatherState.copy(
                        primaryState = PrimaryState.Data,
                        isOpened = true
                )
        )
    }
}

data class WeatherViewState(
        override val primaryState: PrimaryState = PrimaryState.Idle,
        val connectionState: ConnectionState = ConnectionState.Unknown,
        val isOpened: Boolean = false
) : ViewState