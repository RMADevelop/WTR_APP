package com.wtr.wtr_app.presentation.components.map

import android.os.Bundle
import android.view.View
import com.wtr.core.presentation.view.BaseMapFragment
import com.wtr.wtr_app.R
import kotlinx.android.synthetic.main.fragment_bottom.*

class MapFragment : BaseMapFragment(), MapView<MapState> {

    override fun render(state: MapState) {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    companion object {
        fun newInstance() = MapFragment()
    }

    override var layoutIdRes: Int = R.layout.fragment_map

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
    }
}