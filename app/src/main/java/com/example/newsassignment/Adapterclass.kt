package com.example.newsassignment

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.cardview.widget.CardView
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.newsassignment.models.Article

class Adapterclass(private var context: Context, var listener: clicked) :
    RecyclerView.Adapter<Adapterclass.mviewHolderClass>() {
    var newsItems = ArrayList<Article>()

    class mviewHolderClass(itemView: View) : RecyclerView.ViewHolder(itemView) {

        var imageView: ImageView = itemView.findViewById(R.id.imageview)
        var title: TextView = itemView.findViewById(R.id.title)
        var description: TextView = itemView.findViewById(R.id.description)
        var author: TextView = itemView.findViewById(R.id.author)
        var url: TextView = itemView.findViewById(R.id.url)
        var publishedAt: TextView = itemView.findViewById(R.id.publishedAt)
        var cardView:CardView = itemView.findViewById(R.id.cardView)
    }

    fun updateItems(newList: ArrayList<Article>) {
        newsItems.clear()
        newsItems.addAll(newList)
        notifyDataSetChanged()
    }

    override fun onCreateViewHolder(
        parent: ViewGroup,
        viewType: Int
    ): Adapterclass.mviewHolderClass {
        var view = mviewHolderClass(
            LayoutInflater.from(context).inflate(R.layout.itemview, parent, false))

        view.cardView.setOnClickListener {
            listener.onItemClick(newsItems[view.adapterPosition],view.adapterPosition)
        }
                    return view
    }

    override fun onBindViewHolder(holder: Adapterclass.mviewHolderClass, position: Int) {
        val currentItem = newsItems[position]
        Glide.with(holder.imageView).load(currentItem.urlToImage).into(holder.imageView)
        holder.title.text = currentItem.title
        holder.author.text = currentItem.author
        holder.url.text = currentItem.url
        holder.description.text = currentItem.description
        holder.publishedAt.text = currentItem.publishedAt

    }

    override fun getItemCount(): Int {
        return newsItems.size
    }

    interface clicked {
        fun onItemClick(model: Article, position: Int)
    }

}