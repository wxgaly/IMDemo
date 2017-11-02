package wxgaly.android.imdemo.entity

import android.content.Context

/**
 *  wxgaly.android.imdemo.entity.
 *
 * @author Created by WXG on 2017/11/2 002 20:29.
 * @version V1.0
 */
class UserInfoUtils {

    private val TAG = UserInfoUtils::class.java.simpleName
    private lateinit var mManager : DaoManager

    private fun init(context: Context): UserInfoUtils? {

        mManager = DaoManager.getInstance(context)

        return UserInfoUtils()
    }

    companion object {

        private var INSTANCE: UserInfoUtils? = null

        @JvmStatic
        fun getInstance(context: Context) =
                INSTANCE ?: synchronized(UserInfoUtils::class.java) {
                    INSTANCE ?: UserInfoUtils().also { INSTANCE = it.init(context) }
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