package com.cleanarchitecture.presentation.products



import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.cleanarchitecture.news_sample_app.R
import com.cleanarchitecture.presentation.search.UiResult
import com.squareup.picasso.Picasso
import kotlinx.android.synthetic.main.product_list_grid_view.view.*

class ProductsAdapter(val onItemClick: (UiResult?) -> Unit) : RecyclerView.Adapter<ProductsAdapter.ProductViewHolder>() {

    var products = mutableListOf<UiResult>()



    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int) =
            ProductViewHolder(LayoutInflater.from(parent.context).inflate(R.layout.product_list_grid_view, parent, false))

    override fun getItemCount() = products.size

    override fun onBindViewHolder(holder: ProductViewHolder, position: Int) {
        holder.bind(products[position])
    }

    inner class ProductViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {

        fun bind(result: UiResult) {
            with(itemView) {
                tvProductPrice.text = result.price.toString()
                tvReviewNumbers.text = result.reevoo_count.toString()
                Picasso.get().load(result.image).into(ivProduct)
                tvProductDescription.text = result.short_description
                setOnClickListener {
                    onItemClick.invoke(result)
                }
            }
        }
    }

    fun updateList(list: List<UiResult>) {
        if (list.isNotEmpty()) {
            products.clear()
            products.addAll(list)
            notifyDataSetChanged()
        }
    }
}