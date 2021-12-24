package com.example.pw_task2.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.pw_task2.R
import com.example.pw_task2.model.DataModel
import kotlinx.android.synthetic.main.row_item.view.*

class ListAdapter(private var eventList: ArrayList<DataModel>) :
    RecyclerView.Adapter<ListAdapter.ViewHolder>() {
    class ViewHolder(view: View) : RecyclerView.ViewHolder(view)

    override fun onCreateViewHolder(viewGroup: ViewGroup, viewType: Int): ViewHolder {
        val view = LayoutInflater.from(viewGroup.context)
            .inflate(R.layout.row_item, viewGroup, false)
        return ViewHolder(view)
    }

    override fun onBindViewHolder(viewHolder: ViewHolder, position: Int) {
        val item = eventList[position]
        viewHolder.itemView.txtName.text = eventList[position].name
        viewHolder.itemView.checkBox.setOnCheckedChangeListener { _, isChecked ->
            if (isChecked) {
                item.isChecked = true
                eventList[position] = item
            }
        }

    }

    override fun getItemCount() = eventList.size

}
