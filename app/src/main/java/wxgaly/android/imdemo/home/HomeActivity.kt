package wxgaly.android.imdemo.home

import android.os.Bundle
import android.support.v4.view.PagerAdapter
import android.support.v7.app.AppCompatActivity
import android.view.LayoutInflater
import android.view.View
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


        vp.adapter = object : PagerAdapter() {
            override fun isViewFromObject(p0: View, p1: Any): Boolean = p0 == p1

            override fun getCount(): Int {
                TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
            }

        }
    }

}