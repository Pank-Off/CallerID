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
    RecyclerView.Adapter<RecyclerView.ViewHolder>() {

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
        if (position == 0) {
            return 1
        }
        return if (contacts[position - 1].getDate()[0] != contacts[position].getDate()[0]) {
            1
        } else {
            2
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerView.ViewHolder {
        val inflater = LayoutInflater.from(parent.context)
        return when (viewType) {
            1 -> DateViewHolder(
                inflater.inflate(
                    R.layout.item_call_divider,
                    parent, false
                ), listener
            )
            else -> ViewHolder(
                inflater.inflate(
                    R.layout.item_third_activity,
                    parent, false
                ), listener
            )
        }
    }

    override fun getItemCount(): Int {
        return contacts.size
    }

    override fun onBindViewHolder(holder: RecyclerView.ViewHolder, position: Int) {
        when (holder) {
            is DateViewHolder -> holder.bind(contacts[position])
            is ViewHolder -> holder.bind(contacts[position])
        }
    }

    class ViewHolder(itemView: View, onContactClickListener: OnContactClickListener?) :
        RecyclerView.ViewHolder(itemView) {
        private var flagView: ImageView = itemView.findViewById(R.id.phone)
        private var nameView: TextView = itemView.findViewById(R.id.name)
        private var numberView: TextView = itemView.findViewById(R.id.number)
        private var oneItemView: LinearLayout = itemView.findViewById(R.id.item)
        private var timeView: TextView = itemView.findViewById(R.id.time)
        private var listener = onContactClickListener

        fun bind(model: PhoneBook) {
            flagView.setImageResource(model.getIcon())
            nameView.text = model.getName()
            numberView.text = model.getNumber()
            timeView.text = model.getDate()[model.getDate().size - 1]
            oneItemView.setOnClickListener { listener?.onClick(model) }
        }
    }

    class DateViewHolder(itemView: View, onContactClickListener: OnContactClickListener?) :
        RecyclerView.ViewHolder(itemView) {

        private var flagView: ImageView = itemView.findViewById(R.id.phone)
        private var nameView: TextView = itemView.findViewById(R.id.name)
        private var numberView: TextView = itemView.findViewById(R.id.number)
        private var oneItemView: LinearLayout = itemView.findViewById(R.id.item)
        private var timeView: TextView = itemView.findViewById(R.id.time)
        private var listener = onContactClickListener
        private var dayView: TextView = itemView.findViewById(R.id.dayView)


        fun bind(model: PhoneBook) {
            flagView.setImageResource(model.getIcon())
            nameView.text = model.getName()
            numberView.text = model.getNumber()
            timeView.text = model.getDate()[model.getDate().size - 1]
            oneItemView.setOnClickListener { listener?.onClick(model) }
            val currentDate =
                model.getDate()[0] + ", " + model.getDate()[2] + " " + model.getDate()[1]
            dayView.text = currentDate
        }
    }
}