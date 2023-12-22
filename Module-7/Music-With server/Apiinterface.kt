package com.example.musicplayerwithserver
import retrofit2.Call
import retrofit2.http.Field
import retrofit2.http.FormUrlEncoded
import retrofit2.http.GET

import retrofit2.http.POST

interface Apiinterface
{

    @GET("View.php")
    fun music():Call<List<Model>>
}