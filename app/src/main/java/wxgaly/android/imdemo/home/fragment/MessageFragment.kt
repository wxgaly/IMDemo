package wxgaly.android.imdemo.home.fragment

import android.content.Intent
import android.databinding.DataBindingUtil
import android.os.Bundle
import android.support.v7.widget.LinearLayoutManager
import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import wxgaly.android.imdemo.R
import wxgaly.android.imdemo.databinding.FragMessageBinding
import wxgaly.android.imdemo.entity.chat.ChatMessageWrapper
import wxgaly.android.imdemo.home.ChatActivity
import wxgaly.android.imdemo.home.adapter.MessageListAdapter
import wxgaly.android.imdemo.util.obtainViewModel
import wxgaly.android.imdemo.viewmodel.ViewModelType
import wxgaly.android.imdemo.viewmodel.conversation.ConversationViewModel

/**
 *  wxgaly.android.imdemo.home.fragment.
 *
 * @author Created by WXG on 2018/11/9 009 10:34.
 * @version V1.0
 */
class MessageFragment : BaseFragment() {

    private val TAG = "MessageFragment"

    private var chatMessageWrapperListView: RecyclerView? = null
    private lateinit var viewDataBinding: FragMessageBinding
    private val chatMessageWrappers = arrayListOf<ChatMessageWrapper>()

    override fun getView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        viewDataBinding = DataBindingUtil.inflate(inflater, R.layout.frag_message, container, false)
        return viewDataBinding.root
    }

    override fun initData() {
        viewDataBinding.viewModel = obtainViewModel()

        val allConversation = viewDataBinding.viewModel?.getAllConversation()
        allConversation?.forEach {
            chatMessageWrappers.add(ChatMessageWrapper("", it.title, it.latestText, it.lastMsgDate))
        }
//        viewDataBinding.viewModel?.sendSimpleTextMessage("wxgaly1", "你好吗",
//                object : IConversation.OnMessageCompleteListener {
//                    override fun gotResult(code: Int, msg: String?) {
//                        Logger.d(TAG, "code is $code, msg is $msg")
//                    }
//                })
    }

    override fun initView(view: View?) {

        view?.apply {
            chatMessageWrapperListView = findViewById(R.id.chat_message_list)

            val adapter = MessageListAdapter(R.layout.message_item, chatMessageWrappers)

            chatMessageWrapperListView?.let {

                adapter.openLoadAnimation()

                it.layoutManager = LinearLayoutManager(context)
                it.adapter = adapter

            }

            adapter.setOnItemClickListener { adapter, view, position ->
                startChatActivity(position)
            }

        }
    }

    private fun startChatActivity(position: Int) {
        startActivity(Intent(activity, ChatActivity::class.java))
    }

    override fun obtainViewModel(): ConversationViewModel = obtainViewModel(ConversationViewModel::class.java, ViewModelType.CONVERSATION_TYPE)

    companion object {
        fun newInstance() = MessageFragment()
    }

}