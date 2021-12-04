package com.vsu.framespark.android

import com.vsu.framespark.android.Models.People
import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Query

interface JSONPlaceholderApi {
    @GET("/data")
    fun getAdvice(): Call<List<People>>
    //fun getAdvice(@Query("id") id:String): Call<List<People>>
}