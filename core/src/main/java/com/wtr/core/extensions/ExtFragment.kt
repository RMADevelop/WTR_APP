package com.wtr.core.extensions

import android.app.Fragment
import android.os.Parcelable

fun <SD : Parcelable> Fragment.getScreenData(key: String): SD? {
    return arguments?.getParcelable(key)
}