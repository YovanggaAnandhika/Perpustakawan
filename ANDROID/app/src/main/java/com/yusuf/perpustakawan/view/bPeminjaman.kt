package com.yusuf.perpustakawan.view

import android.content.Intent
import android.os.Bundle
import android.view.MenuItem
import androidx.appcompat.app.AppCompatActivity
import androidx.databinding.DataBindingUtil
import com.google.android.material.bottomnavigation.BottomNavigationView
import com.yusuf.perpustakawan.R
import com.yusuf.perpustakawan.databinding.IcPeminjamanBinding

class bPeminjaman :AppCompatActivity () {
    private lateinit var i : Intent
    private lateinit var mbinding : IcPeminjamanBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        mbinding = DataBindingUtil.setContentView(this, R.layout.ic_peminjaman)
    }


}