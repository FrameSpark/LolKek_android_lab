package com.vsu.framespark.android.Services

import com.google.gson.GsonBuilder
import com.vsu.framespark.android.Interfaces.JSONPlaceholderApi
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory


class PeopleService {
    val gsonBuilder:GsonBuilder = GsonBuilder();

    private val mRetforit: Retrofit = Retrofit.Builder()
        .baseUrl(BASE_URL)
        .addConverterFactory(
            GsonConverterFactory.create(gsonBuilder.setLenient().create())
        ).build()
    val JSONApi: JSONPlaceholderApi
        get() = mRetforit.create(JSONPlaceholderApi::class.java)

    companion

    object {
        private var mInstance: PeopleService? = null
        private const val BASE_URL = "https://kekes-lol.herokuapp.com/"
        val inctance: PeopleService?
            get() {
                if (mInstance == null) {
                    mInstance = PeopleService()
                }
                return mInstance;
            }
    }
}