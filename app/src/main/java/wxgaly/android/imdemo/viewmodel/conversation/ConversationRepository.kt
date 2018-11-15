package wxgaly.android.imdemo.viewmodel.conversation

import wxgaly.android.imdemo.entity.chat.ChatConversation
import wxgaly.android.imdemo.viewmodel.BaseRepository
import wxgaly.android.imdemo.viewmodel.ViewModelType

/**
 *  wxgaly.android.imdemo.viewmodel.conversation.
 *
 * @author Created by WXG on 2018/11/14 014 17:19.
 * @version V1.0
 */
class ConversationRepository(private val remoteDataSource: ConversationRemoteDataSource) : BaseRepository(),
        IConversation {

    override fun getViewModelType(): ViewModelType = ViewModelType.CONVERSATION_TYPE

    override fun getAllConversation(): List<ChatConversation> = remoteDataSource.getAllConversation()

    override fun getConversationById(id: String): ChatConversation? = remoteDataSource.getConversationById(id)

    override fun sendSimpleTextMessage(id: String, content: String, listener: IConversation.OnMessageCompleteListener?) {
        remoteDataSource.sendSimpleTextMessage(id, content, listener)
    }

    companion object {
        private var INSTANCE: ConversationRepository? = null

        @JvmStatic
        fun getInstance(
                remoteDataSource: ConversationRemoteDataSource) =
                INSTANCE ?: synchronized(ConversationRepository::class.java) {
                    INSTANCE ?: ConversationRepository(remoteDataSource)
                            .also { INSTANCE = it }
                }


        /**
         * Used to force [getInstance] to create a new instance
         * next time it's called.
         */
        @JvmStatic
        fun destroyInstance() {
            INSTANCE = null
        }
    }

}