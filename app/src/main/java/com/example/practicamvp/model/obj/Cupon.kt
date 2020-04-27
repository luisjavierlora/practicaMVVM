package com.example.practicamvp.model.obj


import com.google.gson.annotations.SerializedName
import java.io.Serializable

data class Cupon(
    @SerializedName("offers")
    val offers: List<Offer>,
    @SerializedName("result")
    val result: Boolean
):Serializable