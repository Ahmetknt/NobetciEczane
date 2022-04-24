package com.ahmetkanat.nobetcieczane.model

import java.io.Serializable

data class Eczane(
    val name : String,
    val dist : String,
    val address : String,
    val phone : String,
    val loc : String
) : Serializable
