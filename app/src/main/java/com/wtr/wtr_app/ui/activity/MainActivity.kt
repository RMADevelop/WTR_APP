package com.wtr.wtr_app.ui.activity

import com.wtr.core.presentation.ui.BaseActivity
import com.wtr.wtr_app.R
import com.wtr.wtr_app.di.ComponentManager
import ru.terrakok.cicerone.Navigator
import ru.terrakok.cicerone.NavigatorHolder
import javax.inject.Inject

class MainActivity : BaseActivity() {

    @Inject
    lateinit var appNavigator: Navigator

    @Inject
    lateinit var navigatorHolder: NavigatorHolder


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

    override fun onResume() {
        super.onResume()
        navigatorHolder.setNavigator(appNavigator)
    }

    override fun onPause() {
        super.onPause()
        navigatorHolder.removeNavigator()
    }
}
