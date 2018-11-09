package wxgaly.android.imdemo.home.fragment

import android.os.Bundle
import android.support.v4.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup

/**
 *  wxgaly.android.imdemo.home.fragment.
 *
 * @author Created by WXG on 2018/11/9 009 17:13.
 * @version V1.0
 */
abstract class BaseFragment : Fragment() {

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        initData()
        return getView(inflater, container, savedInstanceState)
    }

    /**
     * get fragment view.
     */
    abstract fun getView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View?

    /**
     * init data.
     */
    abstract fun initData()
}