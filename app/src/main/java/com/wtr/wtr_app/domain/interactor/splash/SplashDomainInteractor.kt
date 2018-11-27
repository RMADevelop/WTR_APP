package com.wtr.wtr_app.domain.interactor.splash

import com.wtr.wtr_app.data.geo.LocationRepository
import javax.inject.Inject

class SplashDomainInteractor @Inject constructor(
        val locationProvider: LocationRepository
) : SplashInteractor {

    override fun location() {

    }
}