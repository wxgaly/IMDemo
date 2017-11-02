package wxgaly.android.imdemo.login

import android.app.Application
import android.arch.lifecycle.AndroidViewModel
import wxgaly.android.imdemo.entity.IUserInfo
import wxgaly.android.imdemo.entity.UserInfo

/**
 *  wxgaly.android.imdemo.login.
 *
 * @author Created by WXG on 2017/11/2 002 20:51.
 * @version V1.0
 */
class UserViewModel(context: Application) : AndroidViewModel(context), IUserInfo.GetUserInfoCallback {


    override fun onUserInfoLoaded(user: UserInfo) {

    }

    override fun onDataNotAvailable() {

    }


}