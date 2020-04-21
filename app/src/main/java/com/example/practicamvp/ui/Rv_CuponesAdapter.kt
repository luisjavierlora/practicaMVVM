package com.example.practicamvp.ui

import android.content.Context
import android.content.Intent
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.core.content.ContextCompat.startActivity
import androidx.recyclerview.widget.RecyclerView
import com.example.practicamvp.R
import com.example.practicamvp.model.Offer
import com.squareup.picasso.Picasso
import kotlinx.android.synthetic.main.item.view.*

class Rv_CuponesAdapter(var context: Context, cuponList: ArrayList<Offer>): RecyclerView.Adapter<Rv_CuponesAdapter.ViewHolder>() {

    private var cuponList = ArrayList<Offer>()

    init{
        this.cuponList = cuponList
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val itemView = LayoutInflater.from(context)
            .inflate(R.layout.item, parent, false)

        val viewHolder = Rv_CuponesAdapter.ViewHolder(itemView, context)
        return viewHolder
    }

    override fun getItemCount(): Int {
        return this.cuponList.count()
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val item = cuponList.get(position)

        holder.bindCupon(item)
    }


    class ViewHolder(itemView: View, context: Context) : RecyclerView.ViewHolder(itemView),
        View.OnClickListener {

        private var offer: Offer ?= null

        init {
            itemView.setOnClickListener(this)
        }



        fun bindCupon(offer: Offer) {
            this.offer = offer
            itemView.tv_offer.text = offer.offer
            itemView.tv_offertext.text =offer.offerText
            itemView.tv_offervalue.text = offer.offerValue
            if(offer.imageUrl.isNotEmpty())
                Picasso.get().load(offer.imageUrl).into(itemView.iv_logo)
            else
                Picasso.get().load(R.mipmap.logo).into(itemView.iv_logo)

            itemView.tv_store.text = offer.store

        }


        override fun onClick(v: View?) {

            val intent = Intent (itemView.context, DetailActivity::class.java)
            intent.putExtra("offer",offer)
            itemView.context.startActivity(intent)

        }

    }
}