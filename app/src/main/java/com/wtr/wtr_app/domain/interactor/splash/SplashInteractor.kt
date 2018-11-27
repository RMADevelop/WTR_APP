package com.wtr.wtr_app.domain.interactor.splash

import java.util.*

interface SplashInteractor {

    fun location():Observable<Location>
}