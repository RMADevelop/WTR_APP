package com.wtr.wtr_app.domain.interactor.location.model

data class LocationDomain(
        val latitude: Double,
        val longitude: Double
)

data class LocationInfoDomain(
        val locationDomain: LocationDomain?,
        val availability: Boolean = true
)
