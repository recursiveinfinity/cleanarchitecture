package com.cleanarchitecture.presentation.common

import androidx.annotation.IdRes
import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentManager

class FragmentsTransactionsManager(private val fm: FragmentManager) {

    fun replaceFragment(fragment: Fragment, tag: String, @IdRes container: Int, addToBackStack: Boolean = false, anims: Pair<Int, Int>? = null) {
        val fragmentTransition = fm.beginTransaction()
        if (anims != null) {
            fragmentTransition.setCustomAnimations(anims.first, anims.second, anims.first, anims.second)
        }

        fragmentTransition
                .replace(container, fragment, tag)

        if (addToBackStack) {
            fragmentTransition.addToBackStack(tag)
        }
        fragmentTransition.commit()
    }

    fun addFragment(fragment: Fragment, tag: String, @IdRes container: Int, addToBackStack: Boolean = false, anims: Pair<Int, Int>? = null) {
        val fragmentTransition = fm.beginTransaction()

        if (anims != null) {
            fragmentTransition.setCustomAnimations(anims.first, anims.second, anims.first, anims.second)
        }

        fragmentTransition
                .add(container, fragment, tag)

        if (addToBackStack) {
            fragmentTransition.addToBackStack(tag)
        }
        fragmentTransition.commit()
    }

    fun showFragment(fragment: Fragment) {
        fm.beginTransaction()
                .show(fragment)
                .commit()
    }




    fun hideFragment(fragment: Fragment) {
        fm.beginTransaction()
                .hide(fragment)
                .commit()
    }

    fun hideShowFragment(fragment2Show: Fragment, fragment2Hide: Collection<Fragment>, tag: String) {
        fragment2Hide.forEach {
            hideFragment(it)
        }
        if (fragment2Show.isAdded && fragment2Show.isHidden) {
            showFragment(fragment2Show)
        } else {
            addFragment(fragment2Show, tag, container = android.R.id.content)
        }
    }

    fun findFragmentById(id: Int) = fm.findFragmentById(id)
}