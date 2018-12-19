package com.wtr.wtr_app.ui

import android.content.Context
import android.content.Intent
import android.support.v4.app.Fragment
import android.support.v4.app.FragmentActivity
import android.support.v4.app.FragmentManager
import com.wtr.wtr_app.app.Screens
import com.wtr.wtr_app.ui.components.splash.SplashFragment
import com.wtr.wtr_app.ui.components.weather.WeatherFragment
import com.wtr.wtr_app.ui.components.weather.WeatherFragmentData
import com.wtr.wtr_app.ui.components.weather.model.LocationPresentation
import ru.terrakok.cicerone.android.SupportAppNavigator
import javax.inject.Inject

class AppNavigator @Inject constructor(
        fragmentActivity: FragmentActivity,
        fragmentManager: FragmentManager,
        containerId: Int
) : SupportAppNavigator(fragmentActivity, fragmentManager, containerId) {
    override fun createActivityIntent(context: Context?, screenKey: String?, data: Any?): Intent? =
          null

    override fun createFragment(screenKey: String?, data: Any?): Fragment {
        return when (screenKey) {
            Screens.SPLASH_SCREEN_KEY -> WeatherFragment.newInstance(WeatherFragmentData(
                    LocationPresentation(1.0,1.0)
            ))
            else -> throw IllegalArgumentException("Cannot create fragment with this key: $screenKey")
        }
    }
}