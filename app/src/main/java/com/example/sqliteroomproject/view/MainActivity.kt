package com.example.sqliteroomproject.view

import android.content.Intent
import android.os.Bundle
import com.google.android.material.snackbar.Snackbar
import androidx.appcompat.app.AppCompatActivity
import android.view.Menu
import android.view.MenuItem
import android.view.View
import com.example.sqliteroomproject.R
import com.example.sqliteroomproject.model.User
import com.example.sqliteroomproject.model.UserContact
import com.example.sqliteroomproject.model.UserDB
import kotlinx.android.synthetic.main.activity_main.*
import kotlinx.android.synthetic.main.content_main.*
import org.jetbrains.anko.doAsync
import org.jetbrains.anko.uiThread

class MainActivity : AppCompatActivity() {

    private lateinit var users:UserContact

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        setSupportActionBar(toolbar)

        val db = UserDB.get(this)
        doAsync {
            val id = db.userDao().insert(User(0, "HyeSoo", "Park" ))
            uiThread{
                TextView_user1.text = "Yes! $id"
            }
        }

        button2.setOnClickListener { view: View? ->

            val intent = Intent(this, ContactDetailActivity::class.java).apply {
                putExtra(EXTRA, "Hello")
            }

            startActivity(intent)
        }


//        recyclerView_usersList.adapter = UserAdapter()
        fab.setOnClickListener { view ->
            Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
                .setAction("Action", null).show()
        }
    }


    override fun onCreateOptionsMenu(menu: Menu): Boolean {
        // Inflate the menu; this adds items to the action bar if it is present.
        menuInflater.inflate(R.menu.menu_main, menu)
        return true
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        return when (item.itemId) {
            R.id.action_settings -> true
            else -> super.onOptionsItemSelected(item)
        }
    }
}
