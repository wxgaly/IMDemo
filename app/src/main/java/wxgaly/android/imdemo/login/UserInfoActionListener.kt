package wxgaly.android.imdemo.login

import android.view.View

/**
 * Created by WXGALY on 2017/11/8.
 */
interface UserInfoActionListener {

    fun login(view : View)

    fun logout(view : View)

    fun register(view : View)
}