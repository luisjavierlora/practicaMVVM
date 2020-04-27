package com.example.practicamvp.ui

import com.example.practicamvp.model.obj.Offer

interface CuponView {

    fun showListCupons(result: List<Offer>)
    fun showErrorFromApi(throwable: Throwable)

}