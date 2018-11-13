package com.wtr.core.utils.location

import android.location.Location
import com.google.android.gms.location.FusedLocationProviderClient
import com.google.android.gms.location.LocationRequest
import io.reactivex.Observable
import io.reactivex.ObservableEmitter
import io.reactivex.ObservableOnSubscribe


class RxFusedLocationProvider(
        val client: FusedLocationProviderClient,
        val request: LocationRequest
) : ObservableOnSubscribe<Location> {
    override fun subscribe(emitter: ObservableEmitter<Location>) {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    companion object {
        fun create(client: FusedLocationProviderClient, request: LocationRequest) =
                Observable.defer { Observable.create(RxFusedLocationProvider(client, request)) }
    }
}