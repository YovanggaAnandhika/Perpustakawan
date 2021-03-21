package com.fathur.perpustakawan

import android.app.Application
import com.androidnetworking.AndroidNetworking
import com.fathur.perpustakawan.api.SessionKeys
import hundredthirtythree.sessionmanager.SessionManager

class Application : Application() {

    companion object {
        const val AUTH_STATE : String = "Auth"
    }
    override fun onCreate() {
        super.onCreate()
        AndroidNetworking.initialize(applicationContext)
        SessionManager.Builder()
            .setContext(applicationContext)
            .setPrefsName(SessionKeys.PREFS_NAME.key)
            .build()
    }
}