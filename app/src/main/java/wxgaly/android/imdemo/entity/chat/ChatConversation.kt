package wxgaly.android.imdemo.entity.chat

import java.io.File

/**
 *  wxgaly.android.imdemo.entity.chat.
 *
 * @author Created by WXG on 2018/11/14 014 16:55.
 * @version V1.0
 */
class ChatConversation {

    var id: String? = null
    var targetId: String? = null
    var targetInfo: Any? = null
    var title: String? = null
    var unReadMsgCnt = 0
    var avatar: File? = null
    var messages: List<Message>? = null
    var latestMessage: Message? = null
    var latestText: String? = null
    var latestType: ContentType? = null
    var lastMsgDate: Long? = null
    var extra: String? = null

    /**
     * 聊天会话类型
     */
    enum class ChatConversationType {
        SINGLE, GROUP, CHAT_ROOM
    }

    data class Message(val id: Int,
                       val messageType: MessageType,
                       val messageStatus: MessageStatus,
                       val messageContent: MessageContent,
                       val createTimeInMillis: Long)

    enum class MessageType {
        SEND, RECEIVE
    }

    enum class MessageStatus {
        CREATED,
        SEND_SUCCESS,
        SEND_FAIL,
        SEND_GOING,
        SEND_DRAFT,
        RECEIVE_SUCCESS,
        RECEIVE_GOING,
        RECEIVE_FAIL
    }

    data class MessageContent(val contentType: ContentType,
                              val content: String)

    enum class ContentType {
        TEXT,
        IMAGE,
        VOICE,
        LOCATION,
        VIDEO,
        EVENT_NOTIFICATION,
        CUSTOM,
        UNKNOWN,
        FILE,
        PROMPT
    }

}