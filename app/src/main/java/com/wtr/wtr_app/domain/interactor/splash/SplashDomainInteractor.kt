package com.wtr.wtr_app.domain.interactor.splash

import com.wtr.wtr_app.data.geo.LocationProvider
import javax.inject.Inject

class SplashDomainInteractor @Inject constructor(
        val locationProvider: LocationProvider
) : SplashInteractor {

    override fun location() {

    }
}