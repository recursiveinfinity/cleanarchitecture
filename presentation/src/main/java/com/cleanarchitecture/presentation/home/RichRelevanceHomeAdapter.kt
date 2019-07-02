package com.cleanarchitecture.presentation.home

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.cleanarchitecture.news_sample_app.databinding.ItemPromotedItemBinding

class RichRelevanceHomeAdapter : RecyclerView.Adapter<RichRelevanceHomeAdapter.PromotedItemViewHolder>() {

    private val promotedItems = mutableListOf<UiPromotedItem>()

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int) =
            PromotedItemViewHolder(ItemPromotedItemBinding.inflate(LayoutInflater.from(parent.context), parent, false))

    override fun getItemCount() = promotedItems.size

    override fun onBindViewHolder(holder: PromotedItemViewHolder, position: Int) {
        holder.bind(promotedItems[position])
    }

    fun updateData(data: List<UiPromotedItem>) {
        if (data.isNotEmpty()) {
            promotedItems.clear()
            promotedItems.addAll(data)
            notifyDataSetChanged()
        }
    }

    class PromotedItemViewHolder(private val itemBinding: ItemPromotedItemBinding) :
            RecyclerView.ViewHolder(itemBinding.root) {

        fun bind(promotedItem: UiPromotedItem) {
            itemBinding.promotedItem = promotedItem
            itemBinding.executePendingBindings()
        }
    }
}