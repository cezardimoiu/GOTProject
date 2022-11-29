package com.example.gotproject

import retrofit2.Call
import retrofit2.http.GET

interface ApiInterface {
    @GET("characters?page=1&pageSize=50")
    fun getCharactersData(): Call<List<DataCharactersItem>>
}