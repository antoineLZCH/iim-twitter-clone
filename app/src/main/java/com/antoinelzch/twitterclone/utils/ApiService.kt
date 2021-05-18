package com.antoinelzch.twitterclone.utils

import com.antoinelzch.twitterclone.models.User
import retrofit2.Call
import retrofit2.http.*

interface ApiService {

    // @GET("users")
    // suspend fun getUsers(): Response<MutableList<User>>

    // @GET("users/{id}")
    // suspend fun getUserById(@Path("id") id : UUID) : Response<User>

    @GET("/login")
    fun login(): Call<Void>
}