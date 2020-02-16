package com.example.myapplication

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "model_table")
data class Model(@PrimaryKey @ColumnInfo(name = "username") val Username:String,
                 @ColumnInfo(name = "password") val Password: String,
                 @ColumnInfo(name = "email") val Email: String,
                 @ColumnInfo (name = "address") val Address: String,
                 @ColumnInfo (name = "gioitinh") val Giơitinh: String)
