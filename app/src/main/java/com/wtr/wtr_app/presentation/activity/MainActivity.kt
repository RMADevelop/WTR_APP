package com.wtr.wtr_app.presentation.activity

import com.arellomobile.mvp.presenter.InjectPresenter
import com.arellomobile.mvp.presenter.ProvidePresenter
import com.wtr.core.presentation.ui.BaseActivity
import com.wtr.wtr_app.R
import com.wtr.wtr_app.di.ComponentManager
import ru.terrakok.cicerone.Navigator
import ru.terrakok.cicerone.NavigatorHolder
import javax.inject.Inject

class MainActivity : BaseActivity(), MainView<MainState> {
    override fun render(state: MainState) {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    @Inject
    lateinit var appNavigator: Navigator

    @Inject
    lateinit var navigatorHolder: NavigatorHolder

    @Inject
    @InjectPresenter
    lateinit var presenter: MainPresenter

    @ProvidePresenter
    fun providePresenter() =
            presenter

    override var layoutResId: Int =
            R.layout.activity_main

    override fun inject() {
        ComponentManager.injectMain(
                this,
                supportFragmentManager,
                R.id.container
        ).inject(this)
    }

    override fun renderView() {

    }

    override fun onResumeFragments() {
        super.onResumeFragments()
        navigatorHolder.setNavigator(appNavigator)
    }

    override fun onPause() {
        super.onPause()
        navigatorHolder.removeNavigator()
    }
}
