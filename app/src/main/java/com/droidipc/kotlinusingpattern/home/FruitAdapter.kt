package com.droidipc.kotlinusingpattern.home

import android.databinding.DataBindingUtil
import android.databinding.ViewDataBinding
import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.ViewGroup
import com.droidipc.kotlinusingpattern.BR

public class FruitAdapter: RecyclerView.Adapter<FruitAdapter.GenericViewHolder>{


    var layoutId: Int = 0
    var viewModel: HomeViewModel?= null
    var arrayList: ArrayList<FruitsDto>? = null

    constructor(layoutId: Int, viewModel: HomeViewModel?,arrayList: ArrayList<FruitsDto>? ){
        this.layoutId = layoutId
        this.viewModel = viewModel
        this.arrayList = arrayList
    }

    override fun onCreateViewHolder(p0: ViewGroup, p1: Int): GenericViewHolder {
        val layoutInflater = LayoutInflater.from(p0.getContext())
        val binding = DataBindingUtil.inflate<ViewDataBinding>(layoutInflater, p1, p0, false)

        return GenericViewHolder(binding)
    }

    override fun onBindViewHolder(p0: GenericViewHolder, p1: Int) {
        p0.bind(viewModel, p1)
    }

    override
    fun getItemViewType(position: Int): Int {
        return layoutId
    }

    override fun getItemCount(): Int {
        return arrayList!!.size
    }

    //ViewHolder Class
    class GenericViewHolder(val binding: ViewDataBinding) :
        RecyclerView.ViewHolder(binding.getRoot()) {

        fun bind(viewModel: HomeViewModel?, position: Int) {
            viewModel?.getFruitByPosition(position)
            binding.setVariable(BR.homeViewModel, viewModel)
            binding.setVariable(BR.position, position)
        }

    }
}