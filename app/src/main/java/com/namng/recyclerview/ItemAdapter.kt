package com.namng.recyclerview

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.CheckBox
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView

class ItemAdapter(val items: ArrayList<ItemModel>, val listener: ItemClickListener? = null): RecyclerView.Adapter<ItemAdapter.ItemViewHolder>()  {


    class ItemViewHolder(val itemView: View, val listener: ItemClickListener?): RecyclerView.ViewHolder(itemView) {
        val imageThumb: ImageView
        val name: TextView
        val subject: TextView
        val time: TextView
        val content: TextView
        val checkSelected: CheckBox
        init {
            imageThumb = itemView.findViewById(R.id.image_thumb)
            name = itemView.findViewById(R.id.name)
            subject = itemView.findViewById(R.id.subject)
            time = itemView.findViewById(R.id.time)
            content = itemView.findViewById(R.id.content)
            checkSelected = itemView.findViewById(R.id.check_selected)

            itemView.setOnClickListener {
                listener?.ItemClick(adapterPosition)
            }
        }
    }
    interface ItemClickListener {
        fun ItemClick(position: Int)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ItemViewHolder {
        val itemView = LayoutInflater.from(parent.context).inflate(R.layout.layout_item,parent,false)
        return ItemViewHolder(itemView, listener)
    }

    override fun getItemCount(): Int {
        return items.size
    }

    override fun onBindViewHolder(holder: ItemViewHolder, position: Int) {
        holder.imageThumb.setImageResource(items[position].imageThumb)
        holder.name.text = items[position].name
        holder.subject.text = items[position].subject
        holder.time.text = items[position].time
        holder.content.text = items[position].content
        holder.checkSelected.isChecked = items[position].selected
    }
}