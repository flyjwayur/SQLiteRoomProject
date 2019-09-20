package com.example.sqliteroomproject.view

import android.content.Intent
import android.os.Bundle
import android.util.Log
import com.google.android.material.snackbar.Snackbar
import androidx.appcompat.app.AppCompatActivity
import android.view.Menu
import android.view.MenuItem
import android.view.View
import androidx.fragment.app.FragmentManager
import androidx.fragment.app.FragmentTransaction
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.sqliteroomproject.R
import com.example.sqliteroomproject.model.User
import com.example.sqliteroomproject.model.UserContact
import com.example.sqliteroomproject.model.UserDB
import kotlinx.android.synthetic.main.activity_main.*
import kotlinx.android.synthetic.main.content_main.*
import kotlinx.android.synthetic.main.fragment_user_list.*
import org.jetbrains.anko.doAsync
import org.jetbrains.anko.uiThread

class MainActivity : AppCompatActivity() {

//    private lateinit var users:User
    private lateinit var userInputFrag: UserInputFragment
    private lateinit var userListFrag: UserListFragment
    private lateinit var fTransaction: FragmentTransaction
    private lateinit var fManager: FragmentManager
//
//    var firstName:String? = null;
//    var lastName:String? = null;

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        setSupportActionBar(toolbar)

        userInputFrag = UserInputFragment()
        userListFrag = UserListFragment()


        fManager = supportFragmentManager
        fTransaction = fManager.beginTransaction()
        fTransaction.add(R.id.frag_container1, userInputFrag)
        fTransaction.commit()

        fTransaction.add(R.id.frag_container2, userListFrag)
        fTransaction.commit()

//        recyclerView_usersList.adapter = UserAdapter()

    }

    fun insertUsers(firstName: String, lastName: String){
        val db = UserDB.get(this)
        Log.d("DBG", "Name : $firstName, $lastName")
        doAsync {
             val id = db.userDao().insert(User(null, firstName, lastName ))
            uiThread {

            }
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
