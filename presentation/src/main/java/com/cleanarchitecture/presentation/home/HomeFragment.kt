package com.cleanarchitecture.presentation.home

import android.app.SearchManager
import android.content.Context
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.appcompat.app.AlertDialog
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import androidx.recyclerview.widget.LinearLayoutManager
import com.cleanarchitecture.news_sample_app.R
import com.cleanarchitecture.presentation.common.ErrorViewType
import com.cleanarchitecture.presentation.common.UiError
import com.cleanarchitecture.presentation.common.extensions.inflate
import com.cleanarchitecture.presentation.navigation.AppNavigator
import kotlinx.android.synthetic.main.fragment_home.*
import org.koin.android.viewmodel.ext.android.viewModel
import java.lang.IllegalStateException

class HomeFragment : Fragment() {

    private lateinit var navigator: AppNavigator
    private val homeViewModel: HomeViewModel by viewModel()
    private val promotedItemsAdapter = PromotedItemsAdapter()

    companion object {
        const val TAG = "HomeFragment"
        fun newInstance(navigator: AppNavigator) = HomeFragment().apply {
            this.navigator = navigator
        }
    }

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?,
                              savedInstanceState: Bundle?): View? = container?.inflate(R.layout.fragment_home)

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        rvPromotedItems.layoutManager = LinearLayoutManager(context, LinearLayoutManager.HORIZONTAL, false)
        rvPromotedItems.adapter = promotedItemsAdapter
        vpHeroProducts.adapter = HeroProductsPagerAdapter(fragmentManager ?:
            throw IllegalStateException("Unexpected Error, Please retry again"))

        val searchManager = activity?.getSystemService(Context.SEARCH_SERVICE) as SearchManager
        svHomeSearch.apply{
            setSearchableInfo(searchManager.getSearchableInfo(activity?.componentName))
            setIconifiedByDefault(false)
        }
    }

    override fun onStart() {
        super.onStart()
        homeViewModel.getLoadingObservable().observe(this, Observer {
            loading(it)
        })
        homeViewModel.getContentObservable().observe(this, Observer {
            content(it)
        })
        homeViewModel.getErrorObservable().observe(this, Observer {
            error(it)
        })
        homeViewModel.getPromotedItems()
    }

    private fun loading(isLoading: Boolean) {

    }

    private fun content(result: List<UiPromotedItem>) {
        promotedItemsAdapter.updateData(result)
    }

    private fun error(error: UiError) {
        activity?.let {
            when (error.errorViewType) {
                ErrorViewType.DIALOG -> {
                    AlertDialog.Builder(it)
                            .setTitle(error.title)
                            .setMessage(error.message)
                            .setPositiveButton(error.positive) { dialog, _ ->
                                dialog.dismiss()
                                homeViewModel.getPromotedItems()
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
}