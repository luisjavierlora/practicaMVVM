package com.example.practicamvp

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.practicamvp.presenter.CuponPresenterImpl
import com.example.practicamvp.presenter.CuponPresenter
import com.example.practicamvp.model.Offer
import com.example.practicamvp.ui.CuponView
import com.example.practicamvp.ui.Rv_CuponesAdapter
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity(),CuponView {

    private var cuponPresenter : CuponPresenter ?= null


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        cuponPresenter = CuponPresenterImpl(this)

        cuponPresenter?.loadListCupons()

    }

    override fun showListCupons(result: List<Offer>) {
        //tv.text  = result.get(0).title

        rv_cupones.layoutManager = LinearLayoutManager(
            this,
            RecyclerView.VERTICAL,
            false
        )

        val CuponesAdapter = Rv_CuponesAdapter(this,result as ArrayList<Offer>)

        rv_cupones.adapter =CuponesAdapter

    }


    override fun showErrorFromApi(throwable: Throwable) {
        Toast.makeText(this,"Error $throwable.localizedMessage",Toast.LENGTH_SHORT).show()
    }



}
