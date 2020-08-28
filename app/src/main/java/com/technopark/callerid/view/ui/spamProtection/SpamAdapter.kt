package com.technopark.callerid.view.ui.spamProtection

import android.content.Context
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.*
import androidx.recyclerview.widget.RecyclerView
import com.technopark.callerid.R
import com.technopark.callerid.model.room.Spamer
import com.technopark.callerid.view.ui.callLog.OnItemClickListener

class SpamAdapter(
    private var spamerList: List<Spamer>,
    private var onItemClickListener: OnItemClickListener
) : RecyclerView.Adapter<SpamAdapter.ViewHolder>(), Filterable {

    private lateinit var context: Context

    class ViewHolder(itemView: View, val listener: OnItemClickListener) :
        RecyclerView.ViewHolder(itemView) {

        val flagView: ImageView = itemView.findViewById(R.id.phone)
        val nameView: TextView = itemView.findViewById(R.id.name)
        val numberView: TextView = itemView.findViewById(R.id.number)
        val oneItemView: LinearLayout = itemView.findViewById(R.id.item)
    }


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        context = parent.context
        val view = LayoutInflater.from(parent.context)
            .inflate(R.layout.item_third_activity, parent, false)
        return ViewHolder(
            view,
            onItemClickListener
        )
    }

    override fun getItemCount(): Int {
        return spamerList.size
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.flagView.setImageResource(R.drawable.bancircle)
        Log.d("Position", position.toString() + "")
        holder.nameView.text = spamerList[position].comment
        holder.numberView.text = spamerList[position].phoneNumber
        holder.oneItemView.setOnClickListener { holder.listener.onClick(position) }
    }

    override fun getFilter(): Filter {
        TODO("Not yet implemented")
    }
}