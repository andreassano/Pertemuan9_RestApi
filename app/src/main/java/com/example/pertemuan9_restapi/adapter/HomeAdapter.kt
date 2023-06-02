package com.example.pertemuan9_restapi.adapter

import android.os.Bundle
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.navigation.Navigation
import androidx.recyclerview.widget.RecyclerView
import com.example.pertemuan9_restapi.R
import com.example.pertemuan9_restapi.databinding.UserListBinding
import com.example.pertemuan9_restapi.model.request.DataMahasiswa

class HomeAdapter(private var dataMahasiswa: List<DataMahasiswa>) : RecyclerView.Adapter<HomeAdapter.ViewHolder>() {
    class ViewHolder (val binding: UserListBinding) : RecyclerView.ViewHolder(binding.root)

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val view = UserListBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return ViewHolder(view)
    }

    override fun getItemCount(): Int {
        return dataMahasiswa.size
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.binding.txtNama.text = dataMahasiswa[position].nama
        holder.binding.txtNim.text = dataMahasiswa[position].nIM
        holder.binding.txtTelepon.text = dataMahasiswa[position].telepon
        holder.binding.cardView.setOnClickListener {
            val bundle = Bundle()
            bundle.putString("nim", dataMahasiswa[position].nIM)
            bundle.putString("nama", dataMahasiswa[position].nama)
            bundle.putString("telepon", dataMahasiswa[position].telepon)
            Navigation.findNavController(it).navigate(R.id.action_homeFragment_to_detailFragment,bundle)

        }
    }
}