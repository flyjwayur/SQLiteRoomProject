package com.example.sqliteroomproject.view

import android.content.Intent
import android.os.Bundle
import com.google.android.material.snackbar.Snackbar
import androidx.appcompat.app.AppCompatActivity
import android.view.Menu
import android.view.MenuItem
import android.view.View
import androidx.fragment.app.FragmentManager
import androidx.fragment.app.FragmentTransaction
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
    private lateinit var userInputFrag: UserInputFragment
    private lateinit var userListFrag: UserListFragment
    private lateinit var fTransaction: FragmentTransaction
    private lateinit var fManager: FragmentManager

    var firstName:String? = null;
    var lastName:String? = null;

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        setSupportActionBar(toolbar)

        userInputFrag = UserInputFragment()
        userListFrag = UserListFragment()


        fManager = supportFragmentManager
        fTransaction = fManager.beginTransaction()
        fTransaction.add(R.id.frag_container, userInputFrag)
        fTransaction.add(R.id.frag_container, userListFrag)
        fTransaction.commit()


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

    fun insertUsers(firstName: String, lastName: String){
        val db = UserDB.get(this)
        doAsync {
            val id = db.userDao().insert(User(0, firstName, lastName ))
            uiThread{
                TextView_user1.text = "Yes! $id"
            }
        }
    }


    fun displayUsers(){
        val db = UserDB.get(this)
        doAsync {
            val id = db.userDao().insert(User(0, "HyeSoo", "Park" ))
            uiThread{
                TextView_user1.text = "Yes! $id"
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
