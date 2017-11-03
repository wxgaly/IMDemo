package wxgaly.android.imdemo.entity

import cn.jpush.im.api.BasicCallback

/**
 *  wxgaly.android.imdemo.entity.
 *
 * @author Created by WXG on 2017/11/2 002 20:53.
 * @version V1.0
 */
interface IUserInfo {

    interface LoadUserInfoCallback {
        fun onUserInfoLoaded(users : List<UserInfo>)

        fun onDataNotAvailable()
    }

    interface GetUserInfoCallback {
        fun onUserInfoLoaded(user : UserInfo)

        fun onDataNotAvailable()
    }

    interface UserInfoStateCallback{
        fun login(user : UserInfo, callback: BasicCallback)

        fun logout(user: UserInfo)

        fun register(user : UserInfo, callback: BasicCallback)
    }

    fun getUserInfos(callback: LoadUserInfoCallback)

    fun getUserInfo(username: String, callback: GetUserInfoCallback)

    fun saveUserInfo(user: UserInfo)

    fun deleteAllUserInfos()

    fun deleteUserInfo(username: String)

}