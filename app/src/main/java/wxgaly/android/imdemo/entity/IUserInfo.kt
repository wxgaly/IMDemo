package wxgaly.android.imdemo.entity

import android.view.View


/**
 *  wxgaly.android.imdemo.entity.
 *
 * @author Created by WXG on 2017/11/2 002 20:53.
 * @version V1.0
 */
interface IUserInfo {

    interface LoadUserInfoCallback {
        fun onUserInfoLoaded(users: List<UserInfo>)

        fun onDataNotAvailable()
    }

    interface GetUserInfoCallback {
        fun onUserInfoLoaded(user: UserInfo)

        fun onDataNotAvailable()
    }

    interface UserInfoStateCallback {
        fun login(user: UserInfo, callback: UserInfoCallback?)

        fun logout(user: UserInfo)

        fun register(user: UserInfo, callback: UserInfoCallback?)
    }

    interface UserInfoViewListener {
        fun login(view : View)

        fun logout(view : View)

        fun register(view : View)
    }

    interface UserInfoCallback {
        fun getResult(code : Int, message : String?)
    }

    fun getUserInfos(callback: LoadUserInfoCallback)

    fun getUserInfo(username: String, callback: GetUserInfoCallback)

    fun saveUserInfo(user: UserInfo)

    fun deleteAllUserInfos()

    fun deleteUserInfo(username: String)

}