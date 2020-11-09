package com.satriaamrudito.detik.service

import com.satriaamrudito.detik.model.ResponseNews
import okhttp3.OkHttpClient
import retrofit2.Call
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.http.GET
import retrofit2.http.Headers

object RetrofitBuilder {

    private val client: OkHttpClient = OkHttpClient.Builder().build()
    private val retrofit: Retrofit = Retrofit.Builder()
        .baseUrl("https://newsapi.org/")
        .addConverterFactory(GsonConverterFactory.create())
        .client(client)
        .build()

    fun getService() = retrofit.create(TopHeadLines::class.java)
}

interface TopHeadLines{
    @Headers("Authorization: da548c64deef40b58c5296af8d3c333e")
    @GET("v2/top-headlines?country=id")
    fun feachHeadLines(): Call<ResponseNews>


}