package wxgaly.android.imdemo.entity

import android.content.Context
import android.util.Log

/**
 *  wxgaly.android.imdemo.entity.
 *
 * @author Created by WXG on 2017/11/2 002 20:29.
 * @version V1.0
 */
class UserInfoUtils private constructor(context: Context) {

    private val TAG = UserInfoUtils::class.java.simpleName
    private var mManager: DaoManager = DaoManager.newInstance(context)

    fun deleteAll() {
        try {
            mManager.getDaoSession()?.userInfoDao?.deleteAll()
        } catch (e: Exception) {
            Log.e(TAG, e.message)
        }
    }

    fun deleteUserInfo(userInfo: UserInfo) {
        try {
            mManager.getDaoSession()?.userInfoDao?.delete(userInfo)
        } catch (e: Exception) {
            Log.e(TAG, e.message)
        }
    }

    fun updateUserInfo(userInfo: UserInfo) {
        try {
            val userInfoDao = mManager.getDaoSession()?.userInfoDao

            val id = userInfoDao?.getKey(userInfo)

            if (id != null) {
                if (userInfoDao.load(id) != null) {
                    userInfoDao.update(userInfo)
                } else {
                    userInfoDao.insert(userInfo)
                }
            } else {
                userInfoDao?.insert(userInfo)
            }

        } catch (e: Exception) {
            Log.e(TAG, e.message)
        }
    }

    /**
     *
     * @param userInfo
     */
    fun saveUserInfo(userInfo: UserInfo) {
        try {
            mManager.getDaoSession()?.userInfoDao?.insert(userInfo)
        } catch (e: Exception) {
            Log.e(TAG, e.message)
        }
    }

    fun getUsers(): List<UserInfo>? = mManager.getDaoSession()?.userInfoDao?.loadAll()


    companion object {

        private var INSTANCE: UserInfoUtils? = null

        @JvmStatic
        fun getInstance(context: Context) =
                INSTANCE ?: synchronized(UserInfoUtils::class.java) {
                    INSTANCE ?: UserInfoUtils(context)
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