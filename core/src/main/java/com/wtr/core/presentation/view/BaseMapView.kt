package com.wtr.core.presentation.view

import android.content.Context
import android.util.AttributeSet
import com.google.android.gms.maps.CameraUpdateFactory
import com.google.android.gms.maps.GoogleMap
import com.google.android.gms.maps.MapView
import com.google.android.gms.maps.OnMapReadyCallback

open class BaseMapView : MapView, OnMapReadyCallback {

    constructor(context: Context) : super(context)

    constructor(context: Context, attrs: AttributeSet) : super(context, attrs)

    constructor(context: Context, attrs: AttributeSet, defStyleAttr: Int) : super(context, attrs, defStyleAttr)

    var map: GoogleMap? = null

    override fun onMapReady(googleMap: GoogleMap) {
        map = googleMap
    }

    fun zoomIn() = map?.animateCamera(CameraUpdateFactory.zoomIn())

    fun zoomOut() = map?.animateCamera(CameraUpdateFactory.zoomOut())
}