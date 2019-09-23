package com.example.sqliteroomproject.model

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.LiveData

class ContactInfoModel(application: Application, uid:Int):
    AndroidViewModel(application) {

    private val contacts: LiveData<List<ContactInfo>> =
        UserDB.get(getApplication()).contactDao().getAll()

    private val contactsByUser: LiveData<List<ContactInfo>> =
        UserDB.get(getApplication()).contactDao().getUserContacts(uid)


    fun getContacts() = contacts
    fun getContactsByUid() = contactsByUser
}