package wxgaly.android.imdemo.login

import android.app.Application
import android.arch.lifecycle.AndroidViewModel
import android.content.Context
import android.content.Intent
import android.databinding.ObservableField
import android.text.TextUtils
import android.view.View
import com.dd.processbutton.iml.ActionProcessButton
import wxgaly.android.imdemo.R
import wxgaly.android.imdemo.entity.IUserInfo
import wxgaly.android.imdemo.entity.UserInfo
import wxgaly.android.imdemo.home.HomeActivity
import wxgaly.android.imdemo.register.RegisterActivity
import wxgaly.android.imdemo.util.ToastUtils

/**
 *  wxgaly.android.imdemo.login.
 *
 * @author Created by WXG on 2017/11/2 002 20:51.
 * @version V1.0
 */
class UserViewModel(context: Application, private val userInfoRepository: UserInfoRepository)
    : AndroidViewModel(context), IUserInfo, UserInfoActionListener {

    val username = ObservableField<String>()
    val password = ObservableField<String>()

    override fun login(view: View) {
        val user = UserInfo()
        user.username = username.get()
        user.password = password.get()
        user.loginTime = System.currentTimeMillis()

        if (!TextUtils.isEmpty(user.username) && !TextUtils.isEmpty(user.password)) {
            (view as ActionProcessButton).progress = 1
            userInfoRepository.login(user, object : IUserInfo.UserInfoCallback {
                override fun getResult(code: Int, message: String?) {
                    val context: Context = getApplication()
                    if (code == 0) {
                        view.progress = 100
                        ToastUtils.showToastShort(getApplication(),
                                "${context.resources.getString(R.string.login_success)}$message")
                        user.loginType = 1
                        userInfoRepository.saveUserInfo(user)
                        val intent = Intent(context, HomeActivity::class.java).apply {
                            addFlags(Intent.FLAG_ACTIVITY_NEW_TASK or Intent.FLAG_ACTIVITY_CLEAR_TASK)
                        }
                        context.startActivity(intent)
                    } else {
                        view.progress = -1

                        userInfoRepository.saveUserInfo(user)
                        ToastUtils.showToastShort(getApplication(),
                                "${context.resources.getString(R.string.login_error)}$message")
                    }
                }
            })
        } else {
            (view as ActionProcessButton).progress = -1
            val context: Context = getApplication()
            ToastUtils.showToastShort(getApplication(), context.resources.getString(R.string.username_or_password_is_not_null))

        }
    }

    override fun logout(view: View) {
        val user = UserInfo()
        user.username = username.get()
        user.password = password.get()

        (view as ActionProcessButton).progress = -1

        userInfoRepository.logout(user)
        userInfoRepository.saveUserInfo(user)

        view.progress = 100
    }

    override fun register(view: View) {
        val user = UserInfo()
        user.username = username.get()
        user.password = password.get()
        userInfoRepository.register(user, object : IUserInfo.UserInfoCallback {
            override fun getResult(code: Int, message: String?) {

            }

        })
    }

    override fun getUserInfos(callback: IUserInfo.LoadUserInfoCallback?) {

        userInfoRepository.getUserInfos(object : IUserInfo.LoadUserInfoCallback {
            override fun onUserInfoLoaded(users: List<UserInfo>) {
                if (users.isNotEmpty()) {
                    users[0].apply {
                        this@UserViewModel.username.set(username)
                        this@UserViewModel.password.set(password)
                    }
                }
            }

            override fun onDataNotAvailable() {
                callback?.onDataNotAvailable()
            }

        })
    }

    override fun getUserInfo(username: String, callback: IUserInfo.GetUserInfoCallback?) {
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

    fun startRegisterActivity(view: View) {
        val context: Context = getApplication()
        val intent = Intent(context, RegisterActivity::class.java).apply {
            addFlags(Intent.FLAG_ACTIVITY_NEW_TASK)
        }
        context.startActivity(intent)
    }

}