package com.cleanarchitecture.presentation.products

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
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

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?,
                              savedInstanceState: Bundle?): View? {
        return inflater.inflate(R.layout.fragment_products, container, false)
    }

}
