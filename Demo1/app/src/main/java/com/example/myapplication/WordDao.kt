package com.example.myapplication

import androidx.lifecycle.LiveData
import androidx.room.*

@Dao
interface WordDao {

    @Query("SELECT * from model_table")
    fun getAlphabetizedWords(): LiveData<List<Model>>

    @Insert(onConflict = OnConflictStrategy.IGNORE)
    suspend fun insert(model: Model)

    @Query("DELETE FROM model_table")
    fun deleteAll()

    @Query("SELECT * FROM model_table WHERE model_table.username LIKE :username")
    fun getAccount(username: String): Model
}