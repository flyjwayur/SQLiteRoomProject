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

// 7. context is not used at all in the adapter, better remove it
class UserAdapter : RecyclerView.Adapter<ContactViewHolder>() {

    // 8. The adapter should be reusable, because it keeps information about
    // items. Re-initialise it is somehow an expensive operation. Better keep it reusable
    // by making the data changeable. In UserListFragment, I also move the adapter assignment
    // out of Observer block. I only change the list whenever there is new stuff coming from
    // LiveData
    var users: List<User> = emptyList()
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
          )as LinearLayout
      )
    }


    override fun getItemCount(): Int {
        Log.d("DBG", "users: $users")
        return users.size}
    //Prepare a child view to display data according to the position within adapter
    override fun onBindViewHolder(holder: ContactViewHolder, position: Int) {
        val user = users[position]
        Log.d("DBG", "users[position]: $user")
        Log.d("DBG", "contact from usersContact : $user")
        holder.itemView.textViewFirstname.text = user.firstname
        holder.itemView.textViewLastname.text = user.lastname
//        holder.itemView.setOnClickListener{
//            val intent = Intent(holder.itemView.context, ContactDetailActivity::class.java)
//            intent.putExtra(EXTRA, position)
//            holder.itemView.context.startActivity(intent)
//        }
    }

}
