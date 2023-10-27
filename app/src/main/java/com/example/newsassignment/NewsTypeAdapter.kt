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
import com.example.newsassignment.models.NewstypeModel

class NewsTypeAdapter(private var context: Context, var listener: clicked) :
    RecyclerView.Adapter<NewsTypeAdapter.mviewHolderClass>() {
    var newstype= ArrayList<NewstypeModel>()

    class mviewHolderClass(itemView: View) : RecyclerView.ViewHolder(itemView) {

        var newsType: TextView = itemView.findViewById(R.id.newsType)

    }

    fun updateItems(newList: ArrayList<NewstypeModel>) {
        newstype.clear()
        newstype.addAll(newList)
        notifyDataSetChanged()
    }

    override fun onCreateViewHolder(
        parent: ViewGroup,
        viewType: Int
    ): NewsTypeAdapter.mviewHolderClass {
        var view = mviewHolderClass(
            LayoutInflater.from(context).inflate(R.layout.news_item_type, parent, false))

        view.newsType.setOnClickListener {
            listener.onItemClick(newstype[view.adapterPosition],view.adapterPosition)
        }
                    return view
    }

    override fun onBindViewHolder(holder: NewsTypeAdapter.mviewHolderClass, position: Int) {
        val currentItem = newstype[position]
        holder.newsType.text  = currentItem.type


    }

    override fun getItemCount(): Int {
        return newstype.size
    }

    interface clicked {
        fun onItemClick(model: NewstypeModel, position: Int)
    }

}