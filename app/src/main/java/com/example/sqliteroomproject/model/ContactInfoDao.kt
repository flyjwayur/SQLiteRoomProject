package com.example.sqliteroomproject.model

import androidx.lifecycle.LiveData
import androidx.room.*

@Dao
interface ContactInfoDao {
    @Query("SELECT * FROM contactinfo")
    fun getAll(): LiveData<List<ContactInfo>>

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun insert(contactInfo: ContactInfo): Long

    @Update
    fun update(contactInfo: ContactInfo)

    @Query("SELECT * FROM contactinfo WHERE contactinfo.user = :userid")
    fun getUserContacts(userid: Long): LiveData<List<ContactInfo>>

    @Query("SELECT * FROM contactinfo WHERE contactinfo.type = :type AND contactinfo.user = :userid")
    fun getUserContact(userid: Long, type: String): ContactInfo
}