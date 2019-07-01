package com.cleanarchitecture.presentation.products


import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.cleanarchitecture.news_sample_app.R
import com.squareup.picasso.Picasso
import kotlinx.android.synthetic.main.list_item_products.view.*

class ProductsAdapter(val onItemClick: (UiProductListing?) -> Unit) : RecyclerView.Adapter<ProductsAdapter.ProductViewHolder>() {

    var products = mutableListOf<UiProductListing>()


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int) =
            ProductViewHolder(LayoutInflater.from(parent.context).inflate(R.layout.list_item_products, parent, false))

    override fun getItemCount() = products.size

    override fun onBindViewHolder(holder: ProductViewHolder, position: Int) {
        holder.bind(products[position])
    }

    inner class ProductViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {

        fun bind(productListing: UiProductListing) {
            with(itemView) {
                tvProductPrice.text = productListing.result.price
                tvProductSavePrice.text = productListing.product.wasPrice?.discountAmount
                tvReviewNumbers.text = productListing.result.reevoo_count.toString()
                Picasso.get().load(productListing.result.image).into(ivProduct)
                rtProductRating.rating = productListing.result.reevoo_score.toFloat() / 2
                tvProductDescription.text = productListing.result.short_description
                setOnClickListener {
                    onItemClick.invoke(productListing)
                }
            }
        }
    }

    fun updateList(list: List<UiProductListing>) {
        if (list.isNotEmpty()) {
            products.clear()
            products.addAll(list)
            notifyDataSetChanged()
        }
    }
}