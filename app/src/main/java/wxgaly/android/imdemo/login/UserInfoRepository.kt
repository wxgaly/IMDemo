package wxgaly.android.imdemo.login

import cn.jpush.im.api.BasicCallback
import wxgaly.android.imdemo.entity.IUserInfo
import wxgaly.android.imdemo.entity.UserInfo

/**
 *  wxgaly.android.imdemo.login.
 *
 * @author Created by WXG on 2017/11/3 003 10:00.
 * @version V1.0
 */
class UserInfoRepository(
        val userInfoLocalDataSource: UserInfoLocalDataSource,
        val userInfoRemoteDataSource: UserInfoRemoteDataSource
) : IUserInfo, IUserInfo.UserInfoStateCallback {

    override fun login(user: UserInfo, callback: IUserInfo.UserInfoCallback?) {
        userInfoRemoteDataSource.login(user, callback)
    }

    override fun register(user: UserInfo, callback: IUserInfo.UserInfoCallback?) {
        userInfoRemoteDataSource.register(user, callback)
    }

    override fun getUserInfos(callback: IUserInfo.LoadUserInfoCallback) {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    override fun getUserInfo(username: String, callback: IUserInfo.GetUserInfoCallback) {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    override fun saveUserInfo(user: UserInfo) {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }


    override fun logout(user: UserInfo) {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }


    override fun deleteAllUserInfos() {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    override fun deleteUserInfo(username: String) {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    companion object {
        private var INSTANCE: UserInfoRepository? = null

        @JvmStatic
        fun getInstance(
                userInfoRemoteDataSource: UserInfoRemoteDataSource,
                userInfoLocalDataSource: UserInfoLocalDataSource) =
                INSTANCE ?: synchronized(UserInfoRepository::class.java) {
                    INSTANCE ?: UserInfoRepository(userInfoLocalDataSource, userInfoRemoteDataSource)
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