package com.example.practicamvp.model

import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.http.GET
import retrofit2.http.Query

interface RetrofitService {

    @GET("getOffers/")
    fun getOffers(@Query("API_KEY") apiKey:String, @Query("format") format:String): retrofit2.Call<Cupon>
    companion object{
        val urlAPI ="http://feed.linkmydeals.com/"

        fun create():RetrofitService{
            val retrofit = Retrofit.Builder()
                .baseUrl(urlAPI)
                .addConverterFactory(GsonConverterFactory.create())
                .build()

            return retrofit.create(RetrofitService::class.java)
        }

    }

}