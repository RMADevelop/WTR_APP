package com.wtr.wtr_app.ui.components.map

import com.wtr.core.data.connection.ConnectionProvider
import com.wtr.core.presentation.mvp.BasePresenter
import com.wtr.core.presentation.state.PrimaryState
import com.wtr.core.presentation.state.ViewState
import javax.inject.Inject

class MapPresenter @Inject constructor(
        connectionProvider: ConnectionProvider
) : BasePresenter<MapState, MapView<MapState>>(connectionProvider) {
    override fun processConnectionState(state: Boolean) {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }
}

data class MapState(
        override val primaryState: PrimaryState
) : ViewState