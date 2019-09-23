package com.example.sqliteroomproject.view

import com.example.sqliteroomproject.model.ContactInfo
import kotlinx.android.synthetic.main.contact_detail_item.view.*
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.LinearLayout
import androidx.recyclerview.widget.RecyclerView
import com.example.sqliteroomproject.R


class ContactAdapter : RecyclerView.Adapter<ContactAdapter.ContactViewHolder>() {
    var usersContacts: List<ContactInfo> = emptyList()
        set(value) {
            field = value
            notifyDataSetChanged()
        }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ContactViewHolder {
        return ContactViewHolder(
            LayoutInflater.from(parent.context).inflate(
                R.layout.contact_item,
                parent,
                false
            ) as LinearLayout
        )
    }


    override fun getItemCount(): Int {
        Log.d("DBG", "users: $usersContacts")
        return usersContacts.size
    }

    //Prepare a child view to display data according to the position within adapter
    override fun onBindViewHolder(holder: ContactViewHolder, position: Int) {
        var userContact = usersContacts[position]
        Log.d("DBG", "users[position]: $userContact")
        holder.containerView.textView_contactType.text = userContact.type
        holder.containerView.textView_contactValue.text = userContact.value

    }

    inner class ContactViewHolder(val containerView: View) : RecyclerView.ViewHolder(containerView)
}