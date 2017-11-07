package wxgaly.android.imdemo.login

import android.app.Application
import android.arch.lifecycle.AndroidViewModel
import android.databinding.ObservableBoolean
import wxgaly.android.imdemo.entity.IUserInfo
import wxgaly.android.imdemo.entity.UserInfo

/**
 *  wxgaly.android.imdemo.login.
 *
 * @author Created by WXG on 2017/11/2 002 20:51.
 * @version V1.0
 */
class UserViewModel(context: Application, private val userInfoRepository: UserInfoRepository)
    : AndroidViewModel(context), IUserInfo, IUserInfo.UserInfoViewListener {

    val isLoginSuccess = ObservableBoolean(false)
    val isRegisterSuccess = ObservableBoolean(false)
    val isLogoutSuccess = ObservableBoolean(false)

    override fun login(user: UserInfo) {
        userInfoRepository.login(user, object : IUserInfo.UserInfoCallback{
            override fun getResult(code: Int, message: String?) {

            }
        })
    }

    override fun logout(user: UserInfo) {
        userInfoRepository.logout(user)
    }

    override fun register(user: UserInfo) {
        userInfoRepository.register(user, object : IUserInfo.UserInfoCallback{
            override fun getResult(code: Int, message: String?) {

            }

        })
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

    override fun deleteAllUserInfos() {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    override fun deleteUserInfo(username: String) {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }


}