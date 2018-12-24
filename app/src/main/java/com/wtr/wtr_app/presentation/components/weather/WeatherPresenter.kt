package com.wtr.wtr_app.presentation.components.weather

import android.util.Log
import com.arellomobile.mvp.InjectViewState
import com.wtr.core.data.connection.ConnectionProvider
import com.wtr.core.data.connection.ConnectionState
import com.wtr.core.presentation.mvp.BasePresenter
import com.wtr.core.presentation.state.PrimaryState
import com.wtr.core.presentation.state.ViewState
import com.wtr.wtr_app.domain.interactor.weather.WeatherInteractor
import com.wtr.wtr_app.presentation.components.weather.model.LocationPresentation
import javax.inject.Inject

@InjectViewState
class WeatherPresenter @Inject constructor(
        private val weatherInteractor: WeatherInteractor,
        connectionProvider: ConnectionProvider
) : BasePresenter<WeatherViewState, WeatherView>(connectionProvider) {

    private var weatherState = WeatherViewState()

    override fun processConnectionState(state: Boolean) {
    }

    fun processLocation(location: LocationPresentation) {
        weatherInteractor.loadWeather(location.latitude, location.longitude)
        viewState.render(
                weatherState.copy(
                        primaryState = PrimaryState.Data,
                        mapIsOpened = true,
                        locationPresentation = location
                )
        )
    }

    fun emptyStart() {
        showMap()
    }

    private fun showMap() {
        viewState.render(
                weatherState.copy(
                        primaryState = PrimaryState.Data,
                        mapIsOpened = true
                )
        )
    }
}

data class WeatherViewState(
        override val primaryState: PrimaryState = PrimaryState.Idle,
        val connectionState: ConnectionState = ConnectionState.Unknown,
        val mapIsOpened: Boolean = false,
        val locationPresentation: LocationPresentation? = null
) : ViewState