package com.wtr.wtr_app.ui

import android.content.Context
import android.content.Intent
import android.support.v4.app.Fragment
import android.support.v4.app.FragmentActivity
import android.support.v4.app.FragmentManager
import ru.terrakok.cicerone.android.SupportAppNavigator

class AppNavigator(
        val fragmentActivity: FragmentActivity,
        val fragmentManager: FragmentManager,
        val containerId: Int
) : SupportAppNavigator(fragmentActivity, fragmentManager, containerId) {
    override fun createActivityIntent(context: Context?, screenKey: String?, data: Any?): Intent {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    override fun createFragment(screenKey: String?, data: Any?): Fragment {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }
}