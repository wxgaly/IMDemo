package wxgaly.android.imdemo

import android.graphics.Color
import android.os.Build
import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.view.View
import android.view.WindowManager

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

    private fun setFullScreen() {
        window.setSoftInputMode(WindowManager.LayoutParams.SOFT_INPUT_ADJUST_RESIZE)
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.KITKAT) {
            if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {

                val option: Int = View.SYSTEM_UI_FLAG_LAYOUT_FULLSCREEN or View.SYSTEM_UI_FLAG_LAYOUT_STABLE
                window.decorView.systemUiVisibility = option
                window.addFlags(WindowManager.LayoutParams.FLAG_DRAWS_SYSTEM_BAR_BACKGROUNDS)
                window.statusBarColor = Color.TRANSPARENT
            } else {

                val param: WindowManager.LayoutParams = window.attributes
                var flagTranslucentStatus: Int = WindowManager.LayoutParams.FLAG_TRANSLUCENT_STATUS
                param.flags = param.flags or flagTranslucentStatus
                window.attributes = param

            }
        }

    }

}