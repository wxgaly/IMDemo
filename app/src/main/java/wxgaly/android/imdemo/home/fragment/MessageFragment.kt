package wxgaly.android.imdemo.home.fragment

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import cn.jpush.im.android.api.ContactManager
import cn.jpush.im.android.api.JMessageClient
import cn.jpush.im.android.api.callback.GetUserInfoListCallback
import cn.jpush.im.android.api.model.UserInfo
import wxgaly.android.imdemo.R
import wxgaly.android.imdemo.util.Logger

/**
 *  wxgaly.android.imdemo.home.fragment.
 *
 * @author Created by WXG on 2018/11/9 009 10:34.
 * @version V1.0
 */
class MessageFragment : BaseFragment() {

    private val TAG = "MessageFragment"

    override fun getView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        return inflater.inflate(R.layout.frag_message, container, false)
    }

    override fun initData() {

        JMessageClient.getConversationList()?.forEach { conversation ->
            conversation.allMessage?.forEach {
                Logger.d(TAG, "${conversation.id} : ${it.content}")
            }
        }

        ContactManager.getFriendList(object : GetUserInfoListCallback() {
            override fun gotResult(responseCode: Int, responseMessage: String?, userInfoList: MutableList<UserInfo>?) {
                if (0 == responseCode) {
                    //获取好友列表成功
                    userInfoList?.forEach {
                        Logger.d(TAG, " user info is ${it.displayName}")
                    }
                } else {
                    //获取好友列表失败
                    Logger.d(TAG, "获取好友列表失败 , code is $responseCode")
                }
            }

        })
    }

    companion object {
        fun newInstance() = MessageFragment()
    }

}