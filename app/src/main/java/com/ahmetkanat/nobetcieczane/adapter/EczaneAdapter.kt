package com.ahmetkanat.nobetcieczane.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.ahmetkanat.nobetcieczane.databinding.EczCardBinding
import com.ahmetkanat.nobetcieczane.model.Eczane

class EczaneAdapter(private val eczList : List<Eczane>) : RecyclerView.Adapter<EczaneAdapter.EczaneHolder>() {


    class EczaneHolder(var eczCardBinding: EczCardBinding) : RecyclerView.ViewHolder(eczCardBinding.root){

    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): EczaneHolder {
        val layoutInflater = LayoutInflater.from(parent.context)
        val binding = EczCardBinding.inflate(layoutInflater,parent,false)
        return EczaneHolder(binding)
    }

    override fun onBindViewHolder(holder: EczaneHolder, position: Int) {
        val ecz = eczList[position]

        holder.eczCardBinding.apply {
            nameText.text = ecz.name
            addressText.text = ecz.address
            distText.text = ecz.dist
            phoneText.text = ecz.phone
        }
    }

    override fun getItemCount(): Int {
        return eczList.size
    }
}