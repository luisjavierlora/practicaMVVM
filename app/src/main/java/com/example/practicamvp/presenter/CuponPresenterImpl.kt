package com.example.practicamvp.presenter

import com.example.practicamvp.model.CuponInteractor
import com.example.practicamvp.model.CuponInteractorImpl
import com.example.practicamvp.model.CuponRepository
import com.example.practicamvp.model.Offer
import com.example.practicamvp.ui.CuponView

class CuponPresenterImpl(var cuponView: CuponView):CuponPresenter {

    private var cuponInteractor:CuponInteractor = CuponInteractorImpl(this)

    override fun loadListCupons() {
        cuponInteractor.loadListCupons()
    }

    override fun SendDataErrorfromApi(throwable: Throwable) {
        cuponView.showErrorFromApi(throwable)
    }

    override fun SendListCupons(cupones: List<Offer>) {
        cuponView.showListCupons(cupones)
    }

}