package com.wtr.wtr_app.presentation.components.weather.model

import android.os.Parcelable
import kotlinx.android.parcel.Parcelize

@Parcelize
data class LocationPresentation(
        val latitude: Double,
        val longitude: Double
) : Parcelable