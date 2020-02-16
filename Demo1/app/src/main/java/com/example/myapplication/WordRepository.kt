package com.example.myapplication

import androidx.lifecycle.LiveData


class WordRepository(private val wordDao: WordDao) {

    val allWords: LiveData<List<Model>> = wordDao.getAlphabetizedWords()

    suspend fun insert(model: Model) {
        wordDao.insert(model)
    }

    fun isValidAccount(username: String, password: String): Boolean {
        val userAccount = wordDao.getAccount(username)
        return userAccount.Password == password
    }
}