package wxgaly.android.imdemo.application

import android.app.Application
import cn.jpush.im.android.api.JMessageClient

/**
 * Created by WXGALY on 2017/11/2.
 */
class IMApplication() : Application(){

    override fun onCreate() {
        super.onCreate()

        initJMessage()

    }

    /**
     * init the JMessage
     */
    private fun initJMessage() {
        JMessageClient.setDebugMode(true)
        JMessageClient.init(this)
    }

//    fun getUserInfo(): UserInfo {
//        return
//    }

}