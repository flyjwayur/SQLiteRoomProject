package com.example.sqliteroomproject.view

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProviders
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.sqliteroomproject.R
import com.example.sqliteroomproject.model.UserModel
import kotlinx.android.synthetic.main.activity_contact_detail.*
import kotlinx.android.synthetic.main.contact_item.*
import kotlinx.android.synthetic.main.content_main.*

class ContactDetailActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_contact_detail)

        val ump = ViewModelProviders.of(this).get(UserModel::class.java)

        ump.getUsers().observe(this, Observer {
            recyclerView_usersList.layoutManager = LinearLayoutManager(this)
            recyclerView_usersList.adapter = UserAdapter(it.sortedBy {
                it.lastname})
        })
    }
}
