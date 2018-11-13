package com.wtr.wtr_app.ui.components.splash

import com.arellomobile.mvp.InjectViewState
import com.wtr.core.presentation.mvp.BasePresenter
import com.wtr.core.utils.permissions.PermissionHandler
import com.wtr.wtr_app.domain.interactor.splash.SplashInteractor
import ru.terrakok.cicerone.Router

@InjectViewState
class SplashPresenter(
        val router: Router,
        val permissionHandler: PermissionHandler,
        val splashInteractor: SplashInteractor
) : BasePresenter<SplashView>() {

}