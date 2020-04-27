package com.example.practicamvp.viewmodel

import android.widget.ImageView
import androidx.databinding.BindingAdapter
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.practicamvp.R
import com.example.practicamvp.model.MainObservable
import com.example.practicamvp.model.obj.Cupon

import com.example.practicamvp.model.obj.Offer
import com.example.practicamvp.ui.CuponView
import com.example.practicamvp.ui.Rv_CuponesAdapter
import com.squareup.picasso.Picasso
import kotlinx.android.synthetic.main.item.view.*

class MainViewModel():ViewModel() {

    private var mainObservable: MainObservable = MainObservable()
    private var cuponAdapter: Rv_CuponesAdapter?= null
    private var cuponSelected : MutableLiveData<Offer> = MutableLiveData()


    fun CallCupons(){
        mainObservable.callCupons()
    }

    fun getCupons():MutableLiveData<List<Offer>>{
        return mainObservable.getCupons()
    }

   fun setCuponsInCuponsAdapter( Cupons: List<Offer>){
        cuponAdapter?.setCuponsList(Cupons)
        cuponAdapter?.notifyDataSetChanged()

   }



    fun getRecyclerCuponsAdapter() : Rv_CuponesAdapter? {
        cuponAdapter = Rv_CuponesAdapter(this)
        return cuponAdapter
    }

    fun getCuponItem(position: Int): Offer?{
        val cupons: List<Offer>? = mainObservable.getCupons().value
        return cupons?.get(position)
    }


    fun getCuponSelected() : MutableLiveData<Offer>{
        return cuponSelected
    }


    fun onItemClick(position: Int){
        val cupon = getCuponItem(position)
        cuponSelected.value = cupon
    }

    companion object{
        @JvmStatic
        @BindingAdapter("loadImage")
        fun loadImage(imageView: ImageView, imageUrl: String){
            if(imageUrl.isNotEmpty())
                Picasso.get().load(imageUrl).into(imageView.iv_logo)
            else
                Picasso.get().load(R.mipmap.logo).into(imageView.iv_logo)

        }
    }
}