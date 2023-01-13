package com.example.gotproject

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "DataCharacters")
data class DataCharactersItem(
    @ColumnInfo(name = "culture")val culture: String,
    @ColumnInfo(name = "name")val name: String,
    @PrimaryKey val url: String
)