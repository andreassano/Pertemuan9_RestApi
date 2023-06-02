package com.example.pertemuan9_restapi.model.response


import com.example.pertemuan9_restapi.model.request.DataMahasiswa
import com.google.gson.annotations.SerializedName

data class ResponseDataMahasiswa(
    @SerializedName("data")
    val data: List<DataMahasiswa>,
    @SerializedName("status")
    val status: String
)