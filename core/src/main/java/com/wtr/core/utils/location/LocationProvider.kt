package com.wtr.core.utils.location

import android.annotation.SuppressLint
import android.location.Location
import com.google.android.gms.location.*
import com.wtr.core.domain.NoLastKnownLocation
import io.reactivex.*
import io.reactivex.disposables.Disposables

class RxFusedLocationProvider(
        private val client: FusedLocationProviderClient,
        private val request: LocationRequest
) : ObservableOnSubscribe<Location> {

    companion object {
        fun create(client: FusedLocationProviderClient, request: LocationRequest) =
                Observable.defer { Observable.create(RxFusedLocationProvider(client, request)) }
    }

    @SuppressLint("MissingPermission")
    override fun subscribe(emitter: ObservableEmitter<Location>) {
        val callback = Callback(emitter)
        emitter.setDisposable(Disposables.fromRunnable { client.removeLocationUpdates(callback) })
        client.requestLocationUpdates(request, callback, null)
        client.flushLocations()
    }

    class Callback(private val emitter: ObservableEmitter<Location>) : LocationCallback() {
        override fun onLocationResult(locationResult: LocationResult) {
            locationResult.lastLocation?.let { emitter.onNext(Location(it)) }
        }
    }
}

class RxFusedLocationSingle(
        private val client: FusedLocationProviderClient
) : SingleOnSubscribe<Location> {

    companion object {
        fun create(client: FusedLocationProviderClient) =
                Single.defer { Single.create(RxFusedLocationSingle(client)) }

    }

    @SuppressLint("MissingPermission")
    override fun subscribe(emitter: SingleEmitter<Location>) {
        client.lastLocation.addOnSuccessListener {
            it?.let { emitter.onSuccess(Location(it)) }
                    ?: emitter.onError(NoLastKnownLocation())
        }.addOnFailureListener { emitter.onError(it) }
    }
}