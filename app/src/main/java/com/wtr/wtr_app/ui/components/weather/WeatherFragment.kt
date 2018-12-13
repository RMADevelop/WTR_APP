package com.wtr.wtr_app.ui.components.weather

import android.os.Bundle
import android.os.Parcelable
import com.arellomobile.mvp.presenter.InjectPresenter
import com.arellomobile.mvp.presenter.ProvidePresenter
import com.wtr.core.presentation.ui.BaseFragment
import com.wtr.wtr_app.R
import com.wtr.wtr_app.di.ComponentManager
import com.wtr.wtr_app.ui.components.weather.model.LocationPresentation
import kotlinx.android.parcel.Parcelize

@Parcelize
data class WeatherFragmentData(
        val location: LocationPresentation
) :Parcelable

class WeatherFragment : BaseFragment(), WeatherView {

    @InjectPresenter
    lateinit var presenter: WeatherPresenter

    @ProvidePresenter
    fun providePresenter(): WeatherPresenter =
            ComponentManager.injectWeatherPresenter()

    companion object {
        public

        fun newInstance() = WeatherFragment()
    }

    override var layoutIdRes: Int = R.layout.fragment_weather

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

    }

    override fun render(state: WeatherViewState) {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

}