package com.example.cryptomarket.ui.watchList

import android.annotation.SuppressLint
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.core.content.ContextCompat
import androidx.recyclerview.widget.RecyclerView
import com.example.cryptomarket.R
import com.example.cryptomarket.data.model.Data
import com.example.cryptomarket.databinding.ItemWatchListBinding

class WatchListAdapter : RecyclerView.Adapter<WatchListAdapter.VH>() {

    private val items: ArrayList<Data> = arrayListOf()

    @SuppressLint("NotifyDataSetChanged")
    fun submitData(list: List<Data>) {
        items.clear()
        items.addAll(list)
        notifyDataSetChanged()
    }

    override fun getItemCount() = items.size

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): VH {
        return VH(
            LayoutInflater
                .from(parent.context)
                .inflate(R.layout.item_watch_list, parent, false)
        )
    }

    override fun onBindViewHolder(holder: VH, position: Int) {
        holder.bind(items[position])
    }

    class VH(itemView: View) : RecyclerView.ViewHolder(itemView) {

        private val binding = ItemWatchListBinding.bind(itemView)

        fun bind(data: Data) = with(binding) {
            val context = root.context
            data.image?.let {
                ivLogo.setImageDrawable(ContextCompat.getDrawable(context, it))
            }
            tvSymbol.text = data.symbol
            tvName.text = data.name
            tvPrice.text = data.priceUsdText
            tvPercentChange.text = data.changeText
            tvPercentChange.setTextColor(context.getColor(data.color))
        }
    }
}