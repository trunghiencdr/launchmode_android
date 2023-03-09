package com.example.launchmodeandroid

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle

class MainActivity3 : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main3)
    }

    override fun onPause() {
        super.onPause()
        AppGlobal.mLastActivity =javaClass
    }

    override fun onBackPressed() {
        super.onBackPressed()
        if(AppGlobal.mPreviousActivity == null ) finishAndRemoveTask()
    }
}