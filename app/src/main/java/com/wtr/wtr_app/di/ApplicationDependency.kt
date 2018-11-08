package com.wtr.wtr_app.di

import com.wtr.core.di.modules.NavigationModule
import com.wtr.wtr_app.App
import dagger.BindsInstance
import dagger.Component
import dagger.Module
import dagger.Provides
import javax.inject.Singleton

@Component(modules = [
    NavigationModule::class,
    ApplicationModule::class
])
interface ApplicationComponent {
    fun inject(app: App)

    @Component.Builder
    interface Builder {
        @BindsInstance
        fun withApplication(app: App)
    }
}

@Module
class ApplicationModule() {

    @Singleton
    @Provides
    fun provideContext(app: App) = app.baseContext
}

