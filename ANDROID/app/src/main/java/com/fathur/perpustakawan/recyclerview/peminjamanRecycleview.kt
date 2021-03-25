package com.fathur.perpustakawan.recyclerview

import android.content.Context
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.bumptech.glide.load.engine.DiskCacheStrategy
import com.fathur.perpustakawan.R
import com.fathur.perpustakawan.databinding.RvPeminjamanBinding

class peminjamanRecycleview(var context: Context) : RecyclerView.Adapter<peminjamanRecycleview.myholder>() {

    private lateinit var mbinding : RvPeminjamanBinding
    private var data : MutableList<mdata> = mutableListOf()

    data class mdata(
            var gambar : String,
            var judul : String,
            var tanggal : String,
            var jam : String
    )

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): peminjamanRecycleview.myholder {
        mbinding = DataBindingUtil.inflate(LayoutInflater.from(context),R.layout.rv_peminjaman,parent,false)
        return myholder(mbinding)
    }

    override fun onBindViewHolder(holder: peminjamanRecycleview.myholder, position: Int) {
        Glide.with(context)
                .load( data[position].gambar)
                .centerCrop()
                .placeholder(R.drawable.placeholder)
                .skipMemoryCache(true)
                .diskCacheStrategy(DiskCacheStrategy.NONE)
                .into(holder.mbind.mgambar)

        holder.mbind.mjudulbuku.text = data[position].judul
        holder.mbind.mbataspeminjaman.text = data[position].tanggal
        holder.mbind.mbataspukulpeminjaman.text = data[position].jam
    }

    override fun getItemCount(): Int {
        return data.size
    }

    inner class myholder (bind : RvPeminjamanBinding) : RecyclerView.ViewHolder(bind.root){
        val mbind = bind
    }

    fun setData(Data: MutableList<mdata> = mutableListOf()){
        this.data = Data
        notifyDataSetChanged()
    }
}