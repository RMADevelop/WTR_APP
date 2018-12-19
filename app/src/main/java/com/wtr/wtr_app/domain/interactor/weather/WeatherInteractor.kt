package com.wtr.wtr_app.domain.interactor.weather

interface WeatherInteractor {
    fun loadWeather(lat: Double, lon: Double)
}