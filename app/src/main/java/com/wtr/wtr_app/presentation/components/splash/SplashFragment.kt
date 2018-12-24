package com.wtr.wtr_app.presentation.components.splash

import android.os.Bundle
import android.os.Handler
import android.util.Log
import android.view.View
import com.arellomobile.mvp.presenter.InjectPresenter
import com.arellomobile.mvp.presenter.ProvidePresenter
import com.wtr.core.data.connection.ConnectionState
import com.wtr.core.presentation.state.PrimaryState
import com.wtr.core.presentation.ui.BaseFragment
import com.wtr.wtr_app.R
import com.wtr.wtr_app.data.geo.model.LocationState
import com.wtr.wtr_app.di.ComponentManager
import kotlinx.android.synthetic.main.fragment_splash.*

class SplashFragment : BaseFragment(), SplashView<SplashState> {

    companion object {
        fun newInstance() = SplashFragment()
    }

    override var layoutIdRes =
            R.layout.fragment_splash

    @InjectPresenter
    lateinit var presenter: SplashPresenter

    @ProvidePresenter
    fun providePresenter() =
            ComponentManager.mainComponent.plusSplashComponent().presenter()

    override fun render(state: SplashState) {
        when (state.primaryState) {
            is PrimaryState.Loading -> processLoading(state.connectionState, state.locationState)
            is PrimaryState.Data -> processData(state.locationState)
            is PrimaryState.Error -> processError(state.connectionState, state.locationState)
        }
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        Handler().postDelayed({ presenter.splashShowed() }, 2000)
    }

    private fun processData(state: LocationState) {
        progressBar.visibility = View.GONE
        when (state) {
            is LocationState.Succes -> {
                state_text_view.text = "success"
            }
        }
    }

    private fun processLoading(connectionState: ConnectionState, state: LocationState) {
        when (connectionState) {
            is ConnectionState.Connect -> {
                processLocation(state)
            }
            is ConnectionState.Disconnect,
            is ConnectionState.Unknown -> {
                Log.d("iiiiininin", "loading unknown")
                progressBar.visibility = View.INVISIBLE
                state_text_view.text = "нет интеренетаfffffff"
                continue_button.visibility = View.VISIBLE
            }
        }
    }

    private fun processError(connectionState: ConnectionState, locationState: LocationState) {
        progressBar.visibility = View.GONE
        when (connectionState) {
            is ConnectionState.Disconnect -> {
                Log.d("iiiiininin", "process error")
                progressBar.visibility = View.INVISIBLE
                state_text_view.text = "нет интеренета"
                continue_button.visibility = View.VISIBLE
            }
        }
        when (locationState) {
            is LocationState.Failed -> {
                state_text_view.text = "геоданные не доступны"
            }
        }
    }

    private fun processLocation(locationState: LocationState) {
        when (locationState) {
            is LocationState.Progress -> {
                progressBar.visibility = View.VISIBLE
                state_text_view.text = "поиск локации"
            }
            is LocationState.Failed -> {
                progressBar.visibility = View.INVISIBLE
                continue_button.visibility = View.VISIBLE
                state_text_view.text = "не удалось определить локацию"
            }
            is LocationState.Succes -> {
                state_text_view.text = "успешно ${locationState.latitude}  ${locationState.longitude}"
                progressBar.visibility = View.INVISIBLE
                continue_button.visibility = View.INVISIBLE
            }
        }
    }

}