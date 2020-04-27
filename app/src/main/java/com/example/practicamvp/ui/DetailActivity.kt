package com.example.practicamvp.ui

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.ViewModelProvider
import com.example.practicamvp.R
import com.example.practicamvp.databinding.ActivityDetailBinding
import com.example.practicamvp.model.obj.Offer
import com.example.practicamvp.viewmodel.DetailViewModel
import com.squareup.picasso.Picasso
import kotlinx.android.synthetic.main.activity_detail.*

class DetailActivity : AppCompatActivity() {

    private var detailViewModel: DetailViewModel? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_detail)

        setupBinding(savedInstanceState)

    }

    fun setupBinding(savedInstanceState: Bundle?) {

        var activityDetalleBinding: ActivityDetailBinding =
            DataBindingUtil.setContentView(this, R.layout.activity_detail)

        detailViewModel = ViewModelProvider(this).get(DetailViewModel::class.java)

        activityDetalleBinding.model = detailViewModel
        activityDetalleBinding.lifecycleOwner = this

        detailViewModel?.setDetalleCupon(intent?.getSerializableExtra("cupon") as Offer)
    }
}
