package wxgaly.android.imdemo.home

import wxgaly.android.imdemo.R
import wxgaly.android.imdemo.activity.BaseActivity
import wxgaly.android.imdemo.util.obtainViewModel
import wxgaly.android.imdemo.viewmodel.ViewModelType
import wxgaly.android.imdemo.viewmodel.conversation.ConversationViewModel


/**
 *  wxgaly.android.imdemo.home.
 *
 * @author Created by WXG on 2018/11/13 23:52.
 * @version V1.0
 */
class ChatActivity : BaseActivity() {

    private val TAG = "ChatActivity"

    //    private var messageListView: MessageList? = null
//    private var messageAdapter: MsgListAdapter<ChatMessage>? = null
//    private var keyboardHeightProvider: KeyboardHeightProvider? = null

    override fun initData() {

        setContentView(R.layout.activity_chat)
//        keyboardHeightProvider = KeyboardHeightProvider(this)


//        chat_input.setOnClickEditTextListener {
//            chat_input.showMenuLayout()
//        }

//        chat_input.setMenuClickListener(object : OnMenuClickListener {
//            override fun switchToMicrophoneMode(): Boolean = true
//
//            override fun switchToEmojiMode(): Boolean = true
//
//            override fun switchToCameraMode(): Boolean = true
//
//            override fun onSendTextMessage(input: CharSequence?): Boolean {
//                input?.let {
//                    Logger.d(TAG, it.toString())
//                }
//
//                return true
//            }
//
//            override fun onSendFiles(list: MutableList<FileItem>?) {
//                TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
//            }
//
//            override fun switchToGalleryMode(): Boolean = true
//
//        })

//        chat_bg_ll.post {
//            keyboardHeightProvider?.start()
//        }

//                val singleTextMessage = JMessageClient.createSingleTextMessage("wxgaly1", JMessageClient
////                .getMyInfo().appKey,
////                "你好吗？")
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
//            var conversation: ConversationViewModel? = null
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

    override fun obtainViewModel(): ConversationViewModel = obtainViewModel(ConversationViewModel::class.java,
            ViewModelType.CONVERSATION_TYPE)

//    override fun onPause() {
//        super.onPause()
//        keyboardHeightProvider?.setKeyboardHeightObserver(null)
//    }
//
//    override fun onResume() {
//        super.onResume()
//        keyboardHeightProvider?.setKeyboardHeightObserver(this)
//    }
//
//    override fun onDestroy() {
//        super.onDestroy()
//        keyboardHeightProvider?.close()
//    }
//
//    override fun onKeyboardHeightChanged(height: Int, orientation: Int) {
//        Logger.d(TAG, "height is $height")
//        if (height > 0) {
//            keyboardHeightProvider?.close()
//        }
//    }

}