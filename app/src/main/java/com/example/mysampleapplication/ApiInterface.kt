package com.example.mysampleapplication

import retrofit2.Call
import retrofit2.Response
import retrofit2.http.*

interface ApiInterface {
    @Headers("Content-Type: application/json")
    @POST("login")
    fun postData(@Body users:UserData): Call<LoginData>

}

interface DishApiService {
    @GET("dishes")
    suspend fun GetDishes(@Header("Authorization") token: String): Response<AllDishes>
}


interface RegisterApiInterface {
    @Headers("Content-Type: application/json")
    @POST("register")
    fun postRegData(@Body reg: UserData): Call<LoginData>
}
