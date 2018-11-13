package wxgaly.android.imdemo.home.fragment

import android.os.Bundle
import android.support.v7.widget.LinearLayoutManager
import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import wxgaly.android.imdemo.R
import wxgaly.android.imdemo.entity.chat.ChatMessageWrapper
import wxgaly.android.imdemo.home.adapter.MessageListAdapter
import wxgaly.android.imdemo.util.Logger

/**
 *  wxgaly.android.imdemo.home.fragment.
 *
 * @author Created by WXG on 2018/11/9 009 10:34.
 * @version V1.0
 */
class MessageFragment : BaseFragment() {

    private val TAG = "MessageFragment"

    private var chatMessageWrapperListView: RecyclerView? = null

    override fun getView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        return inflater.inflate(R.layout.frag_message, container, false)
    }

    override fun initData() {


    }

    override fun initView(view: View?) {
        val chatMessageWrappers = arrayListOf(
                ChatMessageWrapper("", "汪旭光", "你好", 12345678L),
                ChatMessageWrapper("", "汪旭光1", "你好吗？", 3454353465L),
                ChatMessageWrapper("", "汪旭光2", "你好啊！", 6756967987L))

        view?.apply {
            chatMessageWrapperListView = findViewById(R.id.chat_message_list)

            val adapter = MessageListAdapter(R.layout.message_item, chatMessageWrappers)

            chatMessageWrapperListView?.let {

                adapter.openLoadAnimation()

                it.layoutManager = LinearLayoutManager(context)
                it.adapter = adapter

            }

            adapter.setOnItemClickListener { adapter, view, position ->
                Logger.d(TAG, "$position")
            }

        }
    }


    companion object {
        fun newInstance() = MessageFragment()
    }

}