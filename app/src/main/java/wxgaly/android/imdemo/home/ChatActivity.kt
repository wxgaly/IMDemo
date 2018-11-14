package wxgaly.android.imdemo.home

import wxgaly.android.imdemo.BaseActivity

/**
 *  wxgaly.android.imdemo.home.
 *
 * @author Created by WXG on 2018/11/13 23:52.
 * @version V1.0
 */
class ChatActivity : BaseActivity() {

    //    private var messageListView: MessageList? = null
//    private var messageAdapter: MsgListAdapter<ChatMessage>? = null

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

        //        view?.apply {
//            messageListView = findViewById(R.id.msg_list)
//
//            var id: String? = null
//            var conversation: Conversation? = null
//            val messages = arrayListOf<ChatMessage>()
//
//            JMessageClient.getConversationList()?.forEach {
//                conversation = it
//            }
//
//            id = conversation?.title
//
//            messageAdapter = MsgListAdapter(id, null)
//
//            messageListView?.setAdapter(messageAdapter)
//            messageListView?.setShowSenderDisplayName(true)
//            messageListView?.setShowReceiverDisplayName(true)
//
//            conversation?.allMessage?.forEach { message ->
//                Logger.d(TAG, "${conversation?.title} : ${message.content.toJson()}")
//                val chatMessage = ChatMessage(message.content.toJson(), IMessage.MessageType
//                        .RECEIVE_TEXT.ordinal)
//                chatMessage.setUserInfo(ChatUser(id, id, null))
//                messages.add(chatMessage)
//            }
//
//            val chatMessage = ChatMessage("哈哈", IMessage.MessageType.SEND_TEXT.ordinal)
//            chatMessage.setUserInfo(ChatUser("wxgaly", "wxgaly", null))
//            messages.add(chatMessage)
//
//            messageAdapter?.apply {
//                addToEndChronologically(messages)
//            }
//        }
    }
}