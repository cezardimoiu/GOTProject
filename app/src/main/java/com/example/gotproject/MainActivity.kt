package com.example.gotproject

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.LinearLayoutManager
import android.util.Log
import androidx.recyclerview.widget.RecyclerView
import android.widget.TextView
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import java.lang.StringBuilder

const val BASE_URL = "https://anapioficeandfire.com/api/"
class MainActivity : AppCompatActivity() {

    lateinit var myAdapter: Adapter
    lateinit var linearLayoutManager: LinearLayoutManager
    lateinit var recyclerview_characters: RecyclerView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        recyclerview_characters = findViewById<RecyclerView>(R.id.recyclerview_characters)

        recyclerview_characters.setHasFixedSize(true)
        linearLayoutManager =
            LinearLayoutManager(this)
        recyclerview_characters.layoutManager = linearLayoutManager
        getMyData()
    }

    private fun getMyData() {
        val retrofitBuilder = Retrofit.Builder()
            .addConverterFactory(GsonConverterFactory.create())
            .baseUrl(BASE_URL)
            .build()
            .create(ApiInterface::class.java)

        val retrofitData = retrofitBuilder.getCharactersData()

        retrofitData.enqueue(object : Callback<List<DataCharactersItem>?> {
            override fun onResponse(
                call: Call<List<DataCharactersItem>?>,
                response: Response<List<DataCharactersItem>?>
            ) {
                val responseBody = response.body()!!

                myAdapter = Adapter(baseContext, responseBody)
                myAdapter.notifyDataSetChanged()
                recyclerview_characters.adapter = myAdapter
            }

            override fun onFailure(call: Call<List<DataCharactersItem>?>, t: Throwable) {
                Log.d("MainActivity", "onFailure" + t.message)
            }
        })
    }
}