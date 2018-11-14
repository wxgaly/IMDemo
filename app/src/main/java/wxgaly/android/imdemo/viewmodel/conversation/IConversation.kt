package wxgaly.android.imdemo.viewmodel.conversation

import wxgaly.android.imdemo.entity.chat.ChatConversation

/**
 *  wxgaly.android.imdemo.viewmodel.conversation.
 *
 * @author Created by WXG on 2018/11/14 014 17:19.
 * @version V1.0
 */
interface IConversation {

    fun getAllConversation(): List<ChatConversation>?

    fun getConversationById(id: String): ChatConversation?

}