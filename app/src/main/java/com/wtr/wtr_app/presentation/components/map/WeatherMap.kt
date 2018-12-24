package com.wtr.wtr_app.presentation.components.map

import android.content.Context
import android.util.AttributeSet
import com.wtr.core.presentation.view.BaseMapView

class WeatherMap : BaseMapView {

    constructor(context: Context) : super(context)

    constructor(context: Context, attrs: AttributeSet) : super(context, attrs)

    constructor(context: Context, attrs: AttributeSet, defStyleAttr: Int) : super(context, attrs, defStyleAttr)

    init {
        getMapAsync(this)
    }
}