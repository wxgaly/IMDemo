package wxgaly.android.imdemo.home.adapter

import com.chad.library.adapter.base.BaseQuickAdapter
import com.chad.library.adapter.base.BaseViewHolder
import wxgaly.android.imdemo.R
import wxgaly.android.imdemo.entity.chat.ChatMessageWrapper
import wxgaly.android.imdemo.util.DateUtil

/**
 *  wxgaly.android.imdemo.home.adapter.
 *
 * @author Created by WXG on 2018/11/13 0:30.
 * @version V1.0
 */
class MessageListAdapter(resId: Int, data: List<ChatMessageWrapper>)
    : BaseQuickAdapter<ChatMessageWrapper, BaseViewHolder>(resId, data) {

    override fun convert(helper: BaseViewHolder, item: ChatMessageWrapper) {
        helper.setText(R.id.message_tv_name, item.username)
                .setText(R.id.message_tv_content, item.content)
                .setText(R.id.message_tv_time, DateUtil.getTime(item.timestamp))
    }
}