package com.cleanarchitecture.presentation.home

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.cleanarchitecture.news_sample_app.databinding.ItemPromotedItemBinding

class PromotedItemsAdapter : RecyclerView.Adapter<PromotedItemsAdapter.PromotedItemViewHolder>() {

    private val promotedItems = mutableListOf<UiPromotedItem>()

    fun updateData(data: List<UiPromotedItem>) {
        if (data.isNotEmpty()) {
            promotedItems.clear()
            promotedItems.addAll(data)
            notifyDataSetChanged()
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): PromotedItemViewHolder {
        val layoutInflater = LayoutInflater.from(parent.context)
        return PromotedItemViewHolder(ItemPromotedItemBinding.inflate(layoutInflater, parent, false))
    }

    override fun getItemCount() = promotedItems.size

    override fun onBindViewHolder(holder: PromotedItemViewHolder, position: Int) {
        holder.bind(promotedItems[position])
    }


    class PromotedItemViewHolder(private val itemBinding: ItemPromotedItemBinding) :
            RecyclerView.ViewHolder(itemBinding.root) {

        fun bind(promotedItem: UiPromotedItem) {
            itemBinding.promotedItem = promotedItem
            itemBinding.executePendingBindings()
        }
    }
}