package com.example.sqliteroomproject.view


import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import kotlinx.android.synthetic.main.fragment_user_input.*
import com.example.sqliteroomproject.R



/**
 * A simple [Fragment] subclass.
 */
class UserInputFragment : Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment

        var view = inflater.inflate(R.layout.fragment_user_input, container, false)
            val addButton = view.findViewById<Button>(R.id.button_add)


            addButton.setOnClickListener { view ->
//                1. Access the texts only when the button is clicked
//                Accessing them inside onCreateView will always return null
//                because there is no input at the beginning

                val firstName = textinput_firstname?.text.toString()
                val lastName = textinput_lastname?.text.toString()
                var mainActivity = activity as MainActivity
                mainActivity.insertUsers(firstName, lastName)
            }

        //main_activity.supportFragmentManager.popBackStack()
        return view
    }

}
