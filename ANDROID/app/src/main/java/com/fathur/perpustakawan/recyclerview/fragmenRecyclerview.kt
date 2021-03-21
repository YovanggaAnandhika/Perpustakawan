package com.fathur.perpustakawan.recyclerview

import android.content.Context
import android.content.Intent
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.bumptech.glide.load.engine.DiskCacheStrategy
import com.fathur.perpustakawan.R
import com.fathur.perpustakawan.databinding.RvFragmenBinding
import com.fathur.perpustakawan.view.detailBook

class fragmenRecyclerview(var context: Context) : RecyclerView.Adapter<fragmenRecyclerview.myHolder>() {

    private lateinit var i : Intent
    private lateinit var mbinding : RvFragmenBinding
    private var data : MutableList<mdata> = mutableListOf()

    data class mdata(
            val nomor : String,
            val gambar : String,
            val judul : String,
            val penulis : String,
            val kategori : String,
            val rating : String
    )

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): fragmenRecyclerview.myHolder {
        mbinding = DataBindingUtil.inflate(LayoutInflater.from(context), R.layout.rv_fragmen, parent, false)
        return myHolder(mbinding)
    }

    override fun onBindViewHolder(holder: fragmenRecyclerview.myHolder, position: Int) {
        Glide.with(context)
                .load( data[position].gambar)
                .centerCrop()
                .placeholder(R.drawable.placeholder)
                .skipMemoryCache(true)
                .diskCacheStrategy(DiskCacheStrategy.NONE)
                .into(holder.mbind.mgambar)

        holder.mbind.mnomor.text = data[position].nomor
        holder.mbind.mJudul1.text = data[position].judul
        holder.mbind.mKategori1.text = data[position].kategori
        holder.mbind.mPengarang1.text = data[position].penulis
        holder.mbind.mrating.text = data[position].rating

        holder.mbind.buku1.setOnClickListener {
            i = Intent(context, detailBook::class.java)
            i.putExtra("gambar",data[position].gambar)
            i.putExtra("judul",data[position].judul)
            i.putExtra("penulis",data[position].penulis)
            i.putExtra("kategori",data[position].kategori)
            context.startActivity(i)
        }
    }

    override fun getItemCount(): Int {
        return data.size
    }

    inner class myHolder(bind : RvFragmenBinding) : RecyclerView.ViewHolder(bind.root){
        val mbind = bind
    }

    fun setData(mdata : MutableList<mdata> = mutableListOf()) {
        this.data = mdata
        notifyDataSetChanged()
    }

}