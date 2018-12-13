package com.wtr.wtr_app.ui.components.map

import com.wtr.core.presentation.ui.BaseFragment
import com.wtr.wtr_app.R

class MapFragment : BaseFragment(), MapView<MapState> {
    override fun render(state: MapState) {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    companion object {
        fun newInstance() = MapFragment()
    }

    override var layoutIdRes: Int = R.layout.fragment_map

}