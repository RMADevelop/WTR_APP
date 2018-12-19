package com.wtr.wtr_app.ui.components.map

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.wtr.core.presentation.ui.BaseFragment
import com.wtr.wtr_app.R
import kotlinx.android.synthetic.main.fragment_bottom.*
import kotlinx.android.synthetic.main.fragment_map.*

class MapFragment : BaseFragment(), MapView<MapState> {

    lateinit var mapView: com.google.android.gms.maps.MapView

    override fun render(state: MapState) {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    companion object {
        fun newInstance() = MapFragment()
    }

    override var layoutIdRes: Int = R.layout.fragment_map

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        mapView = map_bottom
        mapView.onCreate(savedInstanceState)
    }

    override fun onStart() {
        super.onStart()
        mapView.onStart()
    }

    override fun onResume() {
        super.onResume()
        mapView.onResume()
    }

    override fun onPause() {
        super.onPause()
        mapView.onPause()
    }

    override fun onStop() {
        super.onStop()
        mapView.onStop()
    }

    override fun onDestroyView() {
        mapView.onDestroy()
        super.onDestroyView()
    }

    override fun onLowMemory() {
        super.onLowMemory()
        mapView.onDestroy()
    }

}