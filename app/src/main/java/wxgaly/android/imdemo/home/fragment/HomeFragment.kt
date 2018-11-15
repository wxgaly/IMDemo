package wxgaly.android.imdemo.home.fragment

import android.arch.lifecycle.AndroidViewModel
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import wxgaly.android.imdemo.R

/**
 *  wxgaly.android.imdemo.home.fragment.
 *
 * @author Created by WXG on 2018/11/9 009 10:34.
 * @version V1.0
 */
class HomeFragment : BaseFragment() {

    override fun getView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        return inflater.inflate(R.layout.frag_home, container, false)
    }

    override fun initData() {
    }

    override fun initView(view: View?) {

    }

    companion object {

        fun newInstance() = HomeFragment()
    }

    override fun obtainViewModel(): AndroidViewModel {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

}