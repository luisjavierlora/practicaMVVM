package com.example.practicamvp.ui

import android.content.Context
import android.content.Intent
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.databinding.ViewDataBinding
import androidx.recyclerview.widget.RecyclerView
import com.example.practicamvp.BR
import com.example.practicamvp.R
import com.example.practicamvp.model.obj.Offer
import com.example.practicamvp.viewmodel.MainViewModel
import com.squareup.picasso.Picasso
import kotlinx.android.synthetic.main.item.view.*

class Rv_CuponesAdapter(var mainViewModel: MainViewModel): RecyclerView.Adapter<Rv_CuponesAdapter.ViewHolder>() {

    private var cuponList = ArrayList<Offer>()



    fun setCuponsList(cupons:List<Offer>){
        this.cuponList=cupons  as ArrayList<Offer>
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val layoutInflater = LayoutInflater.from(parent.context)

        val binding: ViewDataBinding =
            DataBindingUtil.inflate(layoutInflater, viewType, parent, false)


        return ViewHolder(binding)
    }

    override fun getItemCount(): Int {
        return this.cuponList.count()
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.setCupon(mainViewModel,position)
    }

    override fun getItemViewType(position: Int): Int {
        return getLayoutIdForPosition(position)
    }

    private fun getLayoutIdForPosition(position: Int): Int {
        return R.layout.item
    }



    class ViewHolder(binding: ViewDataBinding) : RecyclerView.ViewHolder(binding.root){

        private var binding: ViewDataBinding? = null

        init {
            this.binding = binding
        }


        fun setCupon(mainViewModel: MainViewModel, position: Int) {
            binding?.setVariable(BR.model, mainViewModel)
            binding?.setVariable(BR.position, position)

        }

    }
}