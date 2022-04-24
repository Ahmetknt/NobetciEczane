package com.ahmetkanat.nobetcieczane.view

import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.LinearLayoutManager
import com.ahmetkanat.nobetcieczane.R
import com.ahmetkanat.nobetcieczane.adapter.EczaneAdapter
import com.ahmetkanat.nobetcieczane.databinding.FragmentEczaneBinding
import com.ahmetkanat.nobetcieczane.model.Eczane
import com.ahmetkanat.nobetcieczane.network.APIUtils
import com.ahmetkanat.nobetcieczane.response.EczaneResponse
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class EczaneFragment : Fragment() {

    private lateinit var binding : FragmentEczaneBinding
    var eczList : ArrayList<Eczane> = arrayListOf()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentEczaneBinding.inflate(layoutInflater)

        binding.searchButton.setOnClickListener {

            val ilce = binding.districtText.text.toString().trim()
            val il = binding.provinceText.text.toString().trim()
            getEczane(ilce,il)
        }

        return binding.root
    }

    private fun getEczane(ilce : String,il : String){

        APIUtils.eczaneDAOGet().getEczane(ilce,il).enqueue(
            object : Callback<EczaneResponse>{
                override fun onResponse(
                    call: Call<EczaneResponse>,
                    response: Response<EczaneResponse>
                ) {
                    val tempList = response.body()?.result
                    tempList?.let {
                        eczList = it as ArrayList<Eczane>
                    }

                    val eczAdapter = EczaneAdapter(eczList)
                    binding.rvEczane.adapter = eczAdapter
                    binding.rvEczane.layoutManager = LinearLayoutManager(context)
                    binding.rvEczane.setHasFixedSize(true)
                }

                override fun onFailure(call: Call<EczaneResponse>, t: Throwable) {
                    Toast.makeText(context,"Lütfen ili ve ilçeyi doğru girdiğinizden emin olun",Toast.LENGTH_SHORT).show()
                }

            }
        )


    }

}