package com.wtr.core.presentation.view

import android.os.Parcelable
import android.support.v4.app.Fragment

interface DataFragment<FD : Parcelable> {

    val ARG_DATA: String
        get() = "arg_data"

    fun Fragment.arguments(): FD? =
            arguments?.getParcelable(ARG_DATA)
}