package com.wtr.wtr_app.data.geo.model

sealed class LocationState {
    data class Failed(
            val throwable: Throwable
    ) : LocationState()

    data class Succes(
            val latitude: Double,
            val longitude: Double
    ) : LocationState()

    object Unknow : LocationState()
    object Progress : LocationState()
}