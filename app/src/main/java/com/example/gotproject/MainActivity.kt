package com.example.gotproject

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
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

        initViewModel()
        initMainViewModel()
    }

    private fun initViewModel() {
        recyclerview_characters.apply {
            linearLayoutManager = LinearLayoutManager(this@MainActivity)

            myAdapter = Adapter()
        }
    }

    private fun initMainViewModel() {
        val viewModel = ViewModelProvider(this).get(MainActivityViewModel::class.java)
        viewModel.getAllDataItemsList().observe(this, Observer<List<DataCharactersItem>> {
            myAdapter.setListData(it)
            myAdapter.notifyDataSetChanged()
        })

        viewModel.makeApiCall()
    }



}