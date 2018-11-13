package com.wtr.wtr_app.data.geo

import com.wtr.core.data.entity.Location
import io.reactivex.Observable
import io.reactivex.Single

class LocationDataProvider : LocationProvider {


    override fun location(): Single<Location> {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    override fun defaultLocation(): Single<Location> {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    override fun observableLocation(): Observable<Location> {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }
}