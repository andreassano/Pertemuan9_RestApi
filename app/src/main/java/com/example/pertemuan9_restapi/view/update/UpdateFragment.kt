package com.example.pertemuan9_restapi.view.update

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
import com.example.pertemuan9_restapi.databinding.FragmentUpdateBinding
import com.example.pertemuan9_restapi.viewmodel.ViewModelMahasiswa

class UpdateFragment : Fragment() {
    private lateinit var binding: FragmentUpdateBinding
    private lateinit var viewModel: ViewModelMahasiswa

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        binding = FragmentUpdateBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val nim =  arguments?.getString("nim")
        val nama =  arguments?.getString("nama")
        val telepon =  arguments?.getString("telepon")

        binding.inputNim.setText(nim)
        binding.inputNama.setText(nama)
        binding.inputTelepon.setText(telepon)

        binding.btnBack.setOnClickListener{
            findNavController().navigateUp()
        }

        viewModel = ViewModelProvider(this).get(ViewModelMahasiswa::class.java)

        binding.btnUpdate.setOnClickListener {
            var nim = binding.inputNim.text.toString()
            var nama = binding.inputNama.text.toString()
            var telepon = binding.inputTelepon.text.toString()
            viewModel.updateMahasiswa().observe(viewLifecycleOwner,{
                if(it !=null){
                    Toast.makeText(context, "Data Behasil Diupdate", Toast.LENGTH_SHORT).show()
                    findNavController().navigateUp()
                }else{
                    Toast.makeText(context, "Data Gagal Diupdate", Toast.LENGTH_SHORT).show()

                }
            })

            viewModel.updateMahasiswa(nim, nama, telepon)
        }


    }

}