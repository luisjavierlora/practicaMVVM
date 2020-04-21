package com.example.practicamvp.presenter

import com.example.practicamvp.model.Offer

interface CuponPresenter {

    fun loadListCupons()
    fun SendListCupons(cupones: List<Offer>)
    fun SendDataErrorfromApi(throwable: Throwable)
}