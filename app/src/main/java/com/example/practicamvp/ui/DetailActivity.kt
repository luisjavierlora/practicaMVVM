package com.example.practicamvp.ui

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.practicamvp.R
import com.example.practicamvp.model.Offer
import com.squareup.picasso.Picasso
import kotlinx.android.synthetic.main.activity_detail.*
import kotlinx.android.synthetic.main.item.*
import kotlinx.android.synthetic.main.item.view.*

class DetailActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_detail)

        val offer = intent?.getSerializableExtra("offer") as Offer

        ShowCupon(offer)

    }


    fun ShowCupon(offer: Offer){

        tv_offertextd.text = offer.offerText
        tv_stored.text =offer.store
        tv_category.text =offer.categories
        tv_description.text=offer.description
        if(offer.imageUrl.isNotEmpty())
            Picasso.get().load(offer.imageUrl).into(iv_logod)
        else
            Picasso.get().load(R.mipmap.logo).into(iv_logod)

        tv_code.text =offer.code
        tv_end.text=offer.endDate
        tv_url.text=offer.url
    }
}
