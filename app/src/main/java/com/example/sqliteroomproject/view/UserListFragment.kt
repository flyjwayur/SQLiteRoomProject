package com.example.sqliteroomproject.view


import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProviders
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.sqliteroomproject.R
import com.example.sqliteroomproject.model.UserModel
import kotlinx.android.synthetic.main.fragment_user_list.*

/**
 * A simple [Fragment] subclass.
 */
class UserListFragment : Fragment() {


    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        val ump = ViewModelProviders.of(this).get(UserModel::class.java)

        ump.getUsers().observe(this, Observer {
            var mainActivity = activity as MainActivity
            val recyclerViewUserList = view?.findViewById<RecyclerView>(R.id.recyclerView_userList)

            recyclerViewUserList?.layoutManager = LinearLayoutManager(mainActivity)
            recyclerViewUserList?.adapter = UserAdapter(it.sortedBy {
                it.lastname}, context)
        })

    }
}
