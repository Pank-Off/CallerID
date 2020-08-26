package com.technopark.callerid.view.ui.callLog

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.LinearLayout
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.technopark.callerid.R

class PhoneAdapter(contactList: List<PhoneBook>, onItemClickListener: OnItemClickListener) :
    RecyclerView.Adapter<PhoneAdapter.ViewHolder>() {

    private var contacts: List<PhoneBook> = contactList
    private lateinit var context: Context
    private var listener: OnItemClickListener = onItemClickListener

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        context = parent.context
        val view: View = LayoutInflater.from(parent.context).inflate(
            R.layout.item_third_activity,
            parent, false
        )
        return ViewHolder(view, listener)
    }

    override fun getItemCount(): Int {
        return contacts.size
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.flagView.setImageResource(contacts[position].getIcon())
        holder.nameView.text = contacts[position].getName()
        holder.numberView.text = contacts[position].getNumber()
        holder.oneItemView.setOnClickListener { holder.listener.onClick(position) }
    }

    class ViewHolder(itemView: View, onItemClickListener: OnItemClickListener) :
        RecyclerView.ViewHolder(itemView) {
        var flagView: ImageView = itemView.findViewById(R.id.phone)
        var nameView: TextView = itemView.findViewById(R.id.name)
        var numberView: TextView = itemView.findViewById(R.id.number)
        var oneItemView: LinearLayout = itemView.findViewById(R.id.item)
        var listener: OnItemClickListener = onItemClickListener
    }
}