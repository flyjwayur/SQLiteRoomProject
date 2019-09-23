package com.example.sqliteroomproject.model

import androidx.lifecycle.LiveData
import androidx.room.*


@Dao
interface UserDao{
    @Query("SELECT * FROM user")
    fun getAll(): LiveData<List<User>>

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun insert(user: User): Long

    @Update
    fun update(user: User)

    @Query("SELECT * FROM user WHERE user.uid = :userid")
    fun getUserContacts(userid: Long): UserContact
}


