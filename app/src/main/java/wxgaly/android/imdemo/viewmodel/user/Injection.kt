package wxgaly.android.imdemo.viewmodel.user

import android.content.Context
import wxgaly.android.imdemo.login.UserInfoLocalDataSource
import wxgaly.android.imdemo.login.UserInfoRemoteDataSource
import wxgaly.android.imdemo.login.UserInfoRepository
import wxgaly.android.imdemo.viewmodel.ViewModelType

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

    fun provideRepositoryByType(context: Context, type: ViewModelType): Any = when (type) {
        ViewModelType.USER_TYPE -> UserInfoRepository.getInstance(UserInfoRemoteDataSource,
                UserInfoLocalDataSource.getInstance(context))
        ViewModelType.CONVERSATION_TYPE ->
        else -> {
            throw IllegalArgumentException("Unknown ViewModelType : ${type.name}")
        }
    }
}