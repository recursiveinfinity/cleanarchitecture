package com.cleanarchitecture.presentation.products

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProviders
import com.cleanarchitecture.news_sample_app.R
import com.cleanarchitecture.presentation.navigation.AppNavigator

class ProductsFragment : Fragment() {
    private lateinit var navigator: AppNavigator

    companion object {
        const val TAG = "HomeFragment"
        fun newInstance(navigator: AppNavigator) = ProductsFragment().apply {
            this.navigator = navigator
        }
    }

    private lateinit var viewModel: ProductsViewModel

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?,
                              savedInstanceState: Bundle?): View? {
        return inflater.inflate(R.layout.product_list_fragment, container, false)
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        viewModel = ViewModelProviders.of(this).get(ProductsViewModel::class.java)
        // TODO: Use the ViewModel
    }

}
