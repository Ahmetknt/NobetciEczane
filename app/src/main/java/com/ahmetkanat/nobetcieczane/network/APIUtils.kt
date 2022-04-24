package com.ahmetkanat.nobetcieczane.network

import com.ahmetkanat.nobetcieczane.util.Constants.BASE_URL
import retrofit2.Retrofit

class APIUtils {
    companion object{

        fun eczaneDAOGet() : EczaneDAO{
            return RetrofitClient.getClient(BASE_URL).create(EczaneDAO::class.java)
        }

    }

}