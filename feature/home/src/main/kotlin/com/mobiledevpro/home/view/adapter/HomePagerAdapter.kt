/*
 * Copyright 2021 | Dmitri Chernysh | http://mobile-dev.pro
 *
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *     http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 *
 */
package com.mobiledevpro.home.view.adapter

import androidx.fragment.app.Fragment
import androidx.viewpager2.adapter.FragmentStateAdapter
import com.mobiledevpro.alertlog.view.AlertLogFragment
import com.mobiledevpro.watchlist.list.view.StockListFragment

/**
 * ViewPager adapter for Home screen [com.mobiledevpro.home.view.HomeFragment]
 *
 * Created on Jan 06, 2022.
 *
 */
class HomePagerAdapter(
    hostFragment: Fragment
) : FragmentStateAdapter(hostFragment) {

    override fun getItemCount(): Int = PAGE_COUNT

    override fun createFragment(position: Int): Fragment =
        when (position) {
            0 -> StockListFragment()
            1 -> AlertLogFragment()
            else -> throw RuntimeException("Fragment not found")
        }

    companion object {
        const val PAGE_COUNT = 2
    }

}