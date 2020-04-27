package com.example.practicamvp.model

import androidx.databinding.BaseObservable
import androidx.lifecycle.MutableLiveData
import com.example.practicamvp.model.obj.Offer

class MainObservable : BaseObservable() {

    private var mainRepository: IMainRepository = MainRepository()


    fun callCupons(){
        mainRepository.callCuponAPI()
    }

    fun getCupons() : MutableLiveData<List<Offer>>{
        return mainRepository.getCupons()
    }
}

