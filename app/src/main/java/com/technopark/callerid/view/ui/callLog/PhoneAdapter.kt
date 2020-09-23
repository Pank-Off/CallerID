package com.technopark.callerid.view.ui.callLog

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.LinearLayout
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.technopark.callerid.R

class PhoneAdapter :
    RecyclerView.Adapter<PhoneAdapter.ViewHolder>() {

    private var contacts: MutableList<PhoneBook> = ArrayList()
    private var listener: OnContactClickListener? = null

    fun attachListener(onContactClickListener: OnContactClickListener?) {
        listener = onContactClickListener
    }

    fun setData(contactList: List<PhoneBook>) {
        contacts.clear()
        contacts.addAll(contactList)
        notifyDataSetChanged()
    }

    override fun getItemViewType(position: Int): Int {
        return super.getItemViewType(position)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val inflater = LayoutInflater.from(parent.context)
        val view: View = inflater.inflate(
            R.layout.item_third_activity,
            parent, false
        )
        return ViewHolder(view, listener)
    }

    override fun getItemCount(): Int {
        return contacts.size
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.bind(contacts[position])
    }

    class ViewHolder(itemView: View, onContactClickListener: OnContactClickListener?) :
        RecyclerView.ViewHolder(itemView) {
        var flagView: ImageView = itemView.findViewById(R.id.phone)
        var nameView: TextView = itemView.findViewById(R.id.name)
        var numberView: TextView = itemView.findViewById(R.id.number)
        var oneItemView: LinearLayout = itemView.findViewById(R.id.item)
        var timeView: TextView = itemView.findViewById(R.id.time)
        var listener = onContactClickListener

        fun bind(model: PhoneBook) {
            flagView.setImageResource(model.getIcon())
            nameView.text = model.getName()
            numberView.text = model.getNumber()
            timeView.text = model.getDate()[4]
            oneItemView.setOnClickListener { listener?.onClick(model) }
        }
    }
}