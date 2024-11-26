package com.example.project1.data.model.network

import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory


object RetrofitClient{
    private const val Base_URL ="https://fakeapi.rickbit.net/fakeapi/public/api/"
    val api: ApiService by lazy{
        Retrofit.Builder()
            .baseUrl(Base_URL)
            .addConverterFactory(GsonConverterFactory.create())
            .build()
            .create(ApiService::class.java)
    }
}