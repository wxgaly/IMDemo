package wxgaly.android.imdemo.home.fragment

import android.os.Bundle
import android.support.v4.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import wxgaly.android.imdemo.R
import wxgaly.android.imdemo.util.Logger

/**
 *  wxgaly.android.imdemo.home.fragment.
 *
 * @author Created by WXG on 2018/11/9 009 10:34.
 * @version V1.0
 */
class MessageFragment : Fragment() {

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        Logger.i("MessageFragment", "onCreateView")
        return inflater.inflate(R.layout.frag_message, container, false)
    }

    companion object {

        fun newInstance() = MessageFragment()
    }

}