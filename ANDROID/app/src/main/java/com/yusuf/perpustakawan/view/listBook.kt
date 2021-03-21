package com.yusuf.perpustakawan.view

import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.databinding.DataBindingUtil
import androidx.recyclerview.widget.GridLayoutManager
import com.yusuf.perpustakawan.R
import com.yusuf.perpustakawan.databinding.IcListBookBinding
import com.yusuf.perpustakawan.recyclerview.ListBookRecyclerview

class listBook : AppCompatActivity () {

    private lateinit var i : Intent
    private lateinit var mbinding : IcListBookBinding
    private lateinit var mAdapter : ListBookRecyclerview
    private var data : MutableList<ListBookRecyclerview.mData> = mutableListOf()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        mbinding = DataBindingUtil.setContentView(this, R.layout.ic_list_book)

        mbinding.mtitle.text = intent.getStringExtra("title")

        mAdapter = ListBookRecyclerview(this)

        mbinding.idrecyclelistbook.let {
            it.layoutManager = GridLayoutManager(this, 3)
            it.adapter = mAdapter
        }

        if (intent.getStringExtra("title") == "Buku Baru"){
            data.clear()
            data.add(ListBookRecyclerview.mData("https://www.bukukita.com/babacms/displaybuku/104592_f.jpg", "Dr Dtone Parr 3", "Dr. hhhh", "fas"))
            data.add(ListBookRecyclerview.mData("https://www.bukukita.com/babacms/displaybuku/104592_f.jpg", "Dr Dtone Parr 1", "Dr. afs", "dsa"))
            data.add(ListBookRecyclerview.mData("https://www.bukukita.com/babacms/displaybuku/104592_f.jpg", "Dr Dtone Parr 4", "Dr. dsa", "ddc"))
            data.add(ListBookRecyclerview.mData("https://www.bukukita.com/babacms/displaybuku/104592_f.jpg", "Dr Dtone Parr 6", "Dr. hhdsahh", "dsad"))
            data.add(ListBookRecyclerview.mData("https://www.bukukita.com/babacms/displaybuku/104592_f.jpg", "Dr Dtone Parr 7", "Dr. dsa", "Novel"))
            data.add(ListBookRecyclerview.mData("https://www.bukukita.com/babacms/displaybuku/104592_f.jpg", "Dr Dtone Parr 1", "Dr. hhhh", "Novel"))
            data.add(ListBookRecyclerview.mData("https://www.bukukita.com/babacms/displaybuku/104592_f.jpg", "Dr Dtone Parr 4", "Dr. hhhh", "Novel"))
            data.add(ListBookRecyclerview.mData("https://www.bukukita.com/babacms/displaybuku/104592_f.jpg", "Dr Dtone Parr 6", "Dr. hhhh", "Novel"))
            data.add(ListBookRecyclerview.mData("https://www.bukukita.com/babacms/displaybuku/104592_f.jpg", "Dr Dtone Parr 3", "Dr. hhhh", "Novel"))
            data.add(ListBookRecyclerview.mData("https://www.bukukita.com/babacms/displaybuku/104592_f.jpg", "Dr Dtone Parr 1", "Dr. hhhh", "Novel"))
            data.add(ListBookRecyclerview.mData("https://www.bukukita.com/babacms/displaybuku/104592_f.jpg", "Dr Dtone Parr 4", "Dr. hhhh", "Novel"))
            data.add(ListBookRecyclerview.mData("https://www.bukukita.com/babacms/displaybuku/104592_f.jpg", "Dr Dtone Parr 6", "Dr. hhhh", "Novel"))
            data.add(ListBookRecyclerview.mData("https://www.bukukita.com/babacms/displaybuku/104592_f.jpg", "Dr Dtone Parr 7", "Dr. hhhh", "Novel"))
            data.add(ListBookRecyclerview.mData("https://www.bukukita.com/babacms/displaybuku/104592_f.jpg", "Dr Dtone Parr 1", "Dr. hhhh", "Novel"))
            data.add(ListBookRecyclerview.mData("https://www.bukukita.com/babacms/displaybuku/104592_f.jpg", "Dr Dtone Parr 4", "Dr. hhhh", "Novel"))
            data.add(ListBookRecyclerview.mData("https://www.bukukita.com/babacms/displaybuku/104592_f.jpg", "Dr Dtone Parr 6", "Dr. hhhh", "Novel"))
            mAdapter.setData(data)
        }
        else if (intent.getStringExtra("title") == "Study Book"){
            data.clear()
            data.add(ListBookRecyclerview.mData("https://www.bukukita.com/babacms/displaybuku/104592_f.jpg", "Dr Dtone Parr 3", "Dr. hhhh",null))
            data.add(ListBookRecyclerview.mData("https://www.bukukita.com/babacms/displaybuku/104592_f.jpg", "Dr Dtone Parr 1", "Dr. hhhh",null))
            data.add(ListBookRecyclerview.mData("https://www.bukukita.com/babacms/displaybuku/104592_f.jpg", "Dr Dtone Parr 4", "Dr. hhhh",null))
            data.add(ListBookRecyclerview.mData("https://www.bukukita.com/babacms/displaybuku/104592_f.jpg", "Dr Dtone Parr 6", "Dr. hhhh",null))
            mAdapter.setData(data)
        }
        else if (intent.getStringExtra("title") == "Jurnal") {
            data.clear()
            data.add(ListBookRecyclerview.mData("https://www.bukukita.com/babacms/displaybuku/104592_f.jpg", "Dr Dtone Parr 3", "Dr. hhhh", null))
            data.add(ListBookRecyclerview.mData("https://www.bukukita.com/babacms/displaybuku/104592_f.jpg", "Dr Dtone Parr 1", "Dr. hhhh", null))
            data.add(ListBookRecyclerview.mData("https://www.bukukita.com/babacms/displaybuku/104592_f.jpg", "Dr Dtone Parr 4", "Dr. hhhh", null))
            data.add(ListBookRecyclerview.mData("https://www.bukukita.com/babacms/displaybuku/104592_f.jpg", "Dr Dtone Parr 6", "Dr. hhhh", null))
            mAdapter.setData(data)
        }
        else if (intent.getStringExtra("title") == "E - Book") {
            data.clear()
            data.add(ListBookRecyclerview.mData("https://www.bukukita.com/babacms/displaybuku/104592_f.jpg", "Dr Dtone Parr 3", "Dr. hhhh", null))
            data.add(ListBookRecyclerview.mData("https://www.bukukita.com/babacms/displaybuku/104592_f.jpg", "Dr Dtone Parr 1", "Dr. hhhh", null))
            data.add(ListBookRecyclerview.mData("https://www.bukukita.com/babacms/displaybuku/104592_f.jpg", "Dr Dtone Parr 4", "Dr. hhhh", null))
            data.add(ListBookRecyclerview.mData("https://www.bukukita.com/babacms/displaybuku/104592_f.jpg", "Dr Dtone Parr 6", "Dr. hhhh", null))
            mAdapter.setData(data)
        }
        else if (intent.getStringExtra("title") == "Jurnal Ilmiah") {
            data.clear()
            data.add(ListBookRecyclerview.mData("https://www.bukukita.com/babacms/displaybuku/104592_f.jpg", "Dr Dtone Parr 3", "Dr. hhhh", null))
            data.add(ListBookRecyclerview.mData("https://www.bukukita.com/babacms/displaybuku/104592_f.jpg", "Dr Dtone Parr 1", "Dr. hhhh", null))
            data.add(ListBookRecyclerview.mData("https://www.bukukita.com/babacms/displaybuku/104592_f.jpg", "Dr Dtone Parr 4", "Dr. hhhh", null))
            data.add(ListBookRecyclerview.mData("https://www.bukukita.com/babacms/displaybuku/104592_f.jpg", "Dr Dtone Parr 6", "Dr. hhhh", null))
            mAdapter.setData(data)
        }
        else if (intent.getStringExtra("title") == "Skripsi") {
            data.clear()
            data.add(ListBookRecyclerview.mData("https://www.bukukita.com/babacms/displaybuku/104592_f.jpg", "Dr Dtone Parr 3", "Dr. hhhh", null))
            data.add(ListBookRecyclerview.mData("https://www.bukukita.com/babacms/displaybuku/104592_f.jpg", "Dr Dtone Parr 1", "Dr. hhhh", null))
            data.add(ListBookRecyclerview.mData("https://www.bukukita.com/babacms/displaybuku/104592_f.jpg", "Dr Dtone Parr 4", "Dr. hhhh", null))
            data.add(ListBookRecyclerview.mData("https://www.bukukita.com/babacms/displaybuku/104592_f.jpg", "Dr Dtone Parr 6", "Dr. hhhh", null))
            mAdapter.setData(data)
        }

        mbinding.kembali.setOnClickListener {
            super.onBackPressed()
        }

    }

}