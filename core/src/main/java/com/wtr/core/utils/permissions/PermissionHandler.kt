package com.wtr.core.utils.permissions

import com.tbruyelle.rxpermissions2.Permission
import com.tbruyelle.rxpermissions2.RxPermissions
import io.reactivex.Observable
import javax.inject.Inject

class PermissionHandler @Inject constructor(
        private val rxPermissions: RxPermissions
) {
    fun requestPermission(vararg permissions: String): Observable<Permission> =
            rxPermissions.requestEach(*permissions)
}