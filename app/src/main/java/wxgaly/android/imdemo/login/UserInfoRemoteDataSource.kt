package wxgaly.android.imdemo.login

import android.os.Handler
import com.google.common.collect.Lists
import wxgaly.android.imdemo.entity.IUserInfo
import wxgaly.android.imdemo.entity.UserInfo

/**
 *  wxgaly.android.imdemo.login.
 *
 * @author Created by WXG on 2017/11/2 002 21:02.
 * @version V1.0
 */
object UserInfoRemoteDataSource : IUserInfo {

    private const val SERVICE_LATENCY_IN_MILLIS = 5000L

    private var USERINFO_SERVICE_DATA = LinkedHashMap<String, UserInfo>(2)

    override fun getUserInfos(callback: IUserInfo.LoadUserInfoCallback) {
        val userInfo = Lists.newArrayList(USERINFO_SERVICE_DATA.values)
        Handler().postDelayed({
            callback.onUserInfoLoaded(userInfo)
        }, SERVICE_LATENCY_IN_MILLIS)

    }

    override fun getUserInfo(username: String, callback: IUserInfo.GetUserInfoCallback) {



    }

    override fun saveUserInfo(user: UserInfo) {


    }

    override fun login(user: UserInfo) {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    override fun logout(user: UserInfo) {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    override fun register(username: String, password: String) {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    override fun deleteAllUserInfos() {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    override fun deleteUserInfo(username: String) {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }
}