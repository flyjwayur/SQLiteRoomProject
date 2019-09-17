package com.example.sqliteroomproject.view


import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.example.sqliteroomproject.R

/**
 * A simple [Fragment] subclass.
 */
class UserListFragment : Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment

        var view = inflater.inflate(R.layout.fragment_user_list, container, false)




        //main_activity.supportFragmentManager.popBackStack()
        return view
    }


}
