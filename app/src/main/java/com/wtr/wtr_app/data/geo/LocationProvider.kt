package com.wtr.wtr_app.data.geo

import com.wtr.core.data.entity.Location
import io.reactivex.Observable
import io.reactivex.Single

interface LocationProvider {

    fun location(): Single<Location>

    fun defaultLocation(): Single<Location>

    fun observableLocation(): Observable<Location>
}