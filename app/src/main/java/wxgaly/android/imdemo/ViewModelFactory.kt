package wxgaly.android.imdemo

import android.annotation.SuppressLint
import android.app.Application
import android.arch.lifecycle.ViewModel
import android.arch.lifecycle.ViewModelProvider
import android.support.annotation.VisibleForTesting
import wxgaly.android.imdemo.login.UserInfoRepository
import wxgaly.android.imdemo.login.UserViewModel

/**
 *  wxgaly.android.imdemo.
 *
 * @author Created by WXG on 2017/11/3 003 9:58.
 * @version V1.0
 */
class ViewModelFactory private constructor(
        private val application: Application,
        private val userInfoRepository: UserInfoRepository
) : ViewModelProvider.NewInstanceFactory() {

    override fun <T : ViewModel> create(modelClass: Class<T>) =
            with(modelClass) {
                when {
                    isAssignableFrom(UserViewModel::class.java) ->
                        UserViewModel(application, userInfoRepository)
                    else ->
                        throw IllegalArgumentException("Unknown ViewModel class: ${modelClass.name}")
                }
            } as T

    companion object {

        @SuppressLint("StaticFieldLeak")
        @Volatile private var INSTANCE: ViewModelFactory? = null

        fun getInstance(application: Application) =
                INSTANCE ?: synchronized(ViewModelFactory::class.java) {
                    INSTANCE ?: ViewModelFactory(application,
                            Injection.provideUserInfoRepository(application.applicationContext))
                            .also { INSTANCE = it }
                }


        @VisibleForTesting
        fun destroyInstance() {
            INSTANCE = null
        }
    }

}