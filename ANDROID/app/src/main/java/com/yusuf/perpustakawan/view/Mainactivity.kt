package com.yusuf.perpustakawan.view

import android.content.Intent
import android.os.Bundle
import android.view.MenuItem
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.get
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentManager
import androidx.fragment.app.FragmentStatePagerAdapter
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import androidx.viewpager2.adapter.FragmentStateAdapter
import com.google.android.material.bottomnavigation.BottomNavigationItemView
import com.google.android.material.bottomnavigation.BottomNavigationView
import com.yusuf.perpustakawan.R
import com.yusuf.perpustakawan.databinding.IcBerandaScreenBinding
import com.yusuf.perpustakawan.recyclerview.NewBookRecyclerview

class Mainactivity : AppCompatActivity(), BottomNavigationView.OnNavigationItemSelectedListener {

    private lateinit var i : Intent
    private lateinit var mBinding : IcBerandaScreenBinding

    private var mData : MutableList<NewBookRecyclerview.mModelData> = mutableListOf()
    private var mmDataFragment : MutableList<mDataFragment> = mutableListOf()
    private lateinit var mAdapterBukuBaru : NewBookRecyclerview

    private data class mDataFragment(
            var mFragment : Fragment,
            var mTextTab : String
    )

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        mBinding = DataBindingUtil.setContentView(this, R.layout.ic_beranda_screen)

        mData.clear()

        mData.add(NewBookRecyclerview.mModelData("https://www.bukukita.com/babacms/displaybuku/104592_f.jpg", "Dr Dtone Parr 3", "Fiksi"))
        mData.add(NewBookRecyclerview.mModelData("https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcT5CzOCeCQLvJfe4FdBv0NsGosFks1AaQUNCg&usqp=CAU", "Dr Dtone Parr 3", "Fiksi"))
        mData.add(NewBookRecyclerview.mModelData("https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcSbQQcOSF7-dAhdtNHr_mysjZuvuN_RVNGTCQ&usqp=CAU", "Dr Dtone Parr 5", "Novel"))
        mData.add(NewBookRecyclerview.mModelData("https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcT5CzOCeCQLvJfe4FdBv0NsGosFks1AaQUNCg&usqp=CAU", "Dr Dtone Parr 2", "teer"))
        mData.add(NewBookRecyclerview.mModelData("https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcSbQQcOSF7-dAhdtNHr_mysjZuvuN_RVNGTCQ&usqp=CAU", "Dr Dtone Parr 3", "Fiksi"))
        mData.add(NewBookRecyclerview.mModelData("https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcT5CzOCeCQLvJfe4FdBv0NsGosFks1AaQUNCg&usqp=CAU", "Dr Dtone Parr 3", "Fiksi"))
        mData.add(NewBookRecyclerview.mModelData("https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcS-l7EYJPgFO0YYAkYOYThc1s6Q-MeDt78eAA&usqp=CAU", "Dr Dtone Parr 3", "Fiksi"))

        mAdapterBukuBaru = NewBookRecyclerview(this)

        mBinding.mRecyclerBukuBaru.let {
            it.layoutManager = LinearLayoutManager(this, LinearLayoutManager.HORIZONTAL, false)
            it.adapter = mAdapterBukuBaru
        }

        mAdapterBukuBaru.getData(mData)

        mBinding.let {
            it.mseeall.setOnClickListener {
                i = Intent(this, listBook::class.java)
                i.putExtra("title","Buku Baru")
                startActivity(i)
            }

            it.mJurnal.setOnClickListener {
                i = Intent(this, listBook::class.java)
                i.putExtra("title","Jurnal Ilmiah")
                startActivity(i)
            }

            it.mSkripsi.setOnClickListener {
                i = Intent(this, listBook::class.java)
                i.putExtra("title","Skripsi")
                startActivity(i)
            }

            it.mBukuPaket.setOnClickListener {
                i = Intent(this, listBook::class.java)
                i.putExtra("title","Study Book")
                startActivity(i)
            }
            it.mEBook.setOnClickListener {
                i = Intent(this, listBook::class.java)
                i.putExtra("title","E - Book")
                startActivity(i)
            }
        }

        mBinding.menubottom.setOnNavigationItemSelectedListener (this)


        mmDataFragment.clear();
        mmDataFragment.add(mDataFragment(OftenFragment("rekomendasi"), "Rekomendasi"))
        mmDataFragment.add(mDataFragment(OftenFragment("terpopuler"), "Terpopuler"))
        mmDataFragment.add(mDataFragment(OftenFragment("terlaris"), "Terlaris"))

        mBinding.apply {
            mViewPager.apply {
                adapter = mAdapter(supportFragmentManager)
            }
            mTabLayout.setupWithViewPager(mViewPager)
        }
    }

    override fun onNavigationItemSelected(item: MenuItem) : Boolean {
        when (item.itemId){
            R.id.mpeminjaman -> {
                i = Intent(this, bPeminjaman::class.java)
                startActivity(i)
                return false
            }
            R.id.makun -> {
                i = Intent(this, akunActivity::class.java)
                startActivity(i)
                return false
            }
            else ->{
                return false
            }

        }
    }

    private inner class mAdapter(fm : FragmentManager) : FragmentStatePagerAdapter(fm) {
        override fun getCount(): Int {
            return mmDataFragment.size
        }

        override fun getItem(position: Int): Fragment {
            return mmDataFragment[position].mFragment
        }

        override fun getPageTitle(position: Int): CharSequence {
            return mmDataFragment[position].mTextTab
        }
    }

}