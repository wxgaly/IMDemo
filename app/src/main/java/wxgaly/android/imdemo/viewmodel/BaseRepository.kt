package wxgaly.android.imdemo.viewmodel

/**
 *  wxgaly.android.imdemo.viewmodel.
 *
 * @author Created by WXG on 2018/11/15 015 9:24.
 * @version V1.0
 */
abstract class BaseRepository {

    /**
     * 获取viewmodel的类型
     * @return [ViewModelType]
     */
    abstract fun getViewModelType(): ViewModelType

}