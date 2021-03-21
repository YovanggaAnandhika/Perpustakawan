package com.fathur.perpustakawan.view

import android.content.Intent
import android.os.Bundle
import android.os.Handler
import androidx.appcompat.app.AppCompatActivity
import androidx.databinding.DataBindingUtil
import com.fathur.perpustakawan.R
import com.fathur.perpustakawan.databinding.IcSplashScreenBinding

class splashScreen : AppCompatActivity(){

    private lateinit var i : Intent
    private lateinit var mBinding : IcSplashScreenBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        mBinding = DataBindingUtil.setContentView(this, R.layout.ic_splash_screen)

        Handler().postDelayed({
            i = Intent(this, Mainactivity::class.java)
            startActivity(i)
            finish()
        }, 2000)
    }

    override fun onStart() {
        super.onStart()
    }
}