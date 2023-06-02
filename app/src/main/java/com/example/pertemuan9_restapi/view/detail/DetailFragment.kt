package com.example.pertemuan9_restapi.view.detail

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.lifecycle.ViewModelProvider
import com.example.pertemuan9_restapi.R
import com.example.pertemuan9_restapi.databinding.FragmentDetailBinding
import com.example.pertemuan9_restapi.viewmodel.ViewModelMahasiswa

class DetailFragment : Fragment() {
    private lateinit var viewModel : ViewModelMahasiswa
    private lateinit var binding : FragmentDetailBinding

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        binding = FragmentDetailBinding.inflate(layoutInflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        val nim = arguments?.getString("nim")

        val viewModel = ViewModelProvider(this).get(ViewModelMahasiswa::class.java)
        viewModel.getDetailDataMahasiswa().observe(viewLifecycleOwner){
            if (it != null){
                binding. txtnim.text = it.data?.nIM
                binding. txtnama.text = it.data?.nama
                binding. txttelepon.text = it.data?.telepon
            }else{
                Toast.makeText(context,"Data Tidak Ditemukan", Toast.LENGTH_SHORT).show()
            }
        }
        viewModel.getDetailData(nim!!)
    }

}