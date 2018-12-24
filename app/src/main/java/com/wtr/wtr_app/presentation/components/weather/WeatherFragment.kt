package com.wtr.wtr_app.presentation.components.weather

import android.os.Bundle
import android.os.Parcelable
import android.support.design.widget.BottomSheetBehavior
import android.support.v7.widget.LinearLayoutManager
import android.view.View
import com.arellomobile.mvp.presenter.InjectPresenter
import com.arellomobile.mvp.presenter.ProvidePresenter
import com.wtr.core.presentation.state.PrimaryState
import com.wtr.core.presentation.view.BaseMapFragment
import com.wtr.core.presentation.view.DataFragment
import com.wtr.wtr_app.R
import com.wtr.wtr_app.di.ComponentManager
import com.wtr.wtr_app.presentation.components.map.HoursAdapter
import com.wtr.wtr_app.presentation.components.weather.model.LocationPresentation
import kotlinx.android.parcel.Parcelize
import kotlinx.android.synthetic.main.fragment_map.*
import kotlinx.android.synthetic.main.fragment_map_weather.*
import kotlinx.android.synthetic.main.fragment_weather.*

@Parcelize
data class WeatherFragmentData(
        val location: LocationPresentation
) : Parcelable

class WeatherFragment : BaseMapFragment(), WeatherView, DataFragment<WeatherFragmentData> {

    private lateinit var bottomSheetBehavior: BottomSheetBehavior<View>

    @InjectPresenter
    lateinit var presenter: WeatherPresenter

    @ProvidePresenter
    fun providePresenter(): WeatherPresenter =
            ComponentManager.injectWeatherPresenter()

    companion object {
        fun newInstance(weatherFragmentData: WeatherFragmentData?) = WeatherFragment().apply {
            arguments = Bundle().apply {
                putParcelable(ARG_DATA, weatherFragmentData)
            }
        }
    }

    override var layoutIdRes: Int = R.layout.fragment_map_weather

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        mapView = map_main
        super.onViewCreated(view, savedInstanceState)
        hours.adapter = HoursAdapter()
        hours.layoutManager = LinearLayoutManager(context)
        bottomSheetBehavior = BottomSheetBehavior.from(bottom_sheet)
        zoom_in.setOnClickListener { map_main.zoomIn() }
        zoom_out.setOnClickListener { map_main.zoomOut() }

        processArguments()
    }

    override fun render(state: WeatherViewState) {
        when (state.primaryState) {
            is PrimaryState.Data -> processData(state)
        }
    }

    private fun processData(state: WeatherViewState) {
        state.run {
            if (mapIsOpened) {
                bottomSheetBehavior.state = BottomSheetBehavior.STATE_HIDDEN
            } else {
                bottomSheetBehavior.state = BottomSheetBehavior.STATE_EXPANDED
            }

            state.locationPresentation?.let {
                map_main.setLocation(it.latitude, it.longitude)
            }
        }
    }

    private fun processArguments() {
        arguments()?.let {
            presenter.processLocation(it.location)
        } ?: presenter.emptyStart()
    }
}