package wxgaly.android.imdemo.viewmodel.user

import wxgaly.android.imdemo.application.IMApplication
import wxgaly.android.imdemo.login.UserInfoLocalDataSource
import wxgaly.android.imdemo.login.UserInfoRemoteDataSource
import wxgaly.android.imdemo.login.UserInfoRepository
import wxgaly.android.imdemo.viewmodel.BaseRepository
import wxgaly.android.imdemo.viewmodel.ViewModelType
import wxgaly.android.imdemo.viewmodel.conversation.ConversationRemoteDataSource
import wxgaly.android.imdemo.viewmodel.conversation.ConversationRepository
import java.util.*

/**
 *  wxgaly.android.imdemo.
 *
 * @author Created by WXG on 2017/11/3 003 10:06.
 * @version V1.0
 */
object Injection {

    fun provideRepositoryByType(type: ViewModelType): BaseRepository? = map[type]

    private val map = HashMap<ViewModelType, BaseRepository>()

    init {
        addRepository(UserInfoRepository.getInstance(UserInfoRemoteDataSource,
                UserInfoLocalDataSource.getInstance(IMApplication.instance)))
        addRepository(ConversationRepository.getInstance(ConversationRemoteDataSource))
    }

    private fun addRepository(repository: BaseRepository) {
        map[repository.getViewModelType()] = repository
    }
}