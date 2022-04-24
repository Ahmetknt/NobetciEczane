package com.ahmetkanat.nobetcieczane.response

import com.ahmetkanat.nobetcieczane.model.Eczane

data class EczaneResponse(
    val result : List<Eczane>,
    val success : Boolean
)
