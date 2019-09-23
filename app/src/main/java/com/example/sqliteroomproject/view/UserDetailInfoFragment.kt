package com.example.sqliteroomproject.view


import android.app.Application
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.lifecycle.Observer

import com.example.sqliteroomproject.R
import com.example.sqliteroomproject.model.UserDB
import kotlinx.android.synthetic.main.fragment_user_detail_info.*

/**
 * A simple [Fragment] subclass.
 */
class UserDetailInfoFragment(val application: Application, val uid: Long) : Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_user_detail_info, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val contacts = UserDB.get(application).contactDao().getUserContacts(uid)
        contacts.observe(this, Observer {
            //e.g. using a recycler view adapter
            recyclerView.adapter = ContactAdapter()
        })
    }


}
