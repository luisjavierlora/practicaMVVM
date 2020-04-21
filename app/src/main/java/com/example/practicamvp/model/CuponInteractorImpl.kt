package com.example.practicamvp.model

import com.example.practicamvp.presenter.CuponPresenter

class CuponInteractorImpl(var cuponPresenter: CuponPresenter):CuponInteractor {


    private var cuponRepository:CuponRepository = CuponRepositoryImpl(cuponPresenter)

    override fun loadListCupons() {
            cuponRepository.loadListCupons()
    }

}