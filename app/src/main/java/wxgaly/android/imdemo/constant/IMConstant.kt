package wxgaly.android.imdemo.constant

import android.provider.BaseColumns

/**
 * Created by WXGALY on 2017/11/2.
 */

object IMConstant {

    /* Inner class that defines the table contents */
    object UuserEntry : BaseColumns {
        const val TABLE_NAME = "user_info"
        const val COLUMN_NAME_ENTRY_ID = "entryid"
        const val COLUMN_NAME_USERNAME = "username"
        const val COLUMN_NAME_PASSWORD = "password"
        const val COLUMN_NAME_LOGTYPE = "loginType"
    }

    enum class LoginType{
        LOGIN, LOGOUT, NOT_LOGIN
    }
}

