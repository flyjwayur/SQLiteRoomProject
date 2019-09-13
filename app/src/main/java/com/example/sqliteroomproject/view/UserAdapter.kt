package com.example.sqliteroomproject.view


import android.content.Intent
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.LinearLayout
import androidx.recyclerview.widget.RecyclerView
import com.example.sqliteroomproject.R
import com.example.sqliteroomproject.model.User
import kotlinx.android.synthetic.main.contact_item.view.*

const val EXTRA = "Extra"

class ContactViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView)
class UserAdapter(val users:List<User>) : RecyclerView.Adapter<ContactViewHolder>(){

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ContactViewHolder {
      return ContactViewHolder(
          LayoutInflater.from(parent.context).inflate(
              R.layout.contact_item,
              parent,
              false
          )as LinearLayout
      )
    }

    override fun getItemCount(): Int = users.size
    //Prepare a child view to display data according to the position within adapter
    override fun onBindViewHolder(holder: ContactViewHolder, position: Int) {
        val user = users[position]
        Log.d("DBG", "contact from usersContact : $user")
        holder.itemView.textViewFirstname.text = user.firstname
        holder.itemView.textViewLastname.text = user.lastname
        holder.itemView.setOnClickListener{
            val intent = Intent(holder.itemView.context, ContactDetailActivity::class.java)
            intent.putExtra(EXTRA, position)
            holder.itemView.context.startActivity(intent)
        }
    }

}