package com.skym.todoapp

import android.content.pm.ApplicationInfo
import android.content.pm.PackageManager
import android.os.Bundle
import android.util.Log
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import com.microsoft.appcenter.AppCenter
import com.microsoft.appcenter.analytics.Analytics
import com.microsoft.appcenter.crashes.Crashes
import com.skym.todoapp.presentation.MainScreen
import com.skym.todoapp.presentation.theme.TodoAppTheme

class MainActivity : ComponentActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        val appCenterKey =  BuildConfig.APPCENTER_KEY
        AppCenter.start(
            application,
            appCenterKey,
            Crashes::class.java,
            Analytics::class.java
        )

        setContent {
            TodoAppTheme {
                MainScreen()
            }
        }
    }
}
