package com.wtr.wtr_app.di

import com.wtr.core.di.scopes.FragmentScope
import com.wtr.wtr_app.domain.interactor.location.LocationDomainInteractor
import com.wtr.wtr_app.domain.interactor.location.LocationInteractor
import com.wtr.wtr_app.presentation.components.splash.SplashFragment
import com.wtr.wtr_app.presentation.components.splash.SplashPresenter
import dagger.Module
import dagger.Provides
import dagger.Subcomponent

@FragmentScope
@Subcomponent(modules = [SplashModule::class])
interface SplashComponent {

    fun inject(splashFragment: SplashFragment)

    fun presenter(): SplashPresenter
}

@Module
class SplashModule() {


}