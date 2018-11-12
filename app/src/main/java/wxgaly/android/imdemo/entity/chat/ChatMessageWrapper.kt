package wxgaly.android.imdemo.entity.chat

/**
 *  wxgaly.android.imdemo.entity.chat.
 *
 * @author Created by WXG on 2018/11/13 0:32.
 * @version V1.0
 */
data class ChatMessageWrapper(
        val head: String,
        val username:String,
        val content: String,
        val timestamp: Long)