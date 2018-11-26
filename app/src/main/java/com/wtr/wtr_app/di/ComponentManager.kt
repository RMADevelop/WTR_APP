package com.wtr.wtr_app.di

import android.support.v4.app.FragmentActivity
import android.support.v4.app.FragmentManager
import com.wtr.wtr_app.app.App

object ComponentManager {

    lateinit var appComponent: AppComponent
    lateinit var mainComponent: MainComponent

    fun injectAppComponent(app: App): AppComponent {
        appComponent = DaggerAppComponent.builder()
                .withApplication(app)
                .build()
        return appComponent
    }

    fun injectMain(fragmentActivity: FragmentActivity, fragmentManager: FragmentManager, containerId: Int): MainComponent {
        mainComponent = appComponent.mainComponent()
                .withFragmentActivity(fragmentActivity)
                .withFragmentManager(fragmentManager)
                .withContainerID(containerId)
                .build()
        return mainComponent
    }

    fun injectSplashPresenter() =
            mainComponent.plusSplashComponent().presenter()
}