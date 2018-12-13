package com.wtr.wtr_app.di

import com.wtr.core.di.scopes.FragmentScope
import com.wtr.wtr_app.domain.interactor.weather.WeatherDomainInteractor
import com.wtr.wtr_app.domain.interactor.weather.WeatherInteractor
import com.wtr.wtr_app.ui.components.weather.WeatherFragment
import com.wtr.wtr_app.ui.components.weather.WeatherPresenter
import dagger.Module
import dagger.Provides
import dagger.Subcomponent

@FragmentScope
@Subcomponent(modules = [
    WeatherModule::class
])
interface WeatherComponent {

    fun inject(weatherFragment: WeatherFragment)

    fun presenter(): WeatherPresenter
}

@Module
class WeatherModule {

    @Provides
    @FragmentScope
    fun provideWeatherInteractor(weatherInteractor: WeatherDomainInteractor)
            : WeatherInteractor = weatherInteractor
}