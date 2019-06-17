package com.cleanarchitecture.presentation.navigation

import android.app.Activity
import android.content.Intent
import com.cleanarchitecture.news_sample_app.R
import com.cleanarchitecture.presentation.albums.UiAlbum

class AppNavigator(private val activity: Activity) : Navigator {

    private val baseNavigationUri by lazy { activity.getString(R.string.nav_uri) }

    private fun createIntentFromAction(location: String): Intent =
            Intent("$baseNavigationUri.$location").apply {
                addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP or Intent.FLAG_ACTIVITY_SINGLE_TOP)
            }

    override fun back() = activity.finish()

    override fun toLaunchActivity() {
        activity.startActivity(createAppLaunchIntent(activity))
        activity.finishAffinity()
    }

    override fun toAlbums() {
        createIntentFromAction("albums").apply {
            activity.startActivity(this)
        }
    }

    override fun toAlbumDetails(album: UiAlbum) {
        createIntentFromAction("album_details").apply {
            putExtra(NavigateArguments.ALBUM, album)
            activity.startActivity(this)
        }
    }

    override fun toUrl(url: String, title: String) {
        createIntentFromAction("webview").apply {
            putExtra(NavigateArguments.WEBVIEW_URL, url)
            putExtra(NavigateArguments.WEBVIEW_TITLE, title)
            activity.startActivity(this)
        }
    }

    override fun toHome() {
        createIntentFromAction("home").apply {
            activity.startActivity(this)
        }
    }
}
