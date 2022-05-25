package com.example.nspsdfapp.utils

import android.app.Activity
import android.graphics.Color
import android.view.WindowManager

fun Activity.makeStatusBarTransparent() = with(window) {
    addFlags(WindowManager.LayoutParams.FLAG_DRAWS_SYSTEM_BAR_BACKGROUNDS)
    clearFlags(WindowManager.LayoutParams.FLAG_TRANSLUCENT_STATUS)
    addFlags(WindowManager.LayoutParams.FLAG_TRANSLUCENT_NAVIGATION)
    statusBarColor = Color.TRANSPARENT
}