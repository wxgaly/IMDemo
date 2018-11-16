package wxgaly.android.imdemo

import android.arch.lifecycle.AndroidViewModel
import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import wxgaly.android.imdemo.util.setFullScreen

/**
 *  wxgaly.android.imdemo.
 *
 * @author Created by WXG on 2018/11/3 0:32.
 * @version V1.0
 */
abstract class BaseActivity : AppCompatActivity() {

    val KEY_USERNAME = "username"
    val KEY_PASSWORD = "password"

    val REGISTER_SUCCESS_REQUEST_CODE = 10000
    val REGISTER_SUCCESS_RESULT_CODE = 10001

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setFullScreen()
        initData()
    }

    abstract fun initData()

    abstract fun obtainViewModel(): AndroidViewModel

}