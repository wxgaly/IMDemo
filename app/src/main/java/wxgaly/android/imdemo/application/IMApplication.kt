package wxgaly.android.imdemo.application

import android.app.Application
import android.content.Context
import cn.jpush.im.android.api.JMessageClient
import wxgaly.android.imdemo.entity.DaoManager
import kotlin.properties.Delegates

/**
 * Created by WXGALY on 2017/11/2.
 */
class IMApplication : Application() {

    var context: Context? = null

    override fun onCreate() {
        super.onCreate()
        instance=this
        initJMessage()
        initDatabase()
    }

    private fun initDatabase() {
        DaoManager.newInstance(this)
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

    companion object {
        var instance: IMApplication by Delegates.notNull()
    }

}