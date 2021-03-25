package com.fathur.perpustakawan.view

import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.databinding.DataBindingUtil
import androidx.recyclerview.widget.LinearLayoutManager
import com.fathur.perpustakawan.R
import com.fathur.perpustakawan.databinding.IcPeminjamanBinding
import com.fathur.perpustakawan.recyclerview.peminjamanRecycleview

class bPeminjaman :AppCompatActivity () {
    private lateinit var i : Intent
    private lateinit var mbinding : IcPeminjamanBinding

    private var mData : MutableList<peminjamanRecycleview.mdata> = mutableListOf()

    private lateinit var madapter : peminjamanRecycleview

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        mbinding = DataBindingUtil.setContentView(this, R.layout.ic_peminjaman)

        mData.clear()

        mData.add(peminjamanRecycleview.mdata("https://www.bukukita.com/babacms/displaybuku/104592_f.jpg", "Dr Dtone Parr 3", "13 Maret 2020", "Pukul 13.00"))
        mData.add(peminjamanRecycleview.mdata("https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcT5CzOCeCQLvJfe4FdBv0NsGosFks1AaQUNCg&usqp=CAU", "Dr Dtone Parr 3", "13 Maret 2020", "Pukul 13.00"))

        madapter = peminjamanRecycleview(this)

        mbinding.mrecyclepeminjaman.let {
            it.layoutManager = LinearLayoutManager(this, LinearLayoutManager.VERTICAL, false)
            it.adapter = madapter

        }

        madapter.setData(mData)
    }


}