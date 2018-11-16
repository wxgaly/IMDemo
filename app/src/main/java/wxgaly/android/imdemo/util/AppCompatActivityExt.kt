package wxgaly.android.imdemo.util

import android.arch.lifecycle.ViewModel
import android.arch.lifecycle.ViewModelProviders
import android.graphics.Color
import android.os.Build
import android.support.v4.app.Fragment
import android.support.v7.app.AppCompatActivity
import android.view.View
import android.view.WindowManager
import wxgaly.android.imdemo.application.IMApplication
import wxgaly.android.imdemo.viewmodel.ViewModelType
import wxgaly.android.imdemo.viewmodel.user.ViewModelFactory

/**
 * Created by WXGALY on 2017/11/13.
 */

fun <T : ViewModel> AppCompatActivity.obtainViewModel(viewModelClass: Class<T>, type: ViewModelType) =
        ViewModelProviders.of(this, ViewModelFactory.getInstance(application, type)).get(viewModelClass)

fun <T : ViewModel> Fragment.obtainViewModel(viewModelClass: Class<T>, type: ViewModelType) =
        ViewModelProviders.of(this, ViewModelFactory.getInstance(IMApplication.instance, type)).get(viewModelClass)


fun AppCompatActivity.setFullScreen() {
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