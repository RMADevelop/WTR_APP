package com.wtr.wtr_app.domain.interactor.weather

import com.wtr.core.data.entity.Location

interface WeatherInteractor {
    fun loadWeather(location: Location)
}