package com.example.launchmodeandroid

import android.content.Intent
import android.os.Bundle
import android.util.Log
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import androidx.core.app.TaskStackBuilder

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        Log.d("TEST", "onCreate main activity")
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        findViewById<TextView>(R.id.textView).setOnClickListener{
            AppGlobal.mPreviousActivity = MainActivity::class.java
            startActivity(Intent(this, MainActivity3::class.java))
        }
    }

    override fun onResume() {
        super.onResume()
        Log.d("TEST", "onResume main")
        if (AppGlobal.mLastActivity != null) {
            // Create a synthetic back stack that includes all the activities in the correct order
            val stackBuilder: TaskStackBuilder = TaskStackBuilder.create(this)
                .addParentStack(MainActivity::class.java)
                .addNextIntent(Intent(this, MainActivity::class.java))
                .addNextIntent(Intent(this, AppGlobal.mLastActivity))
            AppGlobal.mLastActivity = null
            AppGlobal.mPreviousActivity = null

            // Start the last activity using the startActivities method, which will create a new instance of Activity One
            // and add the last activity to its task
            stackBuilder.startActivities()
            finish()
        }
    }
}