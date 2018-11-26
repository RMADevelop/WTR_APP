package com.wtr.wtr_app.di

import android.support.v4.app.FragmentActivity
import android.support.v4.app.FragmentManager
import com.tbruyelle.rxpermissions2.RxPermissions
import com.wtr.core.di.scopes.ActivityScope
import com.wtr.wtr_app.ui.AppNavigator
import com.wtr.wtr_app.ui.activity.MainActivity
import dagger.BindsInstance
import dagger.Module
import dagger.Provides
import dagger.Subcomponent
import ru.terrakok.cicerone.Navigator

@ActivityScope
@Subcomponent(modules = [
    MainModule::class
])
interface MainComponent {

    fun inject(mainActivity: MainActivity)

    fun plusSplashComponent(): SplashComponent

    @Subcomponent.Builder
    interface Builder {

        @BindsInstance
        fun withFragmentManager(fragmentManager: FragmentManager): Builder

        @BindsInstance
        fun withFragmentActivity(fragmentActivity: FragmentActivity): Builder

        @BindsInstance
        fun withContainerID(containerId: Int): Builder

        fun build(): MainComponent
    }
}

@Module
class MainModule {

    @Provides
    @ActivityScope
    fun provideNavigator(appNavigator: AppNavigator): Navigator = appNavigator

    @Provides
    @ActivityScope
    fun provideRxPermissions(fragmentActivity: FragmentActivity): RxPermissions = RxPermissions(fragmentActivity)
}