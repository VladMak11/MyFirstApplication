package com.example.myfirstapplication

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView

import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView

class OrgListAdapter : ListAdapter<User, OrgListAdapter.UserViewHolder>(DiffCallback()){
    class UserViewHolder(val itemView: View) : RecyclerView.ViewHolder(itemView){
        fun bind (item : User){
            val username = itemView.findViewById<TextView>(R.id.user_name)
            val userlastname = itemView.findViewById<TextView>(R.id.lastname)
            val usersurname = itemView.findViewById<TextView>(R.id.user_surname)
            val phone= itemView.findViewById<TextView>(R.id.phone)
            val email= itemView.findViewById<TextView>(R.id.email)

            username.text = item.Name
            userlastname.text = item.LastName
            usersurname.text = item.Surname
            phone.text = item.Phone
            email.text = item.Email
        }
    }
    private class DiffCallback : DiffUtil.ItemCallback<User>() {
        ///===
        override fun areItemsTheSame(oldItem: User, newItem: User) = oldItem === newItem
        override fun areContentsTheSame(oldItem: User, newItem: User) = oldItem == newItem
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): UserViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.list_item, parent,false)
        return UserViewHolder(view)
    }

    override fun onBindViewHolder(holder: UserViewHolder, position: Int) {
        holder.bind(getItem(position))
    }
}