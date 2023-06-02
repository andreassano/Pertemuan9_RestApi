package com.example.pertemuan9_restapi.viewmodel

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.pertemuan9_restapi.model.request.DataMahasiswa
import com.example.pertemuan9_restapi.model.request.DetailDataMahasiswa
import com.example.pertemuan9_restapi.model.response.ResponseDataMahasiswa
import com.example.pertemuan9_restapi.model.response.ResponseDetailMahasiswa
import com.example.pertemuan9_restapi.network.ApiClient
import retrofit2.Call
import retrofit2.Response
import retrofit2.Retrofit
import javax.security.auth.callback.Callback

class ViewModelMahasiswa : ViewModel() {
    private val getDataMahasiswa = MutableLiveData<List<DataMahasiswa>?>()
    private val getDetailDataMahasiswa = MutableLiveData<ResponseDetailMahasiswa?>()

    fun getDataMahasiswa() : MutableLiveData<List<DataMahasiswa>?>{
        return getDataMahasiswa
    }

    fun getDetailDataMahasiswa() : MutableLiveData<ResponseDetailMahasiswa?>{
        return getDetailDataMahasiswa
    }



    fun showDataMahasiswa(){
        ApiClient.instance.getDataMahasiswa().enqueue(object : retrofit2.Callback<ResponseDataMahasiswa>{
            override fun onResponse(
                call: Call<ResponseDataMahasiswa>,
                response: Response<ResponseDataMahasiswa>
            ) {
                if (response.isSuccessful){
                    getDataMahasiswa.postValue(response.body()?.data)
                }else{
                    getDataMahasiswa.postValue(null)
                }
            }

            override fun onFailure(call: Call<ResponseDataMahasiswa>, t: Throwable) {
                getDataMahasiswa.postValue(null)
            }

        })
    }

    fun getDetailData(nim : String){
        ApiClient.instance.getDetailMahasiswa(nim).enqueue(object : retrofit2.Callback<ResponseDetailMahasiswa> {
            override fun onResponse(
                call: Call<ResponseDetailMahasiswa>,
                response: Response<ResponseDetailMahasiswa>
            ) {
                if (response.isSuccessful){
                    getDetailDataMahasiswa.postValue(response.body())
                }else{
                    getDetailDataMahasiswa.postValue(null)
                }
            }

            override fun onFailure(call: Call<ResponseDetailMahasiswa>, t: Throwable) {
                getDetailDataMahasiswa.postValue(null)
            }

        })
    }

}