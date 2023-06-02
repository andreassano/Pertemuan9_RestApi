package com.example.pertemuan9_restapi.model.request


import com.google.gson.annotations.SerializedName

data class DataMahasiswa(
    @SerializedName("NIM")
    val nIM: String,
    @SerializedName("Nama")
    val nama: String,
    @SerializedName("Telepon")
    val telepon: String
)