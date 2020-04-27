package com.example.practicamvp.viewmodel

import android.widget.ImageView
import androidx.databinding.BindingAdapter
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.practicamvp.R
import com.example.practicamvp.model.obj.Offer
import com.squareup.picasso.Picasso
import kotlinx.android.synthetic.main.activity_detail.view.*
import kotlinx.android.synthetic.main.item.view.*

class DetailViewModel: ViewModel() {

    private var cupon: MutableLiveData<Offer> = MutableLiveData()

    fun setDetalleCupon(cupon: Offer) {
        this.cupon.value = cupon
    }

    fun getCupon() = cupon

    companion object {
        @JvmStatic
        @BindingAdapter("loadImageDetail")
        fun loadImage(imageView: ImageView, imageUrl: String){
            if(imageUrl.isNotEmpty())
                Picasso.get().load(imageUrl).into(imageView.iv_logod)
            else
                Picasso.get().load(R.mipmap.logo).into(imageView.iv_logod)

        }
    }

}