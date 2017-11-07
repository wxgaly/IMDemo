package wxgaly.android.imdemo.login

import wxgaly.android.imdemo.entity.UserInfo

/**
 * Created by WXGALY on 2017/11/8.
 */
interface UserInfoActionListener {

    fun login(userInfo : UserInfo)

    fun register(userInfo: UserInfo)

    fun logout(userInfo : UserInfo)

}