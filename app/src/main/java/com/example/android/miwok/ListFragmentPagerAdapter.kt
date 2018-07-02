package com.example.android.miwok

import android.support.v4.app.Fragment
import android.support.v4.app.FragmentManager
import android.support.v4.app.FragmentPagerAdapter

class ListFragmentPagerAdapter (fm : FragmentManager) : FragmentPagerAdapter(fm){

    private var TabTitles = arrayOf("Colors", "Family", "Numbers", "Phrases")

    override fun getItem(position: Int): Fragment {
        when(position){
            0 -> return ColorsFragment()
            1 -> return FamilyFragment()
            2 -> return NumbersFragment()
            else -> return PhrasesFragment()
        }
    }

    override fun getPageTitle(position: Int): CharSequence? {
        return TabTitles[position]
    }

    override fun getCount(): Int {
        return 4
    }

}