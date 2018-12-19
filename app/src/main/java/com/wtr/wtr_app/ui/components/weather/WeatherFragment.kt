package com.wtr.wtr_app.ui.components.weather

import android.os.Bundle
import android.os.Parcelable
import android.support.design.widget.BottomSheetBehavior
import android.view.View
import com.arellomobile.mvp.presenter.InjectPresenter
import com.arellomobile.mvp.presenter.ProvidePresenter
import com.wtr.core.presentation.ui.BaseFragment
import com.wtr.core.presentation.view.DataFragment
import com.wtr.wtr_app.R
import com.wtr.wtr_app.di.ComponentManager
import com.wtr.wtr_app.ui.components.weather.model.LocationPresentation
import kotlinx.android.parcel.Parcelize
import kotlinx.android.synthetic.main.design_bottom_sheet_dialog.*
import kotlinx.android.synthetic.main.fragment_bottom.*
import kotlinx.android.synthetic.main.fragment_weather.*

@Parcelize
data class WeatherFragmentData(
        val location: LocationPresentation
) : Parcelable

class WeatherFragment : BaseFragment(), WeatherView, DataFragment<WeatherFragmentData> {
    lateinit var mapView: com.google.android.gms.maps.MapView

    @InjectPresenter
    lateinit var presenter: WeatherPresenter

    @ProvidePresenter
    fun providePresenter(): WeatherPresenter =
            ComponentManager.injectWeatherPresenter()

    companion object {
        fun newInstance(weatherFragmentData: WeatherFragmentData) = WeatherFragment().apply {
            arguments = Bundle().apply {
                putParcelable(ARG_DATA, weatherFragmentData)
            }
        }
    }

    override var layoutIdRes: Int = R.layout.fragment_weather

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        arguments()?.let {
            presenter.processLocation(it.location)
        } ?: presenter.emptyStart()
    }

    override fun render(state: WeatherViewState) {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        val bottomSheet = BottomSheetBehavior.from(bottom_sheet_container)
        bottomSheet.state = BottomSheetBehavior.STATE_EXPANDED
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