package com.cleanarchitecture.presentation.products

import android.os.Bundle
import android.view.Menu
import androidx.appcompat.app.AppCompatActivity
import com.cleanarchitecture.news_sample_app.R
import com.cleanarchitecture.presentation.common.FragmentsTransactionsManager
import com.cleanarchitecture.presentation.common.extensions.applyToolbarUp
import com.cleanarchitecture.presentation.navigation.AppNavigator
import kotlinx.android.synthetic.main.activity_products.*
import org.koin.android.ext.android.inject
import org.koin.core.parameter.parametersOf


class ProductsActivity : AppCompatActivity() {

    private val navigator: AppNavigator by inject { parametersOf(this) }
    private val ftm: FragmentsTransactionsManager by inject { parametersOf(this) }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_products)
        setupActionBar()
        toProducts()
    }

    private fun toProducts() = goTo(
            fragment = ProductsFragment.newInstance(navigator),
            tag = ProductsFragment.TAG,
            titleId = R.string.product)

    private fun goTo(fragment: ProductsFragment, tag: String, titleId: Int) {
        setToolbar(titleId)
        ftm.addFragment(fragment, tag, R.id.fl_products)
    }

    private fun setToolbar(titleId: Int) {
        tv_products_title.apply {
            text = getString(titleId)
        }
    }

    override fun onCreateOptionsMenu(menu: Menu?): Boolean = true


    private fun setupActionBar() {
        setSupportActionBar(toolbar_products)
        supportActionBar?.applyToolbarUp()
    }


}
