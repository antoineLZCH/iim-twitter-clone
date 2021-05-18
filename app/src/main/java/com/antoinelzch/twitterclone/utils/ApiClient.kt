package com.antoinelzch.twitterclone.utils

import com.google.gson.Gson
import com.google.gson.GsonBuilder
import okhttp3.OkHttpClient
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

object ApiClient {
    private const val BASE_URL = "https://0351fde4-7599-4813-a0fa-727f881dfb88.mock.pstmn.io/"

    private val gson: Gson by lazy {
        GsonBuilder().setLenient().create()
    }

    private val httpClient: OkHttpClient by lazy {
        OkHttpClient.Builder().build()
    }

    private val retrofit: Retrofit by lazy {
        Retrofit.Builder()
            .baseUrl(BASE_URL)
            .client(httpClient)
            .addConverterFactory(GsonConverterFactory.create(gson))
            .build()
    }

    fun<T> buildService(service: Class<T>): T {
        return retrofit.create(service)
    }

    val apiService : ApiService by lazy {
        retrofit.create(ApiService::class.java)
    }
}