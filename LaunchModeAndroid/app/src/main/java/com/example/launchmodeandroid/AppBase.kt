package com.example.launchmodeandroid

import android.app.Application

class AppBase : Application() {
    override fun onCreate() {
        super.onCreate()

    }
}

object AppGlobal {
    var mLastActivity: Class<MainActivity3>? = null;
    var mPreviousActivity: Class<MainActivity>? = null;
}