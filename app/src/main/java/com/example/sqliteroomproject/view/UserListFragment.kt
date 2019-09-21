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

/**
 * A simple [Fragment] subclass.
 */
class UserListFragment : Fragment() {

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

        ump.getUsers().observe(this, Observer {
            var mainActivity = activity as MainActivity
            val recyclerViewUserList = view?.findViewById<RecyclerView>(R.id.recyclerView_userList)

            recyclerViewUserList?.layoutManager = LinearLayoutManager(mainActivity)
            recyclerViewUserList?.adapter = UserAdapter(it.sortedBy {
                it.lastname}, context)
        })

    }
}
