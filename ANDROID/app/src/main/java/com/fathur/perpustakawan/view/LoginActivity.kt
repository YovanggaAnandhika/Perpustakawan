package com.fathur.perpustakawan.view

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.Fragment
import com.fathur.perpustakawan.R
import com.fathur.perpustakawan.api.Connector
import com.fathur.perpustakawan.databinding.IcLoginBinding

class LoginActivity : AppCompatActivity() {

    private lateinit var mBinding : IcLoginBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        mBinding = DataBindingUtil.setContentView(this, R.layout.ic_login)

        mBinding.mSubmit.setOnClickListener {
            Connector(this).Auth(mBinding.mUsername.text.toString(), mBinding.mPassword.text.toString())
        }

    }

}