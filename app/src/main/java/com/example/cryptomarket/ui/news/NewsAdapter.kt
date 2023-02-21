package com.example.cryptomarket.ui.news

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.core.view.isVisible
import androidx.recyclerview.widget.RecyclerView
import com.example.cryptomarket.R
import com.example.cryptomarket.data.model.News
import com.example.cryptomarket.databinding.ItemNewsBinding

class NewsAdapter(private val news: List<News>, private val onClick: (bet: News) -> Unit) : RecyclerView.Adapter<NewsAdapter.VH>() {

    override fun getItemCount() = news.size

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): VH {
        return VH(
            LayoutInflater
                .from(parent.context)
                .inflate(R.layout.item_news, parent, false), onClick
        )
    }

    override fun onBindViewHolder(holder: VH, position: Int) {
        news[position].let { holder.bind(it, position) }
    }

    inner class VH(itemView: View, private val onClick: (News) -> Unit) :
        RecyclerView.ViewHolder(itemView) {

        private val binding = ItemNewsBinding.bind(itemView)

        fun bind(data: News, position: Int) {
            binding.run {

                newsPicture.setBackgroundResource(data.newsPicture)
                newsTitle.text = data.newsTitle
                newsSmallDescription.text = data.newsDescription

                if (position == news.size-1){
                    itemDivider.isVisible = false
                }
            }

            itemView.setOnClickListener {
                onClick(data)
            }
        }
    }
}