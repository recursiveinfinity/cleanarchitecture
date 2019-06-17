package com.cleanarchitecture.presentation.home

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.cleanarchitecture.news_sample_app.R
import com.cleanarchitecture.presentation.common.extensions.inflate
import com.cleanarchitecture.presentation.navigation.AppNavigator
import kotlinx.android.synthetic.main.fragment_home.*

class HomeFragment : Fragment() {

    private lateinit var navigator: AppNavigator

    companion object {
        const val TAG = "HomeFragment"
        fun newInstance(navigator: AppNavigator) = HomeFragment().apply {
            this.navigator = navigator
        }
    }

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? = container?.inflate(R.layout.fragment_home)

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        bt_home_albums.setOnClickListener { navigator.toAlbums() }
    }
}