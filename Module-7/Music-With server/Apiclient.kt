package com.example.musicplayerwithserver

import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

class Apiclient
{
    companion object
    {
        var BASE_URL="https://unaffecting-firearm.000webhostapp.com/Music%20folder/Music/"
        lateinit var retrofit: Retrofit

        fun getapiclient() : Retrofit
        {
            retrofit = Retrofit.Builder().baseUrl(BASE_URL)
                .addConverterFactory(GsonConverterFactory.create())
                .build()

            return retrofit
        }
    }
}