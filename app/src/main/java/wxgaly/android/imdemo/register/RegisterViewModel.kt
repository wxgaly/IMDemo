package wxgaly.android.imdemo.register

import android.app.Application
import android.arch.lifecycle.AndroidViewModel
import android.content.Context
import android.databinding.ObservableField
import android.text.TextUtils
import android.view.View
import com.dd.processbutton.iml.ActionProcessButton
import wxgaly.android.imdemo.R
import wxgaly.android.imdemo.SingleLiveEvent
import wxgaly.android.imdemo.entity.UserInfo
import wxgaly.android.imdemo.login.UserInfoActionListener
import wxgaly.android.imdemo.login.UserInfoRepository
import wxgaly.android.imdemo.util.ToastUtils

/**
 *  wxgaly.android.imdemo.register.
 *
 * @author Created by WXG on 2018/11/3 0:22.
 * @version V1.0
 */
class RegisterViewModel(context: Application, private val userInfoRepository: UserInfoRepository)
    : AndroidViewModel(context), UserInfoActionListener {

    val username = ObservableField<String>()
    val password = ObservableField<String>()
    val registerSuccessEvent = SingleLiveEvent<Void>()

    override fun login(view: View) {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    override fun logout(view: View) {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    override fun register(view: View) {
        val user = UserInfo()
        user.username = username.get()
        user.password = password.get()

        if (!TextUtils.isEmpty(user.username) && !TextUtils.isEmpty(user.password)) {
            (view as ActionProcessButton).progress = 1
//            userInfoRepository.register(user, object : IUserInfo.UserInfoCallback {
//                override fun getResult(code: Int, message: String?) {
//                    if (code == 0) {
//                        view.progress = 100
//
//                    } else {
//
//                    }
//                }
//            })
            view.progress = 100
            registerSuccessEvent.call()
        } else {
            (view as ActionProcessButton).progress = -1
            val context: Context = getApplication()
            ToastUtils.showToastShort(getApplication(), context.resources.getString(R.string.username_or_password_is_not_null))

        }
    }
}