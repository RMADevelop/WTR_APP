package com.wtr.wtr_app.domain.interactor.location

import com.wtr.core.data.entity.Location
import com.wtr.core.domain.NoLastKnownLocation
import com.wtr.wtr_app.data.geo.LocationRepository
import io.reactivex.Single
import javax.inject.Inject

class LocationDomainInteractor @Inject constructor(
        private val locationRepository: LocationRepository
) : LocationInteractor {

    override fun location(): Single<Location> =
            locationRepository.location()
                    .onErrorResumeNext {
                        when (it) {
                            is NoLastKnownLocation -> locationRepository.observableLocation()
                                    .firstOrError()
                            else -> Single.error(it)
                        }
                    }
}