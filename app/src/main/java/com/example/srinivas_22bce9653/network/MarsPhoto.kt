package com.example.srinivas_22bce9653.network

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable


// serializable = balloon -- inflate -- make the object transport ready
// inflate -- deserialization -- autocad - serial numbers on the floppy
@Serializable
data class MarsPhoto(
    val id: String,
    @SerialName(value = "img_src")
    val imgSrc: String
)