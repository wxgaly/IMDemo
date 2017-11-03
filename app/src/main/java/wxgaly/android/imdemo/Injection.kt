package wxgaly.android.imdemo

import android.content.Context
import wxgaly.android.imdemo.login.UserInfoLocalDataSource
import wxgaly.android.imdemo.login.UserInfoRemoteDataSource
import wxgaly.android.imdemo.login.UserInfoRepository

/**
 *  wxgaly.android.imdemo.
 *
 * @author Created by WXG on 2017/11/3 003 10:06.
 * @version V1.0
 */
object Injection {

    fun provideUserInfoRepository(context: Context) =
            UserInfoRepository.getInstance(UserInfoRemoteDataSource,
                    UserInfoLocalDataSource.getInstance(context))
}