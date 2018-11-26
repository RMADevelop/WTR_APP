package com.wtr.wtr_app.ui.components.splash

import com.arellomobile.mvp.presenter.InjectPresenter
import com.arellomobile.mvp.presenter.ProvidePresenter
import com.wtr.core.presentation.ui.BaseFragment
import com.wtr.wtr_app.R
import com.wtr.wtr_app.di.ComponentManager

class SplashFragment : BaseFragment() {

    companion object {
        fun newInstance() = SplashFragment()
    }

    override var layoutIdRes =
            R.layout.fragment_splash

    @InjectPresenter
    lateinit var presenter: SplashPresenter

    @ProvidePresenter
    fun providePResenter() =
            ComponentManager.mainComponent.plusSplashComponent().presenter()

}