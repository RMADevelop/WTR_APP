package com.wtr.core.presentation.ui

import android.os.Bundle
import com.arellomobile.mvp.MvpAppCompatActivity

abstract class BaseActivity : MvpAppCompatActivity() {
    abstract var layoutResId: Int

    override fun onCreate(savedInstanceState: Bundle?) {
        inject()
        super.onCreate(savedInstanceState)
        setContentView(layoutResId)
        renderView()
    }

    protected open fun inject() {

    }

    protected open fun renderView() {

    }
}