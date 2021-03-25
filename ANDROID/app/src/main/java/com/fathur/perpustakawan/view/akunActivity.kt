package com.fathur.perpustakawan.view

import android.annotation.SuppressLint
import android.content.Intent
import android.os.Bundle
import android.view.View
import androidx.appcompat.app.AppCompatActivity
import androidx.databinding.DataBindingUtil
import com.bumptech.glide.Glide
import com.bumptech.glide.load.engine.DiskCacheStrategy
import com.fathur.perpustakawan.Application
import com.fathur.perpustakawan.R
import com.fathur.perpustakawan.databinding.IcAkunBinding
import hundredthirtythree.sessionmanager.SessionManager

class akunActivity:AppCompatActivity(){

    private lateinit var i : Intent
    private lateinit var mbinding : IcAkunBinding

    @SuppressLint("SetTextI18n")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        mbinding = DataBindingUtil.setContentView(this, R.layout.ic_akun)

        Glide.with(this)
            .load(SessionManager.getString(Application.AUTH_DATA_GAMBAR, "null"))
            .centerCrop()
            .placeholder(R.drawable.placeholder)
            .skipMemoryCache(true)
            .diskCacheStrategy(DiskCacheStrategy.NONE)
            .into(mbinding.profileImage)

        mbinding.mTextLevelAccess.text = SessionManager.getString(Application.AUTH_DATA_LEVEL, "user")

        mbinding.mNama.text = SessionManager.getString(Application.AUTH_DATA_NAME, "Lorem Ipsum")
        mbinding.mAlamat.text = SessionManager.getString(Application.AUTH_DATA_ALAMAT, "Lorem Ipsum")
        mbinding.mJurusandanFakultas.text = SessionManager.getString(Application.AUTH_DATA_JURUSAN, "Lorem Ipsum") +
                ", " + SessionManager.getString(Application.AUTH_DATA_FAKULTAS, "Lorem Ipsum")
        mbinding.mKampus.text = SessionManager.getString(Application.AUTH_DATA_KAMPUS, "UNIFA")
        mbinding.mTelp.text = SessionManager.getString(Application.AUTH_DATA_TELP, "00000")

        if (SessionManager.getString(Application.AUTH_DATA_LEVEL, "user") === "user"){

            mbinding.apply {
                mLevelAkunUser.visibility = View.VISIBLE
                mLevelAkunPerpustakawan.visibility = View.GONE
            }

        }else{
            mbinding.apply {
                mLevelAkunUser.visibility = View.GONE
                mLevelAkunPerpustakawan.visibility = View.VISIBLE
            }
        }

        mbinding.mKeluar.setOnClickListener {
            SessionManager.putBoolean(Application.AUTH_STATE, false)
            this.finish()
        }
    }

}