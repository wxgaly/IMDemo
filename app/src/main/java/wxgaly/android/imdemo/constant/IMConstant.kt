package wxgaly.android.imdemo.constant

import android.provider.BaseColumns

/**
 * Created by WXGALY on 2017/11/2.
 */

object IMConstant {

    object IMDataBase {
        const val DB_NAME = "IM_DB"
        const val DB_PASSWORD = "123456"
    }

    /* Inner class that defines the table contents */
    object UuserEntry : BaseColumns {
        const val TABLE_NAME = "user_info"
        const val COLUMN_NAME_ENTRY_ID = "entryid"
        const val COLUMN_NAME_USERNAME = "username"
        const val COLUMN_NAME_PASSWORD = "password"
        const val COLUMN_NAME_LOGTYPE = "loginType"
    }

    enum class LoginType {
        LOGOUT, LOGIN, NOT_LOGIN
    }

    object ActivityConstant {
        /**
         * 启动时长
         */
        const val DURATION = 1 * 1000L
    }


}

