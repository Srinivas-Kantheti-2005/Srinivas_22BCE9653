package com.example.srinivas_22bce9653.network

import com.squareup.moshi.Json


// serializable = balloon -- inflate -- make the object transport ready
// inflate -- deserialization -- autocad - serial numbers on the floppy

//break down our project based into independently testable cases -- small, discrete, independent

data class MarsPhoto(
    val id: String,
    @Json(name = "img_src")
    val imgSrc: String
)