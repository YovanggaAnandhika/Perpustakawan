package com.fathur.perpustakawan.recyclerview

import android.content.Context
import android.content.Intent
import android.view.LayoutInflater
import android.view.ViewGroup
import android.widget.Toast
import androidx.databinding.DataBindingUtil
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.bumptech.glide.load.engine.DiskCacheStrategy
import com.fathur.perpustakawan.R
import com.fathur.perpustakawan.databinding.RvNewbookBinding
import com.fathur.perpustakawan.view.detailBook

class  NewBookRecyclerview(var mContext : Context) : RecyclerView.Adapter<NewBookRecyclerview.MyHolder>() {

    private lateinit var mBinding : RvNewbookBinding
    private var mData : MutableList<mModelData> = mutableListOf()
    private lateinit var i : Intent

    data class mModelData(
        var mGambar : String,
        var mJudul : String,
        var mKategori : String,
        var mPenulis : String? = null
    )

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyHolder {
        mBinding = DataBindingUtil.inflate(LayoutInflater.from(mContext), R.layout.rv_newbook, parent, false)
        return MyHolder(mBinding)
    }

    override fun onBindViewHolder(holder: MyHolder, position: Int) {
        holder.binding.judul1.text = mData[position].mJudul
        holder.binding.kategori1.text = mData[position].mKategori

        Glide.with(mContext)
            .load( mData[position].mGambar)
            .centerCrop()
            .placeholder(R.drawable.placeholder)
            .skipMemoryCache(true)
            .diskCacheStrategy(DiskCacheStrategy.NONE)
            .into(holder.binding.gambar1)

        holder.binding.mbuku.setOnClickListener {
            i = Intent(mContext, detailBook::class.java)
            i.putExtra("gambar",mData[position].mGambar)
            i.putExtra("judul",mData[position].mJudul)
            i.putExtra("penulis",mData[position].mPenulis)
            i.putExtra("kategori",mData[position].mKategori)
            mContext.startActivity(i)
        }
    }

    override fun getItemCount() = mData.size

    inner class MyHolder(bind : RvNewbookBinding) : RecyclerView.ViewHolder(bind.root) {
            val binding = bind
    }


    fun getData(mDataActivity : MutableList<mModelData>){
        mData = mDataActivity
        Toast.makeText(mContext, "Jumlah Data : " + mData.size, Toast.LENGTH_SHORT).show()
        notifyDataSetChanged()
    }
}