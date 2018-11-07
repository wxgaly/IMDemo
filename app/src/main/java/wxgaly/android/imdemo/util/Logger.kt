package wxgaly.android.imdemo.util

import android.util.Log
import wxgaly.android.imdemo.BuildConfig

/**
 *  wxgaly.android.imdemo.util.
 *
 * @author Created by WXG on 2018/11/7 007 15:06.
 * @version V1.0
 */
object Logger {

    private val isDebug = BuildConfig.DEBUG
    private val TAG = "TAG"

    fun i(tag: String = TAG, msg: String) {
        if (isDebug) {
            Log.i(tag, msg)
        }
    }

    fun d(tag: String = TAG, msg: String) {
        if (isDebug) {
            Log.d(tag, msg)
        }
    }

}