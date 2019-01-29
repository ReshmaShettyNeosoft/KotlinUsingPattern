package com.droidipc.kotlinusingpattern.service

import com.droidipc.kotlinusingpattern.login.LoginResponseDTO
import retrofit2.Call
import retrofit2.http.*

interface RetrofitAPIinterface {
    @FormUrlEncoded
    @POST("users/login/")
    fun loginRequest(@Field("email") email: String, @Field("password") password: String): Call<LoginResponseDTO>
}