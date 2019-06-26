package com.cleanarchitecture.presentation.products

import android.os.Bundle
import android.view.View.GONE
import android.view.View.VISIBLE
import androidx.appcompat.app.AlertDialog
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.Observer
import androidx.recyclerview.widget.GridLayoutManager
import com.cleanarchitecture.news_sample_app.R
import com.cleanarchitecture.presentation.common.ErrorViewType
import com.cleanarchitecture.presentation.common.UiError
import com.cleanarchitecture.presentation.navigation.AppNavigator
import com.cleanarchitecture.presentation.search.UiResult
import com.cleanarchitecture.presentation.search.UiSearchNavigation
import kotlinx.android.synthetic.main.fragment_products.*
import org.koin.android.ext.android.inject
import org.koin.android.viewmodel.ext.android.viewModel
import org.koin.core.parameter.parametersOf


class ProductsActivity : AppCompatActivity() {

    private val productViewModel: ProductsViewModel by viewModel()
    private val navigator: AppNavigator by inject { parametersOf(this) }
    private val onItemClick: ((UiResult?) -> Unit) = {
        it?.let { product ->
            overridePendingTransition(R.anim.fade_in, R.anim.fade_out)
        }
    }

    private lateinit var productAdapter: ProductsAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.fragment_products)
        initialiseView()
    }

    override fun onStart() {
        super.onStart()
        productViewModel.getProducts()
        productViewModel.getLoadingObservable().observe(this, Observer {
            loading(it)
        })
        productViewModel.getContentObservable().observe(this, Observer {
            content(it)
        })
        productViewModel.getErrorObservable().observe(this, Observer {
            error(it)
        })
    }

    private fun initialiseView() {
        productAdapter = ProductsAdapter(onItemClick)
        rv_products.layoutManager = GridLayoutManager(this, 2)
        rv_products.adapter = productAdapter
    }

    private fun loading(isLoading: Boolean) {
        pb_products.visibility = if (isLoading) VISIBLE else GONE
    }

    private fun content(it: UiSearchNavigation) {
        it.let { response ->
            productAdapter.updateList(response.resultsets.default.results)
        }
    }

    private fun error(error: UiError) {
        when (error.errorViewType) {
            ErrorViewType.DIALOG -> {
                AlertDialog.Builder(this)
                        .setTitle(error.title)
                        .setMessage(error.message)
                        .setPositiveButton(error.positive) { dialog, _ ->
                            dialog.dismiss()
                            productViewModel.getProducts()
                        }
                        .setCancelable(error.cancelable)
                        .show()
            }
            else -> {
                // NOOP
            }
        }
    }
}
