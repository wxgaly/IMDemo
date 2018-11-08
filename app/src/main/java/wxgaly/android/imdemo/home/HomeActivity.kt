package wxgaly.android.imdemo.home

import android.graphics.Color
import android.os.Bundle
import android.support.v4.view.PagerAdapter
import android.support.v7.app.AppCompatActivity
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import devlight.io.library.ntb.NavigationTabBar
import kotlinx.android.synthetic.main.activity_home.*
import wxgaly.android.imdemo.R

/**
 *  wxgaly.android.imdemo.home.
 *
 * @author Created by WXG on 2017/11/17 017 20:43.
 * @version V1.0
 */
class HomeActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_home)
        initView()

    }

    private fun initView() {
        val views = arrayListOf<View>()
        val layoutInflater = LayoutInflater.from(this)
        views.add(layoutInflater.inflate(R.layout.frag_message, null, false))
        views.add(layoutInflater.inflate(R.layout.frag_contacts, null, false))
        views.add(layoutInflater.inflate(R.layout.frag_home, null, false))

        vp.adapter = object : PagerAdapter() {
            override fun isViewFromObject(p0: View, p1: Any): Boolean = p0 == p1

            override fun getCount(): Int = views.size

            override fun destroyItem(container: ViewGroup, position: Int, `object`: Any) {
                container.removeView(`object` as View)
            }

            override fun instantiateItem(container: ViewGroup, position: Int): Any {

                val view = views[position]
                container.addView(view)
                return view
            }
        }

        val colors = resources.getStringArray(R.array.default_preview)

        val models = arrayListOf<NavigationTabBar.Model>()

        models.add(NavigationTabBar.Model.Builder(resources.getDrawable(R.drawable
                .ic_frag_message), Color.parseColor(colors[0]))
                .title(resources.getString(R.string.frag_message))
                .build())

        models.add(NavigationTabBar.Model.Builder(resources.getDrawable(R.drawable
                .ic_frag_contacts), Color.parseColor(colors[1]))
                .title(resources.getString(R.string.frag_contacts))
                .build())

        models.add(NavigationTabBar.Model.Builder(resources.getDrawable(R.drawable
                .ic_frag_home), Color.parseColor(colors[2]))
                .title(resources.getString(R.string.frag_home))
                .build())

        ntb.models = models
        ntb.setViewPager(vp, 0)
        models[0].toggleBadge()
        models[0].badgeTitle = "1"
    }

}