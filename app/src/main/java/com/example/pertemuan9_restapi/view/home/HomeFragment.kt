package com.example.pertemuan9_restapi.view.home

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.LinearLayout
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.pertemuan9_restapi.R
import com.example.pertemuan9_restapi.adapter.HomeAdapter
import com.example.pertemuan9_restapi.databinding.FragmentHomeBinding
import com.example.pertemuan9_restapi.viewmodel.ViewModelMahasiswa

class HomeFragment : Fragment() {
    private lateinit var binding : FragmentHomeBinding
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        binding = FragmentHomeBinding.inflate(layoutInflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        binding.btnMovetoTambah.setOnClickListener {
            findNavController().navigate(R.id.action_homeFragment_to_tambahFragment)
        }

        val viewModel = ViewModelProvider(this).get(ViewModelMahasiswa::class.java)
        viewModel.getDataMahasiswa().observe(viewLifecycleOwner){
            if(it != null){
                binding.rvUser.layoutManager =
                    LinearLayoutManager(context, LinearLayoutManager.VERTICAL, false)
                val adapter = HomeAdapter(it)
                binding.rvUser.adapter = adapter
        }else{
            binding.rvUser.visibility = View.GONE
            }
        }
        viewModel.showDataMahasiswa()
    }

}