package com.wtr.wtr_app.ui.components.map

import com.wtr.core.presentation.mvp.BasePresenter
import com.wtr.core.presentation.state.PrimaryState
import com.wtr.core.presentation.state.ViewState

class MapPresenter(

) : BasePresenter<MapState, MapView<MapState>>() {
}

data class MapState(
        override val primaryState: PrimaryState
) : ViewState