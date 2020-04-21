package com.example.practicamvp.ui

import com.example.practicamvp.model.Cupon
import com.example.practicamvp.model.Offer

interface CuponView {

    fun showListCupons(result: List<Offer>)
    fun showErrorFromApi(throwable: Throwable)

}