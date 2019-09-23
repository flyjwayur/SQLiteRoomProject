package com.example.sqliteroomproject.view

import android.content.Context
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.LinearLayout
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.FragmentManager
import androidx.fragment.app.FragmentTransaction
import androidx.recyclerview.widget.RecyclerView
import com.example.sqliteroomproject.R
import com.example.sqliteroomproject.model.User
import kotlinx.android.synthetic.main.contact_item.view.*

const val EXTRA = "Extra"


// 7. context is not used at all in the adapter, better remove it
class UserAdapter(val context: Context) : RecyclerView.Adapter<UserAdapter.UserViewHolder>() {

    // 8. The adapter should be reusable, because it keeps information about
    // items. Re-initialise it is somehow an expensive operation. Better keep it reusable
    // by making the data changeable. In UserListFragment, I also move the adapter assignment
    // out of Observer block. I only change the list whenever there is new stuff coming from
    // LiveData

    lateinit var fragDetailInfo: UserDetailInfoFragment
    lateinit var fTransaction: FragmentTransaction
    lateinit var fManager: FragmentManager

    var users: List<User> = emptyList()
        set(value) {
            field = value
            notifyDataSetChanged()
        }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): UserViewHolder {
      return UserViewHolder(
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
    override fun onBindViewHolder(holder: UserViewHolder, position: Int) {
        val user = users[position]
        Log.d("DBG", "users[position]: $user")
        Log.d("DBG", "contact from usersContact : $user")
        holder.containerView.textViewFirstname.text = user.firstname
        holder.containerView.textViewLastname.text = user.lastname

        holder.itemView.setOnClickListener {
            // fire recyclerView click event
            if(user.uid != null){
                showContactInfo(user.uid)
            }
            Log.d("OnClickListener", "item clicked")
        }

//        holder.itemView.setOnClickListener{
//            val intent = Intent(holder.itemView.context, ContactDetailActivity::class.java)
//            intent.putExtra(EXTRA, position)
//            holder.itemView.context.startActivity(intent)
//        }

    }

    private fun showContactInfo(uid:Long) {
        fManager = (context as AppCompatActivity).supportFragmentManager
        fragDetailInfo = UserDetailInfoFragment(this.context.application, uid)
        fTransaction = fManager.beginTransaction()
        fTransaction.replace(R.id.frag_container2, fragDetailInfo)
        fTransaction.addToBackStack(null)
        fTransaction.commit()
    }

    inner class UserViewHolder(val containerView: View) : RecyclerView.ViewHolder(containerView)
}
