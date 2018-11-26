package com.wtr.core.data.connection

sealed class ConnectionState {
    object Disconnect : ConnectionState()
    object Connect : ConnectionState()
    object Unknown : ConnectionState()
}