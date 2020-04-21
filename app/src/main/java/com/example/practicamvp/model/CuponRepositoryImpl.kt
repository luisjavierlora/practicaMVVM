package com.example.practicamvp.model

import android.util.Log
import com.example.practicamvp.presenter.CuponPresenter
import retrofit2.Call
import retrofit2.Response

class CuponRepositoryImpl(var cuponPresenter: CuponPresenter):CuponRepository {


    override fun loadListCupons() {
        val apiKey="78a5445cf99c588ceeabf690661cc374"
        val format:String ="json"
        RetrofitService.create()
            .getOffers(apiKey,format)
            .enqueue(object : retrofit2.Callback<Cupon> {
                override fun onFailure(call: Call<Cupon>, t: Throwable) {
                    cuponPresenter.SendDataErrorfromApi(t)
                    Log.e("Error",t.localizedMessage!!)
                }

                override fun onResponse(call: Call<Cupon>, response: Response<Cupon>) {
                    cuponPresenter.SendListCupons(response.body()!!.offers)
                }
            })
    }

}