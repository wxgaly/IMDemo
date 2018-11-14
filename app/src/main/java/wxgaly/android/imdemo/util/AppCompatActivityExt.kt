package wxgaly.android.imdemo.util

import android.arch.lifecycle.ViewModel
import android.arch.lifecycle.ViewModelProviders
import android.support.v7.app.AppCompatActivity
import wxgaly.android.imdemo.viewmodel.ViewModelType
import wxgaly.android.imdemo.viewmodel.user.ViewModelFactory

/**
 * Created by WXGALY on 2017/11/13.
 */

fun <T : ViewModel> AppCompatActivity.obtainViewModel(viewModelClass: Class<T>) =
        ViewModelProviders.of(this, ViewModelFactory.getInstance(application)).get(viewModelClass)

fun <T : ViewModel> AppCompatActivity.obtainViewModel(viewModelClass: Class<T>, type: ViewModelType) =
        ViewModelProviders.of(this, ViewModelFactory.getInstance(application, type)).get(viewModelClass)