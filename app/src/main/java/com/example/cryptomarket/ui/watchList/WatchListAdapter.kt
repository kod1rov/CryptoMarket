package com.example.cryptomarket.ui.watchList

import android.annotation.SuppressLint
import android.content.Intent
import android.graphics.Color
import android.net.Uri
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.cryptomarket.R
import com.example.cryptomarket.constants.Constants
import com.example.cryptomarket.data.model.Data
import com.example.cryptomarket.databinding.ItemWatchListBinding

class WatchListAdapter : RecyclerView.Adapter<WatchListAdapter.VH>() {

    var items: MutableList<Data>? = mutableListOf()
        @SuppressLint("NotifyDataSetChanged")
        set(value) {
            field = value
            notifyDataSetChanged()
        }

    override fun getItemCount() = items!!.size

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): VH {
        return VH(
            LayoutInflater
                .from(parent.context)
                .inflate(R.layout.item_watch_list, parent, false)
        )
    }

    override fun onBindViewHolder(holder: VH, position: Int) {
        items?.get(position)?.let { holder.bind(it) }
    }

    inner class VH(itemView: View) : RecyclerView.ViewHolder(itemView) {

        private val binding = ItemWatchListBinding.bind(itemView)

        @SuppressLint("DiscouragedApi", "SetTextI18n")
        fun bind(data: Data) {
            binding.run {
                val resourceID = itemView.resources.getIdentifier(
                    data.symbol?.lowercase(),
                    "drawable", itemView.context.packageName)

                ivLogo.setImageResource(resourceID)

                tvSymbol.text = data.symbol
                tvName.text = data.name
                tvPrice.text = "$" + String.format("%.2f", data.priceUsd?.toFloat())

                if (data.changePercent24Hr!! < 0.0) {
                    tvPercentChange.text = String.format("%.2f", data.changePercent24Hr) + "%"
                    tvPercentChange.setTextColor(Color.parseColor("#f80000"))
                } else {
                    tvPercentChange.text = "+" + String.format("%.2f", data.changePercent24Hr) + "%"
                    tvPercentChange.setTextColor(Color.parseColor("#8AC135"))
                }
            }
        }
    }
}