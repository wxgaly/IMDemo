package wxgaly.android.imdemo.login

import android.content.Context
import wxgaly.android.imdemo.entity.IUserInfo
import wxgaly.android.imdemo.entity.UserInfo
import wxgaly.android.imdemo.entity.UserInfoUtils

/**
 *  wxgaly.android.imdemo.login.
 *
 * @author Created by WXG on 2017/11/3 003 10:13.
 * @version V1.0
 */
class UserInfoLocalDataSource private constructor(private val context: Context) : IUserInfo {

    override fun getUserInfos(callback: IUserInfo.LoadUserInfoCallback?) {
        UserInfoUtils.getInstance(context).getUsers()?.let {
            callback?.onUserInfoLoaded(it)
        }

    }

    override fun getUserInfo(username: String, callback: IUserInfo.GetUserInfoCallback?) {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    override fun saveUserInfo(user: UserInfo) {
        UserInfoUtils.getInstance(context).updateUserInfo(user)
    }

    override fun deleteAllUserInfos() {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    override fun deleteUserInfo(username: String) {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    companion object {
        private var INSTANCE: UserInfoLocalDataSource? = null

        @JvmStatic
        fun getInstance(context: Context) =
                INSTANCE ?: synchronized(UserInfoLocalDataSource::class.java) {
                    INSTANCE ?: UserInfoLocalDataSource(context)
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