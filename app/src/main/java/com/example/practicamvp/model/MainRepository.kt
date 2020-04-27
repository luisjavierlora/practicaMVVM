package com.example.practicamvp.model

import android.util.Log
import androidx.lifecycle.MutableLiveData
import com.example.practicamvp.model.obj.Cupon
import com.example.practicamvp.model.obj.Offer
import com.example.practicamvp.model.server.RetrofitService
import retrofit2.Call
import retrofit2.Response

class MainRepository(): IMainRepository {

    private var cupons = MutableLiveData<List<Offer>>()


    override fun getCupons() : MutableLiveData<List<Offer>> {
        return cupons
    }

    override fun callCuponAPI() {
        var listaCupon: ArrayList<Offer>? = ArrayList()
        val apiKey="78a5445cf99c588ceeabf690661cc374"
        val format:String ="json"
        RetrofitService.create()
            .getOffers(apiKey,format)
            .enqueue(object : retrofit2.Callback<Cupon> {
                override fun onFailure(call: Call<Cupon>, t: Throwable) {
                    Log.e("Error",t.localizedMessage!!)
                }

                override fun onResponse(call: Call<Cupon>, response: Response<Cupon>) {

                    if (response.isSuccessful)
                        listaCupon= response.body()?.offers as ArrayList<Offer>

                    cupons.value =listaCupon
                }
            })
    }


}