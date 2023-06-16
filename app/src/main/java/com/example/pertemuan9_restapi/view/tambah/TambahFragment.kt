package com.example.pertemuan9_restapi.view.tambah

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.fragment.findNavController
import com.example.pertemuan9_restapi.R
import com.example.pertemuan9_restapi.databinding.FragmentTambahBinding
import com.example.pertemuan9_restapi.viewmodel.ViewModelMahasiswa

class TambahFragment : Fragment() {
    private lateinit var binding: FragmentTambahBinding
    private lateinit var viewModel: ViewModelMahasiswa

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        binding = FragmentTambahBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        viewModel = ViewModelProvider(this).get(ViewModelMahasiswa::class.java)
        binding.btnTambah.setOnClickListener {
            val nim = binding.inputNim.text.toString()
            val nama = binding.inputNama.text.toString()
            val telepon = binding.inputTelepon.text.toString()
            viewModel.insertMahasiswa().observe(viewLifecycleOwner){
                if(it != null){
                    Toast.makeText(context, "Data Berhasil Ditambahkan", Toast.LENGTH_SHORT).show()
                    findNavController().navigateUp()
                }else{
                    Toast.makeText(context, "Data Gagal Ditambahkan", Toast.LENGTH_SHORT).show()
                }
            }
            viewModel.addMahasiswa(nim, nama, telepon)
        }
        binding.btnBack.setOnClickListener {
            findNavController().navigateUp()
        }
    }

}