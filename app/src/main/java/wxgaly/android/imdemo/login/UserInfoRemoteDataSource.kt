package wxgaly.android.imdemo.login

import cn.jpush.im.android.api.JMessageClient
import cn.jpush.im.api.BasicCallback
import com.google.common.collect.Lists
import wxgaly.android.imdemo.entity.IUserInfo
import wxgaly.android.imdemo.entity.UserInfo

/**
 *  wxgaly.android.imdemo.login.
 *
 * @author Created by WXG on 2017/11/2 002 21:02.
 * @version V1.0
 */
object UserInfoRemoteDataSource : IUserInfo, IUserInfo.UserInfoStateCallback {


    private const val SERVICE_LATENCY_IN_MILLIS = 5000L

    private var USERINFO_SERVICE_DATA = LinkedHashMap<String, UserInfo>(2)

    override fun getUserInfos(callback: IUserInfo.LoadUserInfoCallback) {
        callback.onUserInfoLoaded(Lists.newArrayList(USERINFO_SERVICE_DATA.values))
    }

    override fun getUserInfo(username: String, callback: IUserInfo.GetUserInfoCallback) {
        val task = USERINFO_SERVICE_DATA[username]
        task?.let { callback.onUserInfoLoaded(it) }

    }

    override fun saveUserInfo(user: UserInfo) {
        USERINFO_SERVICE_DATA.put(user.username, user)
    }

    override fun login(user: UserInfo, callback: IUserInfo.UserInfoCallback?) {
        JMessageClient.login(user.username, user.password, object : BasicCallback() {
            override fun gotResult(code: Int, message: String?) {
                callback?.getResult(code, message)
            }
        })
    }
    override fun register(user: UserInfo, callback: IUserInfo.UserInfoCallback?) {
        JMessageClient.register(user.username, user.password, object : BasicCallback() {
            override fun gotResult(code: Int, message: String?) {
                callback?.getResult(code, message)
            }
        })
    }

    override fun logout(user: UserInfo) {
        JMessageClient.logout()
    }

    override fun deleteAllUserInfos() {
        USERINFO_SERVICE_DATA.clear()
    }

    override fun deleteUserInfo(username: String) {
        USERINFO_SERVICE_DATA.remove(username)
    }
}