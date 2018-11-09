package wxgaly.android.imdemo.home.adapter

import android.support.v4.app.Fragment
import android.support.v4.app.FragmentManager
import android.support.v4.app.FragmentPagerAdapter

/**
 *  wxgaly.android.imdemo.home.adapter.
 *
 * @author Created by WXG on 2018/11/9 009 11:27.
 * @version V1.0
 */
class HomeFragmentAdapter(fragmentManager: FragmentManager, list: ArrayList<Fragment>) : FragmentPagerAdapter(fragmentManager) {

    private var mList = list

    override fun getItem(position: Int): Fragment = mList[position]

    override fun getCount(): Int = mList.size

}