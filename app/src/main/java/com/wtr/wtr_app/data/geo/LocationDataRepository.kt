package com.wtr.wtr_app.data.geo

import android.content.Context
import com.google.android.gms.location.LocationRequest
import com.google.android.gms.location.LocationServices
import com.wtr.core.data.entity.Location
import com.wtr.core.utils.location.RxFusedLocationProvider
import com.wtr.core.utils.location.RxFusedLocationSingle
import io.reactivex.Observable
import io.reactivex.Single
import java.util.concurrent.TimeUnit
import javax.inject.Inject

class LocationDataRepository @Inject constructor(
        val context: Context
) : LocationRepository {

    companion object {
        private const val LATITUDE_DEFAULT = 1.0
        private const val LONGITUDE_DEFAULT = 2.0

        private const val INTERVAL = 1 * 5 * 1000L
    }

    private val client = LocationServices.getFusedLocationProviderClient(context)
    private val request: LocationRequest = LocationRequest.create()

    init {
        with(request) {
            interval = INTERVAL
            priority = LocationRequest.PRIORITY_BALANCED_POWER_ACCURACY
            TimeUnit.SECONDS.toMillis(10)
        }
    }

    override fun location(): Single<Location> =
            RxFusedLocationSingle.create(client)
                    .map { Location(it.latitude, it.longitude) }

    override fun defaultLocation(): Single<Location> =
            Single.fromCallable { Location(LATITUDE_DEFAULT, LONGITUDE_DEFAULT) }

    override fun observableLocation(): Observable<Location> =
            RxFusedLocationProvider.create(client, request)
                    .map { Location(it.latitude, it.longitude) }
}