package com.cleanarchitecture.presentation.albums.Products

import android.os.Bundle
import androidx.appcompat.app.AlertDialog
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.Observer
import androidx.recyclerview.widget.GridLayoutManager
import com.cleanarchitecture.news_sample_app.R
import com.cleanarchitecture.presentation.common.ErrorViewType
import com.cleanarchitecture.presentation.common.UiError
import com.cleanarchitecture.presentation.navigation.AppNavigator
import kotlinx.android.synthetic.main.activity_albums.*
import kotlinx.android.synthetic.main.product_list_fragment.*
import org.koin.android.ext.android.inject
import org.koin.android.viewmodel.ext.android.viewModel
import org.koin.core.parameter.parametersOf


class ProductsActivity : AppCompatActivity() {

    private val productViewModel: ProductListViewModel by viewModel()
    private val navigator: AppNavigator by inject { parametersOf(this) }
    private val onItemClick: ((UiProduct?) -> Unit) = {
        it?.let { product ->
            navigator.toProducts(

            )
            overridePendingTransition(R.anim.fade_in, R.anim.fade_out)
        }
    }

    private lateinit var productAdapter: ProductsAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.product_list_fragment)
        initialiseView()
    }

    override fun onStart() {
        super.onStart()
        productViewModel.getProducts()
        productViewModel.loadingLiveData.observe(this, Observer {
            loading(it)
        })
        productViewModel.contentLiveData.observe(this, Observer {
            content(it)
        })
        productViewModel.errorLiveData.observe(this, Observer {
            error(it)
        })
    }

    private fun initialiseView() {
        productAdapter = ProductsAdapter(onItemClick)
        rvProdcts.layoutManager = GridLayoutManager(this, 2)
        rv_albums.adapter = productAdapter
    }

    private fun loading(isLoading: Boolean) {

    }

    private fun content(it: List<UiProduct>) {
        it.let { response ->
            productAdapter.updateList(response)
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
