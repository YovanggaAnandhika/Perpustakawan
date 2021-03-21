package com.yusuf.perpustakawan.view

import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.databinding.DataBindingUtil
import com.bumptech.glide.Glide
import com.bumptech.glide.load.engine.DiskCacheStrategy
import com.yusuf.perpustakawan.R
import com.yusuf.perpustakawan.databinding.IcDetailBookBinding

class detailBook:AppCompatActivity() {

    private lateinit var mbinding : IcDetailBookBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        mbinding = DataBindingUtil.setContentView(this, R.layout.ic_detail_book)


        Glide.with(this)
                .load(intent.getStringExtra("gambar"))
                .centerCrop()
                .placeholder(R.drawable.placeholder)
                .skipMemoryCache(true)
                .diskCacheStrategy(DiskCacheStrategy.NONE)
                .into(mbinding.gambar)

        mbinding.judul.text = intent.getStringExtra("judul")
        mbinding.penulis.text = intent.getStringExtra("penulis")
        mbinding.kategori.text = intent.getStringExtra("kategori")

        mbinding.kembali.setOnClickListener {
            super.onBackPressed()
        }
    }
}