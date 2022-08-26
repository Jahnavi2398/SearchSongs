package com.example.searchsongs.network

import com.squareup.moshi.Json

data class Songs(val results: List<ResponseResult>)

data class ResponseResult(
    val artistId : Int ,
    val artworkUrl100 : String,
   // @Json(name = "artworkUrl100") val imgSrcUrl : String,
)




