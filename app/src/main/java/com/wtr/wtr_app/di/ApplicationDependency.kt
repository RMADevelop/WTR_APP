package com.wtr.wtr_app.di

import android.content.Context
import android.net.ConnectivityManager
import com.wtr.core.data.connection.ConnectionDefaultProvider
import com.wtr.core.data.connection.ConnectionProvider
import com.wtr.core.di.modules.NavigationModule
import com.wtr.wtr_app.app.App
import dagger.BindsInstance
import dagger.Component
import dagger.Module
import dagger.Provides
import javax.inject.Singleton

@Singleton
@Component(modules = [
    NavigationModule::class,
    ApplicationModule::class
])
interface AppComponent {
    fun inject(app: App)

    fun mainComponent(): MainComponent.Builder

    @Component.Builder
    interface Builder {

        @BindsInstance
        fun withApplication(app: App): Builder

        fun build(): AppComponent
    }
}

@Module
class ApplicationModule {

    @Singleton
    @Provides
    fun provideContext(app: App) = app.baseContext

    @Singleton
    @Provides
    fun provideConnectivityManager(context: Context): ConnectivityManager =
            context.getSystemService(Context.CONNECTIVITY_SERVICE) as ConnectivityManager

    @Singleton
    @Provides
    fun provideConnectionProvider(connectionDefaultProvider: ConnectionDefaultProvider): ConnectionProvider = connectionDefaultProvider
}

