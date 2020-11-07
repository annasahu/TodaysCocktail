package com.example.todayscocktail.network

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey
import com.squareup.moshi.Json

@Entity(tableName = "cocktail_item")
data class Cocktail(
    @ColumnInfo(name = "id_drink")
    @Json(name = "idDrink")
    val id: Int,

    @ColumnInfo(name = "name_drink")
    @Json(name = "strDrink")
    val name: String,

    @ColumnInfo(name = "thumb_drink")
    @Json(name = "strDrinkThumb")
    val thumbUrl: String
)
