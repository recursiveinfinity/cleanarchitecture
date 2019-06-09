package com.cleanarchitecture.presentation.navigation

import android.app.Activity
import android.content.ComponentName
import android.content.Intent
import android.content.pm.PackageManager

fun createAppLaunchIntent(activity: Activity): Intent = activity.packageManager
        .getPackageInfo(activity.packageName, PackageManager.GET_ACTIVITIES or PackageManager.GET_META_DATA)
        .activities
        .first { activityInfo -> activityInfo.metaData?.getBoolean("startActivity") ?: false }
        .let { launchActivity ->
            Intent(Intent.ACTION_MAIN).apply {
                addCategory(Intent.CATEGORY_LAUNCHER)
                flags = Intent.FLAG_ACTIVITY_NEW_TASK or Intent.FLAG_ACTIVITY_CLEAR_TASK
                component = ComponentName(launchActivity.applicationInfo.packageName, launchActivity.name)
            }
        }