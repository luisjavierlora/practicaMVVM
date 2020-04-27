package com.example.practicamvp.ui

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.Toast
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.practicamvp.R
import com.example.practicamvp.databinding.ActivityMainBinding
import com.example.practicamvp.viewmodel.MainViewModel
import com.example.practicamvp.model.obj.Offer
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    private var mainViewModel: MainViewModel? = null



    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        setupBinding(savedInstanceState)
    }


    fun setupBinding(savedInstanceState: Bundle?) {

        var activityMainBinding: ActivityMainBinding =
            DataBindingUtil.setContentView(this, R.layout.activity_main)

        mainViewModel = ViewModelProvider(this).get(MainViewModel::class.java)

        activityMainBinding.model = mainViewModel
        activityMainBinding.lifecycleOwner = this
        setUpListUpdate()
    }


    fun setUpListUpdate() {
        mainViewModel?.CallCupons()

        mainViewModel?.getCupons()?.observe(this, Observer {cupons ->
            Log.d("Cupon", cupons[0].title)
            mainViewModel?.setCuponsInCuponsAdapter(cupons)
        })

        setupListClick()
    }

    fun setupListClick(){
        mainViewModel?.getCuponSelected()?.observe(this, Observer{cupon->
            val intent = Intent (this, DetailActivity::class.java)
            intent.putExtra("cupon", cupon)
            startActivity(intent)
        })
    }



     fun showErrorFromApi(throwable: Throwable) {
        Toast.makeText(this,"Error $throwable.localizedMessage",Toast.LENGTH_SHORT).show()
    }



}
