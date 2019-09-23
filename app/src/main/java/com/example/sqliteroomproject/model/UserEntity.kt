package com.example.sqliteroomproject.model

import androidx.room.*

@Entity(tableName = "user")
data class User(
    @PrimaryKey(autoGenerate = true)
    val uid: Long?,
    val firstname: String,
    val lastname: String
){
    override fun toString(): String = "$firstname $lastname"
}




class UserContact{
    @Embedded
    var user: User? = null
    @Relation(parentColumn = "uid", entityColumn = "user")
    var contacts: List<ContactInfo>? = null
}
