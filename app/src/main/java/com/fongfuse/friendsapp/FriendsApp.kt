package com.fongfuse.friendsapp

import android.app.Application
import dagger.hilt.android.HiltAndroidApp

@HiltAndroidApp
class FriendsApp: Application() {

    override fun onCreate() {
        super.onCreate()
    }
}