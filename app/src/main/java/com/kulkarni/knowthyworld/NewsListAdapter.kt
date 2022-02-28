package com.kulkarni.knowthyworld

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView

class NewsListAdapter( private val listener: NewsItemClicked):RecyclerView.Adapter<NewsviewHolder>() {
    private val items: ArrayList<News> = ArrayList()
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): NewsviewHolder {
        val view=LayoutInflater.from(parent.context).inflate(R.layout.itemnews,parent,false)
        val viewHolder= NewsviewHolder(view)
        view.setOnClickListener{
            listener.onItemClicked(items[viewHolder.adapterPosition])
        }

        return viewHolder
    }

    override fun onBindViewHolder(holder: NewsviewHolder, position: Int) {
        val currentItem=items[position]
        holder.titleView.text= currentItem.title
    }

    override fun getItemCount(): Int {
        return items.size
    }

    fun updateNews(updatedNews:ArrayList<News>){
        items.clear()
        items.addAll(updatedNews)

        notifyDataSetChanged()
    }
}

class NewsviewHolder(itemView: View) : RecyclerView.ViewHolder(itemView){
    val titleView: TextView=itemView.findViewById(R.id.title)
}

interface NewsItemClicked{
    fun onItemClicked(item: News)
}