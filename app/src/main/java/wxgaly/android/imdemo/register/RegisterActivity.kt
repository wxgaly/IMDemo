package wxgaly.android.imdemo.register

import android.arch.lifecycle.Observer
import android.content.Intent
import android.databinding.DataBindingUtil
import wxgaly.android.imdemo.activity.BaseActivity
import wxgaly.android.imdemo.R
import wxgaly.android.imdemo.databinding.ActivityRegisterBinding
import wxgaly.android.imdemo.util.obtainViewModel
import wxgaly.android.imdemo.viewmodel.ViewModelType

/**
 * Created by WXGALY on 2017/11/20.
 */
class RegisterActivity : BaseActivity() {

    private lateinit var viewDataBinding: ActivityRegisterBinding

    override fun initData() {
        viewDataBinding = DataBindingUtil.setContentView(this, R.layout.activity_register)
        viewDataBinding.registerViewModel = obtainViewModel(RegisterViewModel::class.java, ViewModelType.USER_TYPE)

        val activity = this@RegisterActivity
        viewDataBinding.registerViewModel?.run {
            registerSuccessEvent.observe(activity, Observer {
                val userInfoIntent = Intent()
                userInfoIntent.putExtra(KEY_USERNAME, username.get())
                userInfoIntent.putExtra(KEY_PASSWORD, password.get())
                activity.setResult(REGISTER_SUCCESS_RESULT_CODE, userInfoIntent)
                finish()
            })
        }
    }

    override fun obtainViewModel(): RegisterViewModel = obtainViewModel(RegisterViewModel::class.java, ViewModelType.USER_TYPE)

}