package com.wtr.core.data.connection

import android.content.BroadcastReceiver
import android.content.Context
import android.content.Intent
import android.content.IntentFilter
import android.net.ConnectivityManager
import io.reactivex.Observable
import io.reactivex.Single
import io.reactivex.subjects.BehaviorSubject
import javax.inject.Inject


interface ConnectionProvider {
    fun connection(): Single<Boolean>

    fun observeConnection(): Observable<Boolean>
}

class ConnectionDefaultProvider @Inject constructor(
        val context: Context,
        val connectivityManager: ConnectivityManager
) : BroadcastReceiver(), ConnectionProvider {

    init {
        context.registerReceiver(this, IntentFilter(ConnectivityManager.CONNECTIVITY_ACTION))
    }

    override fun connection(): Single<Boolean> =
            Single.fromCallable { checkStatus() }

    override fun observeConnection(): Observable<Boolean> = subject

    private val subject: BehaviorSubject<Boolean> = BehaviorSubject.createDefault(checkStatus())

    override fun onReceive(context: Context?, intent: Intent?) {
        subject.onNext(checkStatus())
    }

    fun checkStatus() = with(connectivityManager.activeNetworkInfo) {
        return@with isConnectedOrConnecting
    }


}