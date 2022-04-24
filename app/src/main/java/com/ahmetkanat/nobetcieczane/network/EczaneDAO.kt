package com.ahmetkanat.nobetcieczane.network

import com.ahmetkanat.nobetcieczane.response.EczaneResponse
import com.ahmetkanat.nobetcieczane.util.Constants.AUTHORIZATION
import com.ahmetkanat.nobetcieczane.util.Constants.CONTENT
import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Header
import retrofit2.http.Headers
import retrofit2.http.Query

interface EczaneDAO {

    @Headers(
        "authorization: ${AUTHORIZATION}",
        "content-type: ${CONTENT}"
    )
    @GET("dutyPharmacy")
    fun getEczane(
        @Query("ilce") ilce : String,
        @Query("il") il : String
    ) : Call<EczaneResponse>
}