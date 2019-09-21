package com.example.sqliteroomproject.view


import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProviders
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.sqliteroomproject.R
import com.example.sqliteroomproject.model.UserModel
import kotlinx.android.synthetic.main.fragment_user_list.*

/**
 * A simple [Fragment] subclass.
 */
class UserListFragment : Fragment() {

    private val adapter = UserAdapter()

    // 3. Without specifying a layout (xml file), there is
    // no way the app can display the list :D
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_user_list, container, false)
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        val ump = ViewModelProviders.of(this).get(UserModel::class.java)

        // 4. You don't need to bind stuff in old Java way, with synthetic
        // it is done automagically. Go Kotlin.
        // 5. You don't need to pass the activity hosting this fragment to LinearLayoutManager
        // Context is enough for that
        recyclerView_userList.layoutManager = LinearLayoutManager(requireContext())

        recyclerView_userList.adapter = adapter
        ump.getUsers().observe(this, Observer {
            // 6. Don't create the linearlayout again whenever there is a change.
            // For that reason, I moved the layout manager initialisation outside of
            // this block

            adapter.users = it
        })

    }
}
