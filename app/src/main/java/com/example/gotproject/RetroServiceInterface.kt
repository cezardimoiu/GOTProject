package com.example.gotproject

import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Query

interface RetroServiceInterface {
    @GET("characters?page=1&pageSize=50")
    fun getDataFromAPI(): Call<DataCharacters>
}