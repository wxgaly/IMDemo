package wxgaly.android.imdemo.home.fragment

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import cn.jiguang.imui.commons.models.IMessage
import cn.jiguang.imui.messages.MessageList
import cn.jiguang.imui.messages.MsgListAdapter
import cn.jpush.im.android.api.JMessageClient
import cn.jpush.im.android.api.model.Conversation
import wxgaly.android.imdemo.R
import wxgaly.android.imdemo.entity.chat.ChatMessage
import wxgaly.android.imdemo.entity.chat.ChatUser
import wxgaly.android.imdemo.util.Logger

/**
 *  wxgaly.android.imdemo.home.fragment.
 *
 * @author Created by WXG on 2018/11/9 009 10:34.
 * @version V1.0
 */
class MessageFragment : BaseFragment() {

    private val TAG = "MessageFragment"
    private var messageListView: MessageList? = null
    private var messageAdapter: MsgListAdapter<ChatMessage>? = null

    override fun getView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        return inflater.inflate(R.layout.frag_message, container, false)
    }

    override fun initData() {
//        val singleTextMessage = JMessageClient.createSingleTextMessage("wxgaly1", JMessageClient
//                .getMyInfo().appKey,
//                "你好吗？")
//        singleTextMessage.setOnSendCompleteCallback(object : BasicCallback() {
//            override fun gotResult(code: Int, msg: String?) {
//                Logger.d(TAG, "消息发送 ：code is $code, msg is $msg")
//            }
//        })
//
//        JMessageClient.sendMessage(singleTextMessage)

    }

    override fun initView(view: View?) {
        view?.apply {
            messageListView = findViewById(R.id.msg_list)

            var id: String? = null
            var conversation: Conversation? = null
            val messages = arrayListOf<ChatMessage>()

            JMessageClient.getConversationList()?.forEach {
                conversation = it
            }

            id = conversation?.title

            messageAdapter = MsgListAdapter(id, null)

            messageListView?.setAdapter(messageAdapter)
            messageListView?.setShowSenderDisplayName(true)
            messageListView?.setShowReceiverDisplayName(true)

            conversation?.allMessage?.forEach { message ->
                Logger.d(TAG, "${conversation?.title} : ${message.content.toJson()}")
                val chatMessage = ChatMessage(message.content.toJson(), IMessage.MessageType
                        .RECEIVE_TEXT.ordinal)
                chatMessage.setUserInfo(ChatUser(id, id, null))
                messages.add(chatMessage)
            }

            val chatMessage = ChatMessage("哈哈", IMessage.MessageType.SEND_TEXT.ordinal)
            chatMessage.setUserInfo(ChatUser("wxgaly", "wxgaly", null))
            messages.add(chatMessage)

            messageAdapter?.apply {
                addToEndChronologically(messages)
            }
        }
    }


    companion object {
        fun newInstance() = MessageFragment()
    }

}