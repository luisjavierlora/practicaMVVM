package com.example.practicamvp.model

import androidx.lifecycle.MutableLiveData
import com.example.practicamvp.model.obj.Offer

interface IMainRepository {

    fun getCupons():MutableLiveData<List<Offer>>
    fun callCuponAPI()
}