package com.example.gotproject

import androidx.lifecycle.LiveData
import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query

@Dao
interface AppDao {
    @Query("SELECT * FROM DataCharacters")
    fun getAllRecords(): LiveData<List<DataCharactersItem>>

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun insertRecords(dataCharactersItem: DataCharactersItem)

    @Query("DELETE FROM DataCharacters")
    fun deleteAllRecords()

}

