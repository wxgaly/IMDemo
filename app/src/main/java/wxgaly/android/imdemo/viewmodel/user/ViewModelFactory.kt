package wxgaly.android.imdemo.viewmodel.user

import android.annotation.SuppressLint
import android.app.Application
import android.arch.lifecycle.ViewModel
import android.arch.lifecycle.ViewModelProvider
import android.support.annotation.VisibleForTesting
import wxgaly.android.imdemo.login.UserInfoRepository
import wxgaly.android.imdemo.login.UserViewModel
import wxgaly.android.imdemo.register.RegisterViewModel
import wxgaly.android.imdemo.viewmodel.BaseRepository
import wxgaly.android.imdemo.viewmodel.ViewModelType
import wxgaly.android.imdemo.viewmodel.conversation.ConversationRepository
import wxgaly.android.imdemo.viewmodel.conversation.ConversationViewModel

/**
 *  wxgaly.android.imdemo.
 *
 * @author Created by WXG on 2017/11/3 003 9:58.
 * @version V1.0
 */
class ViewModelFactory private constructor(
        private val application: Application,
        var repository: BaseRepository?
) : ViewModelProvider.NewInstanceFactory() {

    @Suppress("UNCHECKED_CAST", "IMPLICIT_CAST_TO_ANY")
    override fun <T : ViewModel> create(modelClass: Class<T>) =
            with(modelClass) {
                when (repository) {
                    is UserInfoRepository -> {
                        when {
                            isAssignableFrom(UserViewModel::class.java) ->
                                UserViewModel(application, repository as UserInfoRepository)
                            isAssignableFrom(RegisterViewModel::class.java) ->
                                RegisterViewModel(application, repository as UserInfoRepository)
                            else ->
                                throw IllegalArgumentException("Unknown ViewModel class: ${modelClass.name}")
                        }
                    }
                    is ConversationRepository -> {
                        when {
                            isAssignableFrom(ConversationViewModel::class.java) ->
                                ConversationViewModel(application, repository as ConversationRepository)
                            else ->
                                throw IllegalArgumentException("Unknown ViewModel class: ${modelClass.name}")
                        }
                    }
                    else -> throw IllegalArgumentException("Unknown ViewModel class: ${modelClass.name}")
                }
            } as T

    companion object {

        @SuppressLint("StaticFieldLeak")
        @Volatile
        private var INSTANCE: ViewModelFactory? = null

        fun getInstance(application: Application, type: ViewModelType): ViewModelFactory? {
            if (INSTANCE == null) {
                synchronized(ViewModelFactory::class.java) {
                    INSTANCE ?: ViewModelFactory(application, Injection.provideRepositoryByType(type))
                            .also {
                                INSTANCE = it
                            }
                }
            }
            return INSTANCE?.apply {
                repository = Injection.provideRepositoryByType(type)
            }
        }


        @VisibleForTesting
        fun destroyInstance() {
            INSTANCE = null
        }
    }

}