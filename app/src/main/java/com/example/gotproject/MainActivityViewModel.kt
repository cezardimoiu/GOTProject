package com.example.gotproject

import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class MainActivityViewModel @Inject constructor(private val dataItems: RetroDataItem)
    : ViewModel(){

    fun getAllDataItemsList(): LiveData<List<DataCharactersItem>> {
        return dataItems.getAllRecords()
    }

    fun makeApiCall() {
        dataItems.makeApiCall()
    }
}