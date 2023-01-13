package com.example.gotproject

import androidx.lifecycle.LiveData
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import javax.inject.Inject

class RetroDataItem @Inject constructor(private val retroServiceInterface: RetroServiceInterface,
                                        private val appDao: AppDao)
{
    fun getAllRecords(): LiveData<List<DataCharactersItem>> {
        return appDao.getAllRecords()
    }

    fun insertRecord(dataCharactersItem: DataCharactersItem) {
        appDao.insertRecords(dataCharactersItem)
    }

    fun makeApiCall() {
        val call: Call<DataCharacters> = retroServiceInterface.getDataFromAPI()
        call?.enqueue(object : Callback<DataCharacters> {
            override fun onResponse(
                call: Call<DataCharacters>,
                response: Response<DataCharacters>
            ) {
                if(response.isSuccessful) {
                    appDao.deleteAllRecords()
                    response.body()?.items?.forEach {
                        insertRecord(it)
                    }
                }
            }

            override fun onFailure(call: Call<DataCharacters>, t: Throwable) {
                //TODO("Not yet implemented")
            }
        })
    }
}
