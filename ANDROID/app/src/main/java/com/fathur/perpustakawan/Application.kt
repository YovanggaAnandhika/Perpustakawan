package com.fathur.perpustakawan

import android.app.Application
import com.androidnetworking.AndroidNetworking
import com.fathur.perpustakawan.api.SessionKeys
import hundredthirtythree.sessionmanager.SessionManager
import okhttp3.OkHttpClient




class Application : Application() {

    companion object {
        const val AUTH_STATE : String = "Auth"
        const val AUTH_DATA_GAMBAR : String = "AuthDataGambar"
        const val AUTH_DATA_ID : String = "AuthDataId"
        const val AUTH_DATA_NAME : String = "AuthDataName"
        const val AUTH_DATA_LEVEL : String = "AuthDataLevel"
        const val AUTH_DATA_ALAMAT : String = "AuthDataAlamat"
        const val AUTH_DATA_JURUSAN : String = "AuthDataJurusan"
        const val AUTH_DATA_FAKULTAS : String = "AuthDataFakultas"
        const val AUTH_DATA_KAMPUS : String = "AuthDataKampus"
        const val AUTH_DATA_TELP : String = "AuthDataTelp"

    }
    override fun onCreate() {
        super.onCreate()
// Adding an Network Interceptor for Debugging purpose :
        // Adding an Network Interceptor for Debugging purpose :
        val okHttpClient: OkHttpClient = OkHttpClient().newBuilder()
            .build()
        AndroidNetworking.initialize(applicationContext, okHttpClient)
        SessionManager.Builder()
            .setContext(applicationContext)
            .setPrefsName(SessionKeys.PREFS_NAME.key)
            .build()
    }
}