package wxgaly.android.imdemo.viewmodel.conversation

import cn.jpush.im.android.api.JMessageClient
import cn.jpush.im.android.api.content.MessageContent
import cn.jpush.im.android.api.enums.ContentType
import cn.jpush.im.android.api.enums.MessageDirect
import cn.jpush.im.android.api.enums.MessageStatus
import cn.jpush.im.android.api.model.Message
import wxgaly.android.imdemo.entity.chat.ChatConversation

/**
 *  wxgaly.android.imdemo.viewmodel.conversation.
 *
 * @author Created by WXG on 2018/11/14 23:28.
 * @version V1.0
 */
object ConversationRemoteDataSource : IConversation {

    override fun getAllConversation(): List<ChatConversation> {
        val conversations = arrayListOf<ChatConversation>()
        val conversationList = JMessageClient.getConversationList()
        conversationList?.forEach {
            val chatConversation = ChatConversation().apply {
                id = it.id
                targetId = it.targetId
                targetInfo = it.targetInfo
                title = it.title
                unReadMsgCnt = it.unReadMsgCnt
                avatar = it.avatarFile
                messages = convertAllMessage(it.allMessage)
            }
            conversations.add(chatConversation)
        }

        return conversations
    }

    override fun getConversationById(id: String): ChatConversation? {
        val singleConversation = JMessageClient.getSingleConversation(id)

        val chatConversation = ChatConversation()

        singleConversation.let {
            chatConversation.id = it.id
            chatConversation.targetId = it.targetId
            chatConversation.targetInfo = it.targetInfo
            chatConversation.title = it.title
            chatConversation.unReadMsgCnt = it.unReadMsgCnt
            chatConversation.avatar = it.avatarFile
            chatConversation.messages = convertAllMessage(it.allMessage)
        }

        return chatConversation
    }

    override fun sendSimpleTextMessage(id: String, content: String, listener: IConversation.OnMessageCompleteListener?) {

    }

    /**
     * convertAllMessage
     */
    private fun convertAllMessage(messages: List<Message>?): List<ChatConversation.Message> {
        val chatMessages = arrayListOf<ChatConversation.Message>()

        messages?.forEach {
            chatMessages.add(ChatConversation.Message(
                    it.id,
                    convertMessageType(it.direct),
                    convertMessageStatus(it.status),
                    convertMessageContent(it.content),
                    it.createTime
            ))
        }

        return chatMessages
    }

    /**
     *convertMessageType
     */
    private fun convertMessageType(direct: MessageDirect): ChatConversation.MessageType =
            when (direct) {
                MessageDirect.send -> ChatConversation.MessageType.SEND
                MessageDirect.receive -> ChatConversation.MessageType.RECEIVE
                else -> ChatConversation.MessageType.SEND
            }

    /**
     *convertMessageStatus
     */
    private fun convertMessageStatus(status: MessageStatus): ChatConversation.MessageStatus =
            when (status) {
                MessageStatus.created -> ChatConversation.MessageStatus.CREATED
                MessageStatus.receive_fail -> ChatConversation.MessageStatus.RECEIVE_FAIL
                MessageStatus.receive_going -> ChatConversation.MessageStatus.RECEIVE_GOING
                MessageStatus.receive_success -> ChatConversation.MessageStatus.RECEIVE_SUCCESS
                MessageStatus.send_draft -> ChatConversation.MessageStatus.SEND_DRAFT
                MessageStatus.send_fail -> ChatConversation.MessageStatus.SEND_FAIL
                MessageStatus.send_going -> ChatConversation.MessageStatus.SEND_GOING
                MessageStatus.send_success -> ChatConversation.MessageStatus.SEND_SUCCESS
                else -> ChatConversation.MessageStatus.RECEIVE_SUCCESS
            }

    /**
     * convertMessageContent
     */
    private fun convertMessageContent(content: MessageContent): ChatConversation.MessageContent =
            ChatConversation.MessageContent(convertContentType(content.contentType), content.toJson())

    /**
     *convertContentType
     */
    private fun convertContentType(type: ContentType): ChatConversation.ContentType = when (type) {
        ContentType.text -> ChatConversation.ContentType.TEXT
        ContentType.custom -> ChatConversation.ContentType.CUSTOM
        ContentType.eventNotification -> ChatConversation.ContentType.EVENT_NOTIFICATION
        ContentType.file -> ChatConversation.ContentType.FILE
        ContentType.image -> ChatConversation.ContentType.IMAGE
        ContentType.location -> ChatConversation.ContentType.LOCATION
        ContentType.prompt -> ChatConversation.ContentType.PROMPT
        ContentType.unknown -> ChatConversation.ContentType.UNKNOWN
        ContentType.video -> ChatConversation.ContentType.VIDEO
        ContentType.voice -> ChatConversation.ContentType.VOICE
        else -> ChatConversation.ContentType.TEXT
    }

}