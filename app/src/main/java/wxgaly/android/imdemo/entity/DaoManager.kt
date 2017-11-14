package wxgaly.android.imdemo.entity

import android.content.Context
import android.util.Log
import org.greenrobot.greendao.query.QueryBuilder
import wxgaly.android.imdemo.constant.IMConstant
import wxgaly.android.imdemo.constant.IMConstant.IMDataBase.DB_NAME


/**
 *  wxgaly.android.imdemo.entity.
 *
 * @author Created by WXG on 2017/11/2 002 19:17.
 * @version V1.0
 */
class DaoManager {

    private val TAG = DaoManager::class.java.simpleName

    private lateinit var mContext: Context
    private var mDaoMaster: DaoMaster? = null
    private var mHelper: DaoMaster.DevOpenHelper? = null
    private var mDaoSession: DaoSession? = null

    fun init(context: Context): DaoManager {

        mContext = context

        return this
    }

    /**
     * get the dao manager.
     */
    fun getDaoMaster(): DaoMaster? {
        if (mDaoMaster == null) {
            mHelper = DaoMaster.DevOpenHelper(mContext, DB_NAME, null)
            mDaoMaster = DaoMaster(mHelper?.getEncryptedWritableDb(IMConstant.IMDataBase.DB_PASSWORD))
        }

        return mDaoMaster
    }

    /**
     * get the dao session.
     */
    fun getDaoSession(): DaoSession? {

        if (mDaoSession == null) {
            if (mDaoMaster == null) {
                mDaoMaster = getDaoMaster()
            }
            mDaoSession = mDaoMaster?.newSession()
        }

        return mDaoSession
    }

    fun saveUserInfo(userInfo: UserInfo) {
        try {
            getDaoSession()?.userInfoDao?.insert(userInfo)
        } catch (e: Exception) {
            Log.e(TAG, e.message)
        }
    }

    /**
     * 打开输出日志，默认关闭
     */
    fun setDebug() {
        QueryBuilder.LOG_SQL = true
        QueryBuilder.LOG_VALUES = true
    }

    /**
     * 关闭所有的操作，数据库开启后，使用完毕要关闭
     */
    fun closeConnection() {
        closeHelper()
        closeDaoSession()
    }

    private fun closeHelper() {
        if (mHelper != null) {
            mHelper?.close()
            mHelper = null
        }
    }

    private fun closeDaoSession() {
        if (mDaoSession != null) {
            mDaoSession?.clear()
            mDaoSession = null
        }
    }

    companion object {

        private var INSTANCE: DaoManager? = null

        @JvmStatic
        fun newInstance(context: Context) =
                INSTANCE ?: synchronized(DaoManager::class.java) {
                    INSTANCE ?: DaoManager().also { INSTANCE = it.init(context) }
                }

        fun getInstance() = INSTANCE ?: synchronized(DaoManager::class.java) {
            INSTANCE ?: DaoManager()
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