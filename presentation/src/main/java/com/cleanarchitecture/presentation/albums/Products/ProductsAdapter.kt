package com.cleanarchitecture.presentation.albums.Products



import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.cleanarchitecture.news_sample_app.R
import com.squareup.picasso.Picasso
import kotlinx.android.synthetic.main.list_item_album.view.*
import kotlinx.android.synthetic.main.product_list_fragment.view.*
import kotlinx.android.synthetic.main.product_list_grid_view.view.*

class ProductsAdapter(val onItemClick: (UiProduct?) -> Unit) : RecyclerView.Adapter<ProductsAdapter.ProductViewHolder>() {

    var products = mutableListOf<UiProduct>()



    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int) =
            ProductViewHolder(LayoutInflater.from(parent.context).inflate(R.layout.product_list_grid_view, parent, false))

    override fun getItemCount() = products.size

    override fun onBindViewHolder(holder: ProductViewHolder, position: Int) {
        holder.bind(products[position])
    }

    inner class ProductViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {

        fun bind(uiProduct: UiProduct) {
            with(itemView) {
                tvProductPrice.text = uiProduct.price.toString()
                tvReviewNumbers.text = uiProduct.reevoo_count.toString()
                Picasso.get().load(uiProduct.image).into(ivProduct)
                tvProductDescription.text = uiProduct.short_description
                setOnClickListener {
                    onItemClick.invoke(uiProduct)
                }
            }
        }
    }

    fun updateList(list: List<UiProduct>) {
        if (list.isNotEmpty()) {
            products.clear()
            products.addAll(list)
            notifyDataSetChanged()
        }
    }
}