package com.example.sqliteroomproject.model

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.LiveData

class UserModel(application: Application):
        AndroidViewModel(application){
    private val users: LiveData<List<User>> = UserDB.get(getApplication()).userDao().getAll()
    fun getUsers() = users
}