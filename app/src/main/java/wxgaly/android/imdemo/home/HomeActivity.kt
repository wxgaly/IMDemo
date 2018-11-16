package wxgaly.android.imdemo.home

import android.graphics.Color
import android.os.Bundle
import android.support.v4.app.Fragment
import android.support.v4.content.res.ResourcesCompat
import android.support.v7.app.AppCompatActivity
import devlight.io.library.ntb.NavigationTabBar
import kotlinx.android.synthetic.main.activity_home.*
import kotlinx.android.synthetic.main.app_bar_main.*
import wxgaly.android.imdemo.R
import wxgaly.android.imdemo.home.adapter.HomeFragmentAdapter
import wxgaly.android.imdemo.home.fragment.ContactsFragment
import wxgaly.android.imdemo.home.fragment.HomeFragment
import wxgaly.android.imdemo.home.fragment.MessageFragment

/**
 *  wxgaly.android.imdemo.home.
 *
 * @author Created by WXG on 2017/11/17 017 20:43.
 * @version V1.0
 */
class HomeActivity : AppCompatActivity() {

    private val TAG = "HomeActivity"
    private var mFragments = ArrayList<Fragment>()
    private lateinit var homeFragmentAdapter: HomeFragmentAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_home)
        initView()

    }

    private fun initView() {
        initToolBar()

        initFragment()

        initViewPager()

        initNavigation()
    }

    private fun initToolBar() {
        setSupportActionBar(toolbar)
        toolbar.title = getString(R.string.app_name)
    }

    private fun initFragment() {
        mFragments.add(MessageFragment.newInstance())
        mFragments.add(ContactsFragment.newInstance())
        mFragments.add(HomeFragment.newInstance())

        homeFragmentAdapter = HomeFragmentAdapter(supportFragmentManager, mFragments)
    }

    private fun initViewPager() {
        vp.offscreenPageLimit = mFragments.size
        vp.adapter = homeFragmentAdapter
    }

    private fun initNavigation() {
        val colors = resources.getStringArray(R.array.default_preview)

        val models = arrayListOf<NavigationTabBar.Model>()

        models.add(NavigationTabBar.Model.Builder(ResourcesCompat.getDrawable(resources, R.drawable
                .ic_frag_message, null), Color.parseColor(colors[0]))
                .title(resources.getString(R.string.frag_message))
                .build())

        models.add(NavigationTabBar.Model.Builder(ResourcesCompat.getDrawable(resources, R.drawable
                .ic_frag_contacts, null), Color.parseColor(colors[1]))
                .title(resources.getString(R.string.frag_contacts))
                .build())

        models.add(NavigationTabBar.Model.Builder(ResourcesCompat.getDrawable(resources, R.drawable
                .ic_frag_home, null), Color.parseColor(colors[2]))
                .title(resources.getString(R.string.frag_home))
                .build())

        ntb.models = models
        ntb.setViewPager(vp, 0)
    }

}