package com.example.rampupjfl.adapter

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.rampupjfl.R
import com.example.rampupjfl.model.Item

class ItemAdapter(private val context: Context, private val dataset: List<Item>) :
    RecyclerView.Adapter<ItemAdapter.ItemViewHolder>() {
    class ItemViewHolder(private val view: View) : RecyclerView.ViewHolder(view) {
        val imageView: ImageView = view.findViewById(R.id.image_view)
        val textView1: TextView = view.findViewById(R.id.text_view_1)
        val textView2: TextView = view.findViewById(R.id.text_view_2)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ItemViewHolder {
        val adapterLayout =
            LayoutInflater.from(parent.context).inflate(R.layout.list_item_card, parent, false)
        return ItemViewHolder(adapterLayout)
    }

    override fun onBindViewHolder(holder: ItemViewHolder, position: Int) {
        val item = dataset[position]
        holder.imageView.setImageResource(item.imageResource)
        holder.textView1.text = item.text1
        holder.textView2.text = item.text2
    }

    override fun getItemCount() = dataset.size
}