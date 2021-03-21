package com.fathur.perpustakawan.recyclerview

import android.content.Context
import android.content.Intent
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.bumptech.glide.load.engine.DiskCacheStrategy
import com.fathur.perpustakawan.R
import com.fathur.perpustakawan.databinding.RvListbookBinding
import com.fathur.perpustakawan.view.detailBook

class ListBookRecyclerview(var context: Context) : RecyclerView.Adapter<ListBookRecyclerview.MyHolder>() {

    private lateinit var i : Intent
    private lateinit var mbinding : RvListbookBinding
    private var data : MutableList<mData> = mutableListOf()

     data class mData(
            var gambar : String,
            var judul : String,
            var penulis : String,
            var kategori : String? = null
    )

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyHolder {
        mbinding = DataBindingUtil.inflate(LayoutInflater.from(context), R.layout.rv_listbook,parent,false)
        return MyHolder(mbinding)
    }

    override fun onBindViewHolder(holder: MyHolder, position: Int) {


        Glide.with(context)
                .load( data[position].gambar)
                .centerCrop()
                .placeholder(R.drawable.placeholder)
                .skipMemoryCache(true)
                .diskCacheStrategy(DiskCacheStrategy.NONE)
                .into(holder.mbind.mgambarbuku)

        holder.mbind.mjudulbuku.text = data[position].judul
        holder.mbind.mpenulis.text = data[position].penulis
        holder.mbind.buku1.setOnClickListener {
            i = Intent(context, detailBook::class.java)
            i.putExtra("gambar",data[position].gambar)
            i.putExtra("judul",data[position].judul)
            i.putExtra("penulis",data[position].penulis)
            i.putExtra("kategori",data[position].kategori)
            context.startActivity(i)
        }



        if (data[position].kategori != null){
            holder.mbind.mkategori.text = data[position].kategori
        }else{
            holder.mbind.mkategori.visibility = View.GONE
        }

    }

    override fun getItemCount(): Int {
       return data.size
    }

    inner class MyHolder(bind : RvListbookBinding) : RecyclerView.ViewHolder(bind.root) {
        val mbind = bind
    }

    fun setData(mdata : MutableList<mData> = mutableListOf()){
        this.data = mdata
        notifyDataSetChanged()
    }

}