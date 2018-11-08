package com.wtr.wtr_app.app

import android.app.Application
import com.wtr.wtr_app.di.ComponentManager

class App : Application() {

    override fun onCreate() {
        super.onCreate()
        ComponentManager.injectAppComponent(this)
    }
}