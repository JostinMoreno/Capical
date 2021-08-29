package com.jostinmoreno.prototype.Adapters

import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentManager
import androidx.fragment.app.FragmentPagerAdapter

class Adapter(supportFragmentManager: FragmentManager): FragmentPagerAdapter(supportFragmentManager,
    BEHAVIOR_RESUME_ONLY_CURRENT_FRAGMENT) {
    private val FragmentList= ArrayList<Fragment>()


    override fun getCount(): Int {
        return FragmentList.size
    }

    override fun getItem(position: Int): Fragment {
        return FragmentList[position]
    }

    fun addFragment(fragment: Fragment)
    {
        FragmentList.add(fragment)
    }
}