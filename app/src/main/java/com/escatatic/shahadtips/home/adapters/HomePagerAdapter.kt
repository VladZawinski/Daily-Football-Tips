package com.escatatic.shahadtips.home.adapters

import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentManager
import androidx.fragment.app.FragmentStatePagerAdapter
import androidx.viewpager.widget.PagerAdapter
import androidx.viewpager.widget.ViewPager
import com.escatatic.shahadtips.domain.models.MatchDate
import com.escatatic.shahadtips.home.match.MatchFragment

class HomePagerAdapter(
    fragmentManager: FragmentManager,
    private val dates: List<MatchDate>
): FragmentStatePagerAdapter(fragmentManager,BEHAVIOR_RESUME_ONLY_CURRENT_FRAGMENT){

    override fun getCount(): Int  = dates.size

    override fun getPageTitle(position: Int): CharSequence? {
        return dates[position].modified
    }

    override fun getItem(position: Int): Fragment {
        return MatchFragment.newInstance(dates[position].original)
    }

}