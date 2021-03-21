package com.fathur.perpustakawan.view

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import com.fathur.perpustakawan.R
import com.fathur.perpustakawan.databinding.IcBerandaFragmentOftenBinding
import com.fathur.perpustakawan.recyclerview.fragmenRecyclerview

class OftenFragment(private var mText : String) : Fragment() {

    private lateinit var mBinding : IcBerandaFragmentOftenBinding
    private var data : MutableList<fragmenRecyclerview.mdata> = mutableListOf()
    private lateinit var mAdapter : fragmenRecyclerview

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        super.onCreateView(inflater, container, savedInstanceState)

        mBinding = DataBindingUtil.inflate(inflater, R.layout.ic_beranda_fragment_often, container, false)

        data.clear()

        data.add(fragmenRecyclerview.mdata("1.", "https://www.bukukita.com/babacms/displaybuku/104592_f.jpg", "Dr Dtone Parr 3", "Makoto Tamada", "Study Book", "4.1"))
        data.add(fragmenRecyclerview.mdata("1.", "https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcSbQQcOSF7-dAhdtNHr_mysjZuvuN_RVNGTCQ&usqp=CAU", "Dr Dtone Parr 3", "Makoto Tamada", "Jurnal Ilmiah", "4.0"))
        data.add(fragmenRecyclerview.mdata("1.", "https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcSbQQcOSF7-dAhdtNHr_mysjZuvuN_RVNGTCQ&usqp=CAU", "Dr Dtone Parr 3", "Makoto Tamada", "e - book", "4.4"))

        mAdapter = fragmenRecyclerview(requireActivity())
        mAdapter.setData(data)

        mBinding.mrecycleviewfragmen.let {
            it.layoutManager = LinearLayoutManager(requireActivity(), LinearLayoutManager.VERTICAL, false)
            it.adapter = mAdapter
        }

        return mBinding.root

    }


}