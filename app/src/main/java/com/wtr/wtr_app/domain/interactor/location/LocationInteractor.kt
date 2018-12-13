package com.wtr.wtr_app.domain.interactor.location

import com.wtr.core.data.entity.Location
import io.reactivex.Single

interface LocationInteractor {

    fun location(): Single<Location>
}