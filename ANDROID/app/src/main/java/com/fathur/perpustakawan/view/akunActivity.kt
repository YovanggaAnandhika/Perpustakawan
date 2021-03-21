package com.fathur.perpustakawan.view

import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.databinding.DataBindingUtil
import com.fathur.perpustakawan.R
import com.fathur.perpustakawan.databinding.IcAkunBinding

class akunActivity:AppCompatActivity(){

    private lateinit var i : Intent
    private lateinit var mbinding : IcAkunBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        mbinding = DataBindingUtil.setContentView(this, R.layout.ic_akun)
    }

}