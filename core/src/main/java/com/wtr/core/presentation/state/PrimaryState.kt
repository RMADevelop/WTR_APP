package com.wtr.core.presentation.state

sealed class PrimaryState {
    object Idle : PrimaryState()
    object Loading : PrimaryState()
    object Data : PrimaryState()
    object Success : PrimaryState()
    data class Error(val error: String?) : PrimaryState()
}