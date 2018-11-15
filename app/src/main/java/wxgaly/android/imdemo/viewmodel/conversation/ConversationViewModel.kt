package wxgaly.android.imdemo.viewmodel.conversation

import android.app.Application
import android.arch.lifecycle.AndroidViewModel
import wxgaly.android.imdemo.entity.chat.ChatConversation

/**
 *  wxgaly.android.imdemo.viewmodel.conversation.
 *
 * @author Created by WXG on 2018/11/15 015 9:36.
 * @version V1.0
 */
class ConversationViewModel(context: Application,
                            private val repository: ConversationRepository)
    : AndroidViewModel(context), IConversation {

    override fun getAllConversation(): List<ChatConversation> = repository.getAllConversation()

    override fun getConversationById(id: String): ChatConversation? = repository.getConversationById(id)

    override fun sendSimpleTextMessage(id: String, content: String, listener: IConversation.OnMessageCompleteListener?) {
        repository.sendSimpleTextMessage(id, content, listener)
    }

}